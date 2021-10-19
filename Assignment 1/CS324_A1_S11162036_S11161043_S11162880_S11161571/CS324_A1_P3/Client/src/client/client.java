package client;

import api.Api;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class client {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;


    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        Api remoteApi = (Api) registry.lookup(Api.class.getSimpleName());
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println(">> Connected to server");
        System.out.println(">> Ring Initialized ");
        System.out.println(">> " + remoteApi.setRing());
        System.out.println(">> Nodes Displayed ");
        System.out.println(">> " + remoteApi.displayNodes());
        boolean condition = true;
        while (condition){
            System.out.println(remoteApi.messageDisplay());
            System.out.print(">> ");
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.print("Enter the UID: \n>> ");
                int UID = scanner.nextInt();
                System.out.println(remoteApi.appendToList(UID) + "\n");

            }
            else if (choice == 2){
                System.out.println(">> Displaying Nodes");
                System.out.println(">> " + remoteApi.displayNodes());
            }
            else if (choice == 3){
                System.out.print("Enter the index: \n>> ");
                int index = scanner.nextInt();
                System.out.print("Enter the UID: \n>> ");
                int UID = scanner.nextInt();
                System.out.println(">>" + remoteApi.InsertInNode(index, UID));
            }
            else if (choice == 4){
                System.out.println(">> Election protocol Starting");
                System.out.println(">> " + remoteApi.startLCR());
                System.out.println(">> NotifyAll\n");
                remoteApi.NotifyAll();
            }
            else {
                System.out.println("Invalid input");
            }
        }




    }
}
