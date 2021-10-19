package api;

import java.rmi.RemoteException;

public class LCR {

    RingList ringList;
    boolean leader_unknown = true;
    private Node leader;

    public LCR(RingList ringlist) throws RemoteException {

        this.ringList = ringlist;
    }

    public String election() {
        String message = "";
        int i = 0;
        ringList.setElection_in_progress(true);

        if (ringList.head == null) { //check to see if the list is empty
            message += "List is empty";
        } else { // if the list is not empty then continue
            Node current = ringList.head; // set current node to the head of the ringList
            while (leader_unknown) { // check to see if the leader has been found
                int N =  i+1; // set N = 2**i
                System.out.println("Phase " + i); //print out phases
                int size = ringList.size(); // get the size of the ringList by calling an internal method
                Node max_candidate = new Node(0, 0, false);
                if (N < size) { //if N is less than size continue
                    do {
                        Node left = current;
                        Node right = current;
                        for (int j = 0; j < N; j++) {
                            left = left.next;
                        }
                        if (current.isCandidate()) {

                            if (current.getUID() > left.getUID()) {
                                current.setCandidate(true);
                                current.setMessage_counter();
                                System.out.println("Current ID " + current.getUID());
                                System.out.println("left ID " + left.getUID());
                                System.out.println("right ID " + right.getUID());
                                System.out.println("Candidate is true\n");

                            } else if (current.getUID() == left.getUID()) {
                                current.setLeader_UID(current.getUID());
                                leader_unknown = false;
                                break;
                            } else {
                                current.setCandidate(false);
                            }

                        }
                        current = current.next;
                    } while (current != ringList.head);
                } else {
                    do {
                        if (current.isCandidate()) { // check if the node is still valid
                            if (max_candidate.getUID() < current.getUID()) {
                                max_candidate = current;
                                max_candidate.setLeader_UID(current.getUID());
                            }
                        }
                        current = current.next;
                    } while (current != ringList.head);
                    leader_unknown = false;
                    System.out.println("Leader found!");
                    System.out.println("Leader index: " + max_candidate.index);
                    System.out.println("Leader UID: " + max_candidate.getUID());
                    System.out.println("Message counter: " + max_candidate.getMessage_counter());
                    message += "Leader index: " + max_candidate.index + "\tLeader UID: " + max_candidate.getUID();
                    setLeader(max_candidate);
                }
                i++;
            }
        }
        ringList.setElection_in_progress(false);
        return message;
    }

    public void notify_all() {
        Node current = getLeader();
        do {
            current.setLeader_index(getLeader().index);
            current.setLeader_UID(getLeader().getUID());
            current.setLeader_UID(getLeader().getUID());
            current.setLeader_message("Leader is at Node indexed: " + getLeader().index);
            current = current.next;
        } while (current != getLeader());
    }

    public Node getLeader() {
        return leader;
    }

    public void setLeader(Node leader) {
        this.leader = leader;
    }
}