package api;

public class Node {
    Node next;
    Node prev;
    private final int UID;
    int index;
    private int leader_UID;
    private int leader_index;
    private String leader_message;

    private boolean candidate;
    private int message_counter = 0;


    Node(/*api.Node prev,*/ int element, int uid/*, api.Node next*/) {
        this.index = element;
        this.UID = uid;
        this.candidate = true;
        //this.next = next;
        //this.prev = prev;
    }


    public int getUID() {
        return UID;
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

    public void setLeader_index(int leader_index) {
        this.leader_index = leader_index;
    }

    public void setLeader_message(String leader_message) {
        this.leader_message = leader_message;
    }
}
