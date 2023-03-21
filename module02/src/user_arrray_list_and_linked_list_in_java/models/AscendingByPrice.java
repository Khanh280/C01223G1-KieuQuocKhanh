package user_arrray_list_and_linked_list_in_java.models;

import java.util.Comparator;

public class AscendingByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
