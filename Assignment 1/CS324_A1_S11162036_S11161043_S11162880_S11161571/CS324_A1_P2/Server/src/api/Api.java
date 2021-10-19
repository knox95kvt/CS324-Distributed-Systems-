package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Api extends Remote {

    String setRing()throws RemoteException;

    String displayNodes() throws RemoteException;

    String startLCR() throws RemoteException;

    void NotifyAll() throws RemoteException;
}
