package server;

import api.Api;
import api.LCR;
import api.RingList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;

public class ApiImp extends UnicastRemoteObject implements Api {
    private static final long serialVersionUID = 1;
    public RingList cl;
    public LCR lcr;

    public ApiImp() throws RemoteException {
        super();
    }

    public String setRing() throws RemoteException {

        //Adds data to the list
        cl = new RingList();

        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = 4;
        for (int i = 1; i <= size; i++) {
            arrayList.add(i);
        }

        Collections.shuffle(arrayList);

        for (int j = 1; j <= size; j++) {
            cl.append(j, arrayList.get(j - 1));
        }

        return "RingList created with dummy data set";

    }

    @Override
    public String displayNodes() throws RemoteException {
        return cl.display();
    }

    @Override
    public String startLCR() throws RemoteException {
        lcr = new LCR(cl);
        return lcr.election();
    }

    @Override
    public void NotifyAll() throws RemoteException {
        System.out.println("Notifying all");
        lcr.notify_all();
    }

    @Override
    public String messageDisplay() throws RemoteException {
        return "1\t:\tAppend a node to the list\n2\t:\tDisplay Nodes\n3\t:\tInsert a node in between\n4\t:\tStart the Election";
    }

    @Override
    public String appendToList(int UID) throws RemoteException {
        int index = cl.tail.index + 1;
        if (!cl.checkUID(UID)) {
            cl.append(index, UID);
            return "Append Successful";
        } else {
            return "Append Failed UID already exists";
        }
    }

    @Override
    public String InsertInNode(int index, int UID) throws RemoteException {
        return cl.InsertAfter(index, UID);

    }
}
