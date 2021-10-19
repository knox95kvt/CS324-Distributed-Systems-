package server;

/*
| Inoke Nakacia |S11162036| 100% |
| Marineta Wata |S11161571| 100% |
| Avnish Kumar  |S11162880| 100% |
| Ajnesh Prasad |S11161043| 100% |
 */

import api.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    private void startServer(){
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // create a new service named myMessage

            new RingList();
            registry.rebind(Api.class.getSimpleName(), new ApiImp());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("CS324 : Assignment 1");
        System.out.println("PART 2: Implementing Leader Election Protocol using RMI");
        System.out.println("system is ready");
    }

    public static void main(String[] args) {
        server main = new server();
        main.startServer();
    }
}
