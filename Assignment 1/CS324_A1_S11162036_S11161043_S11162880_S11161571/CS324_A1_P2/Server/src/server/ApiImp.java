package server;

import api.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ApiImp extends UnicastRemoteObject implements Api{
    private static final long serialVersionUID = 1;
    public RingList cl;
    public LCR lcr;

    public ApiImp() throws RemoteException {
        super();
    }
    public String setRing() throws RemoteException {

        //Adds data to the list
        cl = new RingList();
        cl.append(0,5);
        cl.append(1,4);
        cl.append(2,7);
        cl.append(3,1);

        return "RingList created with dummy data set";

    }

    @Override
    public String displayNodes() throws RemoteException{
        return cl.display();
    }
    @Override
    public String startLCR() throws RemoteException {
        lcr = new LCR(cl);
        return lcr.election();
    }

    @Override
    public void NotifyAll() throws RemoteException{
        System.out.println("Notifying all");
        lcr.notify_all();
    }

}
