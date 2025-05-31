package project;

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

        while (!option.equalsIgnoreCase("A") || !option.equalsIgnoreCase("B")) {
            System.out.println("\nPlease, enter a value of A or B");
            System.out.print("Enter option here: ");
            option = scan.nextLine().toUpperCase();

            if(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("B")) break;
        }

        switch (option) {
            case "A":
                System.out.print("\n Please, enter your IPV4 Addres: ");
                NetworkService service = new NetworkService();
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