package array_list_linkded_list.my_linkedd_list;

public class Node {
    protected Node next;
    private Object data;

    public Node(Object data){
        this.data = data;
    }

    public Object getData(){
        return this.data;
    }
}
