package project.NetworkInterfaces.Packet.IPV4;

public class IPV4Header {
    private int version;
    private int internetHeaderLength;
    private int totalLength;
    private int identification;
    private int fragmentOffSet;
    private int timeToLive;
    private int protocol;
    private String headerCheckSum;
    private String sourceAddress;
    private String destinationAddress;

    private IPV4Flag flag;
    private TypeOfService typeOfService;

    public IPV4Header() {
    }

    public IPV4Header(
            int version,
            int internetHeaderLength,
            int totalLength,
            int identification,
            int fragmentOffSet,
            int timeToLive,
            int protocol,
            String headerCheckSum,
            String sourceAddress,
            String destinationAddress,
            IPV4Flag flag,
            TypeOfService typeOfService) {
        this.version = version;
        this.internetHeaderLength = internetHeaderLength;
        this.totalLength = totalLength;
        this.identification = identification;
        this.fragmentOffSet = fragmentOffSet;
        this.timeToLive = timeToLive;
        this.protocol = protocol;
        this.headerCheckSum = headerCheckSum;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.flag = flag;
        this.typeOfService = typeOfService;
    }

    // Getters & Setters
    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return this.version;
    }

    public void setInternetHeaderLength(int internetHeaderLength) {
        this.internetHeaderLength = internetHeaderLength;
    }

    public int getInternetHeaderLength() {
        return this.internetHeaderLength;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public int getTotalLength() {
        return this.totalLength;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public int getIdentification() {
        return identification;
    }

    public void setFragmentOffSet(int fragmentOffSet) {
        this.fragmentOffSet = fragmentOffSet;
    }

    public int getFragmentOffSet() {
        return this.fragmentOffSet;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public int getTimeToLive() {
        return this.timeToLive;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setHeaderCheckSum(String headerCheckSum) {
        this.headerCheckSum = headerCheckSum;
    }

    public String getHeaderCheckSum() {
        return headerCheckSum;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getDestinationAddress() {
        return this.destinationAddress;
    }

    public void setFlag(IPV4Flag flag) {
        this.flag = flag;
    }

    public IPV4Flag getFlag() {
        return this.flag;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

    public TypeOfService getTypeOfService() {
        return this.typeOfService;
    }

    @Override
    public String toString() {
        return 
            "[ " +
                "\n\t Version: " + getVersion() + ", \n" +
                "\t Internet Header Length: " + getInternetHeaderLength() + ", \n" +
                "\t Total Length: " + getTotalLength() + ", \n" +
                "\t Identification: " + getIdentification() + ", \n" +
                "\t Fragment Offset: " + getFragmentOffSet() + ", \n" +
                "\t Time to Live: " + getTimeToLive() + ", \n" +
                "\t Protocol: " + getProtocol() + ", \n" +
                "\t Header Checksum: " + getHeaderCheckSum() + ", \n" +
                "\t Source Address: " + getSourceAddress() + ", \n" +
                "\t Destination Address: " + getDestinationAddress() + ", \n" +
                "\t IPV4 Flag Header: " + getFlag() + ", \n" +
                "\t Type of Service: " + getTypeOfService() + ", \n" +
            "\b ]";
    }
}
