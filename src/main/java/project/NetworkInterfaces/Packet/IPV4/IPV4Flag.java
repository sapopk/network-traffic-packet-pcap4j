package project.NetworkInterfaces.Packet.IPV4;

public class IPV4Flag {
    private boolean reserved;
    private boolean dontFragment;
    private boolean moreFragments;

    public IPV4Flag() {
    }

    public IPV4Flag(
            boolean reserved,
            boolean dontFragment,
            boolean moreFragments) {
        this.reserved = reserved;
        this.dontFragment = dontFragment;
        this.moreFragments = moreFragments;
    }

    // Getters & Setters
    public void isReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean getReserved() {
        return this.reserved;
    }

    public void isDontFragment(boolean dontFragment) {
        this.dontFragment = dontFragment;
    }

    public boolean getDontFragment() {
        return this.dontFragment;
    }

    public void isMoreFragments(boolean moreFragments) {
        this.moreFragments = moreFragments;
    }

    public boolean getMoreFragments() {
        return this.moreFragments;
    }

    @Override
    public String toString() {
        return 
            "[ \n" +
                "\t\t Reserved: " + getReserved() + ", \n" +
                "\t\t Dont Fragment: " + getDontFragment() + ", \n" +
                "\t\t More Fragment: " + getMoreFragments() + ", \n" +
            "\t]";
    }
}
