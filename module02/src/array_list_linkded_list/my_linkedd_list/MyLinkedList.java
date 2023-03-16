package array_list_linkded_list.my_linkedd_list;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    protected MyLinkedList() {

    }

    protected MyLinkedList(E data) {
        head = new Node(data);
        tail = head;
        numNodes++;
    }

    protected void add(int index, E data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    protected void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        temp = head.next;
        tail = temp;
        numNodes++;
    }

    protected void addLast(E e) {
          Node temp = tail;
          tail.next = new Node(e);
          tail = tail.next;
        numNodes++;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }
}
