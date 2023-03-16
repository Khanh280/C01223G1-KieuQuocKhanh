package array_list_linkded_list.array_list;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> {
   private int size=0;
   private static final int DEFAULT_CAPACITY = 10;
   private E element[];

   public ArrayList(){
       element =(E[]) new Integer[DEFAULT_CAPACITY];
   }

   private void ensureCapa(){
       int newSize = element.length*2;
       element = Arrays.copyOf(element, newSize);
   }

   public void add(E e){
       if ( size == element.length){
           ensureCapa();
       } else {
           element[size++] = e;
       }
   }

    public E get(int i){
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        return (E) element[i];
    }
}