package project.NetworkInterfaces.Packet;

import project.NetworkInterfaces.Packet.Ethernet.EthernetHeader;
import project.NetworkInterfaces.Packet.HEXStream.HexStream;
import project.NetworkInterfaces.Packet.IPV4.IPV4Header;
import project.NetworkInterfaces.Packet.Protocol.DNSHeader;
import project.NetworkInterfaces.Packet.Protocol.ICMPHeader;
import project.NetworkInterfaces.Packet.Protocol.TCPHeader;
import project.NetworkInterfaces.Packet.Protocol.UDPHeader;

public class PacketLogger {
    private String timeStamp;
    private EthernetHeader ethernetHeader;
    private IPV4Header ipv4Header;

    private TCPHeader tcpHeader;
    private UDPHeader udpHeader;
    private ICMPHeader icmpHeader;
    private DNSHeader dnsHeader;

    private HexStream hexStream;

    public PacketLogger() {
    }

    public PacketLogger(
            String timeStamp,
            EthernetHeader ethernetHeader,
            IPV4Header ipv4Header,
            TCPHeader tcpHeader,
            UDPHeader udpHeader,
            ICMPHeader icmpHeader,
            DNSHeader dnsHeader,
            HexStream hexStream) {
        this.timeStamp = timeStamp;
        this.ethernetHeader = ethernetHeader;
        this.ipv4Header = ipv4Header;
        this.tcpHeader = tcpHeader;
        this.udpHeader = udpHeader;
        this.icmpHeader = icmpHeader;
        this.dnsHeader = dnsHeader;
        this.hexStream = hexStream;
    }

    // Getters & Setters
    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public EthernetHeader getEthernetHeader() {
        return this.ethernetHeader;
    }

    public void setEthernetHeader(EthernetHeader ethernetHeader) {
        this.ethernetHeader = ethernetHeader;
    }

    public IPV4Header getIpv4Header() {
        return this.ipv4Header;
    }

    public void setIpv4Header(IPV4Header ipv4Header) {
        this.ipv4Header = ipv4Header;
    }

    public TCPHeader getTcpHeader() {
        return this.tcpHeader;
    }

    public void setTcpHeader(TCPHeader tcpHeader) {
        this.tcpHeader = tcpHeader;
    }

    public UDPHeader getUdpHeader() {
        return this.udpHeader;
    }

    public void setUdpHeader(UDPHeader udpHeader) {
        this.udpHeader = udpHeader;
    }

    public ICMPHeader getIcmpHeader() {
        return this.icmpHeader;
    }

    public void setIcmpHeader(ICMPHeader icmpHeader) {
        this.icmpHeader = icmpHeader;
    }

    public DNSHeader getDnsHeader() {
        return this.dnsHeader;
    }

    public void setDnsHeader(DNSHeader dnsHeader) {
        this.dnsHeader = dnsHeader;
    }

    public HexStream getHexStream() {
        return this.hexStream;
    }

    public void setHexStream(HexStream hexStream) {
        this.hexStream = hexStream;
    }

    @Override
    public String toString() {
        return 
            "Packet Logger: { \n" +
                "\b\b Time Stamp: " + getTimeStamp() + ",\n" +
                "\b\b Ethernet Header: " + getEthernetHeader() + ",\n" +
                "\b\b IPV4 Header: " + getIpv4Header() + ",\n" +
                "\b\b UDP Header: " + getUdpHeader() + ",\n" +
                "\b\b ICMP Header: " + getIcmpHeader() + ",\n" +
                "\b\b DNS Header: " + getDnsHeader() + ",\n" +
                "\b\b HEX Stream: " + getHexStream() + ",\n" +
            "} \n";
    }
}
