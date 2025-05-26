package project;

import org.pcap4j.core.*;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.packet.Packet;
import org.pcap4j.util.NifSelector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            PcapNetworkInterface deviceInterface = new NifSelector().selectNetworkInterface();

            if(deviceInterface == null) {
                System.out.println("No device interface has been chosen!");
                System.exit(1);
            }

            int snapshotLength = 65536;
            int readTimeout = 50;
            final PcapHandle handle = deviceInterface.openLive(snapshotLength, PromiscuousMode.PROMISCUOUS, readTimeout);

            PacketListener listener = new PacketListener() {
                @Override
                public void gotPacket(Packet packet) {
                    System.out.println(handle.getTimestamp());
                    System.out.println(packet);
                }
            };

            int maxPacketValue = 50;
            handle.loop(maxPacketValue, listener);
            handle.close();
        } catch (PcapNativeException | IOException | NotOpenException | InterruptedException exc) {
            throw new RuntimeException(exc);
        }
    }
}