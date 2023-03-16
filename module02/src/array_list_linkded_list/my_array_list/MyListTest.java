package array_list_linkded_list.my_array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(1, 5);
        System.out.print("[");
        for (int i = 0; i <= myList.size(); i++) {
            if (myList.get(i) != null) {
                System.out.print(myList.get(i) + ", ");
            }
        }
        System.out.println("]");
        System.out.println(myList.get(3));
        System.out.println(myList.indexOf(3));
        System.out.println(myList.contains(5));
        System.out.println(myList.remove(3) + "\n" + myList);
        System.out.println(myList.size());
    }
}
