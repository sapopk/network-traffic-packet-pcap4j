package project.NetworkInterfaces.Packet.Ethernet;

public class EthernetHeader {
    private String destinationAddress;
    private String sourceAddress;
    private String type;

    public EthernetHeader() {}

    public EthernetHeader(String destinationAddress, String sourceAddress, String type) {
        this.destinationAddress = destinationAddress;
        this.sourceAddress = sourceAddress;
        this.type = type;
    }

    // Getters & Setters
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getDestinationAddress() {
        return  this.destinationAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t Destination Address: " + getDestinationAddress() + ", \n" +
                "\t Source Address: " + getSourceAddress() + ", \n" +
                "\t Type: " + getType() + ", \n" +
            "\b ]";
    }
}