package project.NetworkInterfaces.Packet.Protocol;

public class TCPFlag {
    private boolean URG;
    private boolean ACK;
    private boolean PSH;
    private boolean RST;
    private boolean SYN;
    private boolean FIN;

    public TCPFlag() {
    }

    public TCPFlag(
            boolean URG,
            boolean ACK,
            boolean PSH,
            boolean RST,
            boolean SYN,
            boolean FIN) {
        this.URG = URG;
        this.ACK = ACK;
        this.PSH = PSH;
        this.RST = RST;
        this.SYN = SYN;
        this.FIN = FIN;
    }

    // Getters & Setters
    public boolean isURG() {
        return this.URG;
    }

    public void setURG(boolean URG) {
        this.URG = URG;
    }

    public boolean isACK() {
        return this.ACK;
    }

    public void setACK(boolean ACK) {
        this.ACK = ACK;
    }

    public boolean isPSH() {
        return this.PSH;
    }

    public void setPSH(boolean PSH) {
        this.PSH = PSH;
    }

    public boolean isRST() {
        return this.RST;
    }

    public void setRST(boolean RST) {
        this.RST = RST;
    }

    public boolean isSYN() {
        return this.SYN;
    }

    public void setSYN(boolean SYN) {
        this.SYN = SYN;
    }

    public boolean isFIN() {
        return this.FIN;
    }

    public void setFIN(boolean FIN) {
        this.FIN = FIN;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t URG: " + isURG() + ", \n" +
                "\t ACK: " + isACK() + ", \n" +
                "\t PSH: " + isPSH() + ", \n" +
                "\t RST: " + isRST() + ", \n" +
                "\t SYN: " + isSYN() + ", \n" +
                "\t FIN: " + isFIN() + ", \n" +
            "]";
    }
}
