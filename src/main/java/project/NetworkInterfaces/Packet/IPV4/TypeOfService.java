package project.NetworkInterfaces.Packet.IPV4;

public class TypeOfService {
    private int precendence;
    private int typeOfService;
    private int mustBeZero;

    public TypeOfService() {}

    public TypeOfService(int precendence, int typeOfService, int mustBeZero) {
        this.precendence = precendence;
        this.typeOfService = typeOfService;
        this.mustBeZero = mustBeZero;
    }

    //Getters & Setters
    public void setPrecendence(int precendence) {
        this.precendence = precendence;
    }

    public int getPrecendence() {
        return this.precendence;
    }

    public void setTypeOfService(int typeOfService) {
        this.typeOfService = typeOfService;
    }

    public int getTypeOfService() {
        return this.typeOfService;
    }

    public void setMustBeZero(int mustBeZero) {
        this.mustBeZero = mustBeZero;
    }

    public int getMustBeZero() {
        return this.mustBeZero;
    }

}
