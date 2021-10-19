package server;

import api.Api;
import api.RingList;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        server main = new server();
        main.startServer();
    }

    private void startServer() {
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // create a new service named myMessage

            RingList ringlist = new RingList();
            registry.rebind(Api.class.getSimpleName(), new ApiImp());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("CS324 Assignment 1 : Part 3");
        System.out.println("Implementing Leader Election Protocol with Peer Register using RMI");
        System.out.println("system is ready");
    }
}
