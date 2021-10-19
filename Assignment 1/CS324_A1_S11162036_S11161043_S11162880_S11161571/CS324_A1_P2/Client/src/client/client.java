package client;

/*
| Inoke Nakacia |S11162036| 100% |
| Marineta Wata |S11161571| 100% |
| Avnish Kumar  |S11162880| 100% |
| Ajnesh Prasad |S11161043| 100% |
 */

import api.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;



    public static void main(String[] args) throws Exception {
        registry = LocateRegistry.getRegistry(HOST, PORT);
        Api remoteApi = (Api) registry.lookup(Api.class.getSimpleName());
        System.out.println(">> Server Connected");
        System.out.println(">> Ring Initialized");
        System.out.println(">> " + remoteApi.setRing());
        System.out.println(">> Displaying of Nodes");
        System.out.println(">> " + remoteApi.displayNodes());
        System.out.println();
        System.out.println(">> Election protocol Starting");
        System.out.println(">> " + remoteApi.startLCR());
        System.out.println(">> NotifyAll !");
        remoteApi.NotifyAll();




    }
}
