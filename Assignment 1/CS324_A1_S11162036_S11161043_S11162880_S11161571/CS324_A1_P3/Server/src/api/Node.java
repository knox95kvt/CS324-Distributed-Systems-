package api;

public class Node {
    private final int UID;
    public int index;
    Node next;
    Node prev;
    private int leader_UID;
    private int leader_index;
    private String leader_message;
    private boolean candidate;
    private int message_counter = 0;
    private boolean register;
    private Node A;
    private Node B;

    Node(int element, int uid, boolean register) {
        this.index = element;
        this.UID = uid;
        this.candidate = !register;
        this.register = register;
        //this.next = next;
        //this.prev = prev;
    }


    public int getUID() {
        return UID;
    }


    public int getLeader_UID() {
        return leader_UID;
    }

    public void setLeader_UID(int leader_UID) {
        this.leader_UID = leader_UID;
    }

    public boolean isCandidate() {
        return candidate;
    }

    public void setCandidate(boolean candidate) {
        this.candidate = candidate;
    }


    public int getMessage_counter() {
        return message_counter;
    }

    public void setMessage_counter() {
        this.message_counter += 1;
    }

    public int getLeader_index() {
        return leader_index;
    }

    public void setLeader_index(int leader_index) {
        this.leader_index = leader_index;
    }

    public String getLeader_message() {
        return leader_message;
    }

    public void setLeader_message(String leader_message) {
        this.leader_message = leader_message;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }


    public Node getA() {
        return A;
    }

    public void setA(Node a) {
        A = a;
    }

    public Node getB() {
        return B;
    }

    public void setB(Node b) {
        B = b;
    }
}
