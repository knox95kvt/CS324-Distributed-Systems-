package api;

public class RingList {
    //Declaring head and tail pointer as null.  
    public Node head = null;
    public Node tail = null;
    private Node controller;
    private boolean election_in_progress = false;


    public RingList() {

        controller = new Node(-1, -1, true);
        append(-1, -1, true);
    }


    public void append(int index, int uid) {
        append(index, uid, false);
    }

    //This function will append the new node at the end of the list.
    public void append(int index, int uid, boolean register) {

        if (!isElection_in_progress()) { // check if election is currently happening
            //Create new node
            Node newNode = new Node(index, uid, register);
            //Checks if the list is empty.
            if (head == null) {
                //If list is empty, both head and tail would point to new node.
                head = newNode;
                tail = newNode;
                head.next = tail;
                tail.prev = head;
                controller.next = head;
            } else {
                //tail will point to new node.
                tail.next = newNode;
                //New node will become new tail.
                newNode.prev = tail;
                tail = newNode;
                //Since, it is circular linked list tail will point to head.
                tail.next = head;
                head.prev = tail;
            }
            controller.prev = tail;
        } else {
            System.out.println("Election is progress. Please try again later. Thanks :-)");
        }
    }

    public String InsertAfter(int prev_index, int UID) {
        Node prev = getNode(prev_index);
        int index = prev_index + 1;
        if (prev == null) {
            return "The given previous cannot be NULL";
        }
        Node new_node = new Node(index, UID, false);
        new_node.next = prev.next;
        prev.next = new_node;
        new_node.prev = prev;
        Node Next_node = new_node.next;
        Next_node.prev = new_node;
        index += 1;

        do {
            if (Next_node.isRegister()) {
                continue;
            } else {
                Next_node.index = index;
                index += 1;
                Next_node = Next_node.next;

            }

        } while (Next_node != head);
        return "Inserted Successful";
    }


    //Displays all the nodes in the list  
    public String display() {
        Node current = head;
        String dis = "";

        if (head == null) {
            dis += "List is empty";
        } else {
            dis += "Nodes of the circular linked list: \n";

            do {
                //Prints each node by incrementing pointer.  
                System.out.println("prev node " + current.prev.index);
                if (current.isRegister()) {
                    dis += "    >> Node: " + current.index + "\tUID: " + current.getUID() + " is the register.\n";
                } else {
                    dis += "    >> Node: " + current.index + "\tUID: " + current.getUID() + "\n";
                }

                System.out.println("current node" + current.index);
                System.out.println("next node " + current.next.index);

                //System.out.println();
                current = current.next;
            } while (current != head);
            dis += "\n";

        }
        return dis;
    }


    public boolean isElection_in_progress() {
        return election_in_progress;
    }

    public void setElection_in_progress(boolean election_in_progress) {
        this.election_in_progress = election_in_progress;
    }

    public Node getController() {
        return controller;
    }

    public void setController(Node controller) {
        this.controller = controller;
    }

    public int size() {
        int s = 0;
        Node current = head;
        do {
            if (!current.isRegister()) {
                s++;
            }

            current = current.next;
        } while (current != head);
        return s;
    }


    public boolean checkUID(int uid) {
        boolean check = false;
        Node current = head;
        do {
            if (current.getUID() == uid) {
                check = true;
                break;
            }
            current = current.next;
        } while (current != head);
        return check;
    }

    public Node getNode(int index) {
        Node current = head;
        do {
            if (current.index == index) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }
}