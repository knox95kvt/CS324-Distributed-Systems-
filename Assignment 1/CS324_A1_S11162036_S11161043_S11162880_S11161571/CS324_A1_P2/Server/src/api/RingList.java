package api;

import java.util.UUID;

public class RingList {
    //Declaring head and tail pointer as null.  
    public Node head = null;
    public Node tail = null;
    private boolean election_in_progress = false;
    static int index = 0;
    private boolean auto;
    private int nodes;

    public RingList() {
        this(0,false );
    }

    RingList(int nodes, boolean auto){
        this.nodes = nodes;
        this.auto = auto;

        if (auto){
            autoList();
        }
    }

    private void autoList(){
        for(index = 0; index < this.nodes; index++){
            UUID uuid= UUID.randomUUID(); //Generates random UUID
            System.out.println(index);
            //append(index,uuid);
        }
    }


    //This function will append the new node at the end of the list.  
    public void append(int index, int uid ){

        if (!election_in_progress){ // check if election is currently happening
            //Create new node
            Node newNode = new Node(index, uid);
            //Checks if the list is empty.
            if(head == null) {
                //If list is empty, both head and tail would point to new node.
                head = newNode;
                tail = newNode;
                head.next = tail;
                tail.prev = head;

            }
            else {
                //tail will point to new node.
                tail.next = newNode;
                //New node will become new tail.
                newNode.prev = tail;
                tail = newNode;
                //Since, it is circular linked list tail will point to head.
                tail.next = head;
                head.prev = tail;
            }
        }
        else{
            System.out.println("Election is progress. Please try again later. Thanks :-)");
        }
    }

    //Displays all the nodes in the list  
    public String display() {
        Node current = head;
        String dis = "";

        if(head == null) {
            dis +="List is empty";
        }
        else {
            dis += "Nodes : \n";

            do{
                //Prints each node by incrementing pointer.  
                //System.out.println("prev node "+ current.prev.index);
                 dis += "    >> Node: "+ current.index + "\tUID: "+ current.getUID() +"\n";

                current = current.next;
            }while(current != head);
            dis += "\n";

        }
        return dis;
    }


    public int size(){
        int s = 0;
        Node current = head;
        do{
            s++;
            current = current.next;
        }while(current!=head);

        return s;
    }
}