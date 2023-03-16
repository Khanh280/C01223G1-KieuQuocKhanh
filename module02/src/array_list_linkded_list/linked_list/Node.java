package array_list_linkded_list.linked_list;

import java.util.Objects;

public class Node {
    protected Node next;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }
}
