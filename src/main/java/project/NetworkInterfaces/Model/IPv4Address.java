package project.NetworkInterfaces.Model;

public class IPv4Address {
    private String IPv4Address;
    
    public IPv4Address() {}

    public IPv4Address(String IPv4Address) {
        this.IPv4Address = IPv4Address;
    }

    //Getters & Setters
    public void setIPv4Address(String IPv4Address) {
        this.IPv4Address = IPv4Address;
    }

    public String getIPv4Address() {
        return this.IPv4Address;
    }
}
