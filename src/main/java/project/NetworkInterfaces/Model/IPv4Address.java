package project.NetworkInterfaces.Model;

public class IPv4Address {
    private String IPv4Address;
    private boolean validIPv4Address = true;
    private String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
    
    public IPv4Address() {}

    public IPv4Address(String IPv4Address) {
        this.validIPv4Address = IPv4Address.matches(PATTERN);
        this.IPv4Address = IPv4Address;
    }

    //Getters & Setters
    public void setIPv4Address(String IPv4Address) {
        this.validIPv4Address = IPv4Address.matches(PATTERN);
        this.IPv4Address = IPv4Address;
    }

    public String getIPv4Address() {
        return this.IPv4Address;
    }

    public boolean isValidIPv4Address() {
        return this.validIPv4Address;
    }
}
