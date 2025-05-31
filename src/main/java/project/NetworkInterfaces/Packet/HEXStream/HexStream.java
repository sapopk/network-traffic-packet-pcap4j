package project.NetworkInterfaces.Packet.HEXStream;

public class HexStream {
    private int length;
    private String hexStream;

    public HexStream() {
    }

    public HexStream(int length, String hexStream) {
        this.length = length;
        this.hexStream = hexStream;
    }

    // Getters & Setters
    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public void setHexStream(String hexStream) {
        this.hexStream = hexStream;
    }

    public String getHexStream() {
        return this.hexStream;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t Length: " + getLength() + ",\n" +
                "\t Hex Stream: " + getHexStream() + 
            "\n\b ]";
    }
}
