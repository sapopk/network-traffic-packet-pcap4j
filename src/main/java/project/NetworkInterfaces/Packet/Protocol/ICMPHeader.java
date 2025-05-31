package project.NetworkInterfaces.Packet.Protocol;

public class ICMPHeader {
    private int type;
    private int code;
    private String checkSum;

    public ICMPHeader() {
    }

    public ICMPHeader(int type, int code, String checkSum) {
        this.type = type;
        this.code = code;
        this.checkSum = checkSum;
    }

    // Getters & Setters
    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t Type: " + getType() + ", \n" +
                "\t Code: " + getCode() + ", \n" +
                "\t Checksum: " + getCheckSum() + ", \n" +
            "]";
    }
}