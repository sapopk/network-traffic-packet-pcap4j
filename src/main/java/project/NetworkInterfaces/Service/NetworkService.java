package project.NetworkInterfaces.Service;

import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PacketListener;
import org.pcap4j.core.PcapAddress;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.DnsPacket;
import org.pcap4j.packet.EthernetPacket;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.TcpPacket;
import org.pcap4j.packet.UdpPacket;

import project.NetworkInterfaces.Packet.PacketLogger;
import project.NetworkInterfaces.Packet.Ethernet.EthernetHeader;
import project.NetworkInterfaces.Packet.HEXStream.HexStream;
import project.NetworkInterfaces.Packet.IPV4.IPV4Flag;
import project.NetworkInterfaces.Packet.IPV4.IPV4Header;
import project.NetworkInterfaces.Packet.IPV4.TypeOfService;
import project.NetworkInterfaces.Packet.Protocol.DNSHeader;
import project.NetworkInterfaces.Packet.Protocol.TCPFlag;
import project.NetworkInterfaces.Packet.Protocol.TCPHeader;
import project.NetworkInterfaces.Packet.Protocol.UDPHeader;

public class NetworkService {
    private List<PacketLogger> packetLoggers = new CopyOnWriteArrayList<>();
    private String targetIPAddress = "";

    public List<PacketLogger> getPackerLoggers() {
        return this.packetLoggers;
    }

    public void startNetworkTrafficPacketCapture() {
        new Thread(() -> {
            try {
                List<PcapNetworkInterface> listOfAllInterfaces = Pcaps.findAllDevs();
                PcapNetworkInterface interfaceDevices = null;

                for (PcapNetworkInterface listOfDevs : listOfAllInterfaces) {
                    for (PcapAddress address : listOfDevs.getAddresses()) {
                        if (address.getAddress() instanceof InetAddress
                                && address.getAddress().getHostAddress().equals(targetIPAddress)) {
                            interfaceDevices = listOfDevs;
                            break;
                        }
                    }

                    if (interfaceDevices != null) {
                        break;
                    }
                }

                if (interfaceDevices == null) {
                    System.err.println("No interface device has been found for address: " + targetIPAddress);
                }

                PcapHandle handler = interfaceDevices.openLive(65536, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS,
                        1000);

                PacketListener packetListener = packet -> {
                    PacketLogger logger = new PacketLogger();
                    logger.setTimeStamp(handler.getTimestamp().toString());

                    setEthernetHeader(packet, logger);

                    packetLoggers.add(logger);
                };

                handler.loop(10, packetListener);
                handler.close();

            } catch (PcapNativeException | InterruptedException | NotOpenException exception) {
                throw new RuntimeException(exception);
            }
        }).start();
    }

    public void setEthernetPacket(Packet packet, PacketLogger logger) {
        EthernetPacket ethernetPacket = packet.get(EthernetPacket.class);

        if (ethernetPacket != null) {
            EthernetHeader ethernetHeader = new EthernetHeader(
                    ethernetPacket.getHeader().getSrcAddr().toString(),
                    ethernetPacket.getHeader().getDstAddr().toString(),
                    ethernetPacket.getHeader().getType().toString());

            logger.setEthernetHeader(ethernetHeader);
        }
    }

    public void setIPv4Packet(Packet packet, PacketLogger logger) {
        IpV4Packet ipV4Packet = packet.get(IpV4Packet.class);

        if (ipV4Packet != null) {

            String checkSumvalue = "0x" + Integer.toHexString(ipV4Packet.getHeader().getHeaderChecksum());

            IPV4Flag ipv4Flag = new IPV4Flag(
                    ipV4Packet.getHeader().getReservedFlag(),
                    ipV4Packet.getHeader().getDontFragmentFlag(),
                    ipV4Packet.getHeader().getMoreFragmentFlag());

            TypeOfService typeOfService = new TypeOfService(
                    ipV4Packet.getHeader().getTos().value(),
                    ipV4Packet.getHeader().getTos().value(),
                    ipV4Packet.getHeader().getTos().value());

            IPV4Header ipv4Header = new IPV4Header(
                    ipV4Packet.getHeader().getVersion().value(),
                    ipV4Packet.getHeader().getIhl(),
                    ipV4Packet.getHeader().getTotalLength(),
                    ipV4Packet.getHeader().getIdentificationAsInt(),
                    ipV4Packet.getHeader().getFragmentOffset(),
                    ipV4Packet.getHeader().getTtl(),
                    ipV4Packet.getHeader().getProtocol().value(),
                    checkSumvalue,
                    ipV4Packet.getHeader().getSrcAddr().getHostAddress(),
                    ipV4Packet.getHeader().getDstAddr().getHostAddress(),
                    ipv4Flag,
                    typeOfService);

            logger.setIpv4Header(ipv4Header);
        }
    }

    public void setTCPPacket(Packet packet, PacketLogger logger) {
        TcpPacket tcpPacket = packet.get(TcpPacket.class);

        if (tcpPacket != null) {

            String checkSumValue = "0x" + Integer.toHexString(tcpPacket.getHeader().getChecksum());

            TCPFlag tcpFlag = new TCPFlag(
                    tcpPacket.getHeader().getUrg(),
                    tcpPacket.getHeader().getAck(),
                    tcpPacket.getHeader().getPsh(),
                    tcpPacket.getHeader().getRst(),
                    tcpPacket.getHeader().getSyn(),
                    tcpPacket.getHeader().getFin());

            TCPHeader tcpHeader = new TCPHeader(
                    tcpPacket.getHeader().getSrcPort().valueAsInt(),
                    tcpPacket.getHeader().getDstPort().valueAsInt(),
                    tcpPacket.getHeader().getSequenceNumber(),
                    tcpPacket.getHeader().getAcknowledgmentNumber(),
                    tcpPacket.getHeader().getDataOffset(),
                    tcpPacket.getHeader().getReserved(),
                    tcpPacket.getHeader().getWindow(),
                    checkSumValue,
                    tcpPacket.getHeader().getUrgentPointer(),
                    tcpFlag);

            HexStream hexStream = new HexStream();
            if (tcpPacket.getPayload() != null) {
                byte[] pureData = tcpPacket.getPayload().getRawData();
                hexStream.setLength(pureData.length);
                hexStream.setHexStream(defineBytesToHexStream(pureData));
            }

            logger.setTcpHeader(tcpHeader);
            logger.setHexStream(hexStream);
        }
    }

    public String defineBytesToHexStream(byte[] bytes) {
        StringBuffer builder = new StringBuffer();

        for (byte b : bytes) {
            builder.append(String.format("%20x", b)).append(" ");
        }

        return builder.toString().trim();
    }

    public void setUDPPacket(Packet packet, PacketLogger logger) {
        UdpPacket udpPacket = packet.get(UdpPacket.class);

        if (udpPacket != null) {

            String checkSumValue = String.format("0x%04x", udpPacket.getHeader().getChecksum());

            UDPHeader udpHeader = new UDPHeader(
                    udpPacket.getHeader().getSrcPort().value(),
                    udpPacket.getHeader().getDstPort().value(),
                    udpPacket.getHeader().getLength(),
                    checkSumValue);

            logger.setUdpHeader(udpHeader);
        }
    }

    public void setDNSPacket(Packet packet, PacketLogger logger) {
        DnsPacket dnsPacket = packet.get(DnsPacket.class);

        if(dnsPacket != null) {
            DNSHeader dnsHeader = new DNSHeader(
                    dnsPacket.getHeader().getId(),
                    dnsPacket.getHeader().getOpCode().name(),
                    dnsPacket.getHeader().getrCode().name(),
                    dnsPacket.getHeader().getQdCountAsInt(),
                    dnsPacket.getHeader().getAnCount());

                logger.setDnsHeader(dnsHeader);
        }
    }

    
}
