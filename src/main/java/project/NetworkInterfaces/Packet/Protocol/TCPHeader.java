package project.NetworkInterfaces.Packet.Protocol;

public class TCPHeader {
    private int sourcePort;
    private int destinationPort;
    private long sequenceNumber;
    private long acknowledgmentNumber;
    private int dataOffset;
    private int reserved;
    private int window;
    private String checksum;
    private int urgentPointer;
    private TCPFlag flags;

    public TCPHeader() {
    }

    public TCPHeader(
            int sourcePort,
            int destinationPort,
            long sequenceNumber,
            long acknowledgmentNumber,
            int dataOffset,
            int reserved,
            int window,
            String checksum,
            int urgentPointer,
            TCPFlag flags) {
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.sequenceNumber = sequenceNumber;
        this.acknowledgmentNumber = acknowledgmentNumber;
        this.dataOffset = dataOffset;
        this.reserved = reserved;
        this.window = window;
        this.checksum = checksum;
        this.urgentPointer = urgentPointer;
        this.flags = flags;
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

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public long getAcknowledgmentNumber() {
        return this.acknowledgmentNumber;
    }

    public void setAcknowledgmentNumber(long acknowledgmentNumber) {
        this.acknowledgmentNumber = acknowledgmentNumber;
    }

    public int getDataOffset() {
        return this.dataOffset;
    }

    public void setDataOffset(int dataOffset) {
        this.dataOffset = dataOffset;
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getWindow() {
        return this.window;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public int getUrgentPointer() {
        return this.urgentPointer;
    }

    public void setUrgentPointer(int urgentPointer) {
        this.urgentPointer = urgentPointer;
    }

    public TCPFlag getFlags() {
        return this.flags;
    }

    public void setFlags(TCPFlag flags) {
        this.flags = flags;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t Source Port: " + getSourcePort() + ", \n" +
                "\t Destionation Port: " + getDestinationPort() + ", \n" +
                "\t Acknowledgment Number: " + getAcknowledgmentNumber() + ", \n" +
                "\t Data Offset: " + getDataOffset() + ", \n" +
                "\t Reserved: " + getReserved() + ", \n" +
                "\t Window: " + getWindow() + ", \n" +
                "\t Checksum: " + getChecksum() + ", \n" +
                "\t Urgent Pointer: " + getUrgentPointer() + ", \n" +
                "\t Flags: " + getFlags() + ", \n" +
            "]";
    }
}