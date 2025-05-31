package project.NetworkInterfaces.Packet.Protocol;

public class UDPHeader {
    private int sourcePort;
    private int destinationPort;
    private int length;
    private String checkSum;

    public UDPHeader() {
    }

    public UDPHeader(
            int sourcePort,
            int destinationPort,
            int length,
            String checkSum) {
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.length = length;
        this.checkSum = checkSum;
    }

    // Getters & Setters
    public int getSourcePort() {
        return this.sourcePort;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public int getDestinationPort() {
        return this.destinationPort;
    }

    public void setDestinationPort(int destinationPort) {
        this.destinationPort = destinationPort;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t Source Port: " + getSourcePort() + ", \n" +
                "\t Destionation Port: " + getDestinationPort() + ", \n" +
                "\t Length: " + getLength() + ", \n" +
                "\t Checksum: " + getCheckSum() + ", \n" +
            "\b]";
    }
}
