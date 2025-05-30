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

import project.NetworkInterfaces.Packet.PacketLogger;

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

                for(PcapNetworkInterface listOfDevs : listOfAllInterfaces) {
                    for(PcapAddress address : listOfDevs.getAddresses()) {
                        if(address.getAddress() instanceof InetAddress && address.getAddress().getHostAddress().equals(targetIPAddress)) {
                            interfaceDevices = listOfDevs;
                            break;
                        }
                    }

                    if(interfaceDevices != null) {
                        break;
                    }
                }

                if(interfaceDevices == null) {
                    System.err.println("No interface device has been found for address: " + targetIPAddress);
                }

                PcapHandle handler = interfaceDevices.openLive(65536, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, 1000);

                PacketListener packetListener = packet -> {
                    PacketLogger logger = new PacketLogger();
                    logger.setTimeStamp(handler.getTimestamp().toString());

                    //TODO : Add 'Set' values from packet to OOPs.
                    
                    packetLoggers.add(logger);
                }

                handler.loop(10, packetListener);
                handler.close();

            } catch (PcapNativeException | InterruptedException | NotOpenException exception) {
                throw new RuntimeException(exception);
            }
        }).start();
    }
}
