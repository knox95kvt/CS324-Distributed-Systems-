package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Api extends Remote {

    public String setRing() throws RemoteException;

    public String displayNodes() throws RemoteException;

    public String startLCR() throws RemoteException;

    public void NotifyAll() throws RemoteException;

    public String messageDisplay() throws RemoteException;

    public String appendToList(int UID) throws RemoteException;

    public String InsertInNode(int index, int UID) throws RemoteException;
}
