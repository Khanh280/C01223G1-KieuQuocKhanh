package array_list_linkded_list.linked_list;

public class LinkedList {
    private Node head;
    private int numNodes;

    public LinkedList(int data){
        head = new Node(data);
        numNodes++;
    }

    public  void add(int index, int data){
        Node temp = head;
        Node holder;

        for (int i = 0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(int data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

}
