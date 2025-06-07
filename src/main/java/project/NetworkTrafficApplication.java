package project;

import project.NetworkInterfaces.Model.IPv4Address;
import project.NetworkInterfaces.Service.NetworkService;
import java.util.Scanner;

public class NetworkTrafficApplication {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\t\t Network Packet Traffic");
        System.out.println("Select and Option:");
        System.out.println(
            "\tA. Capture Network Traffic via IPv4 Address." +
            "\n\tB. Show all Netowork Traffic Interfaces."
        );

        System.out.print("Enter option here: ");
        String option = scan.nextLine().toUpperCase();

        while (!option.equals("A") && !option.equals("B")) {
            System.out.println("\nPlease, enter a value of A or B");
            System.out.print("Enter option here: ");
            option = scan.nextLine().toUpperCase();
        }

        switch (option) {
            case "A":
                IPv4Address iPv4Address = new IPv4Address();

                System.out.print("\n Please, enter your IPV4 Addres: ");
                iPv4Address.setIPv4Address(scan.nextLine());

                while(!iPv4Address.isValidIPv4Address()) {
                    System.out.print("\n IPv4 Address is invalid or incorrect format.");
                    System.out.print("\n Please, enter a valid IPV4 Addres: ");
                    iPv4Address.setIPv4Address(scan.nextLine());

                    if(iPv4Address.isValidIPv4Address()) break;
                }

                NetworkService service = new NetworkService(iPv4Address.getIPv4Address());
                service.startNetworkTrafficPacketCapture();
            break;

            case "B":
            break;

            default:
            break;
        }

        scan.close();
    }
}