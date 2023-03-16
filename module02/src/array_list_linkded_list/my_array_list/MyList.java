package array_list_linkded_list.my_array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    protected MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    protected MyList(int capacity) {
        elements = new Object[capacity];
    }

    protected E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Eror");
        } else {
            for (int i = index + 1; i < elements.length; i++) {
                elements[i - 1] = elements[i];
            }
        }
        return (E) elements;
    }

    protected int size() {
        return this.size;
    }

    protected MyList<E> clone() {
        MyList<E> newList = new MyList<>(elements.length * 2);
        for (int i = 0; i < elements.length; i++) {
            newList.elements[i] = elements[i];
        }
        return newList;
    }

    protected boolean contains(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (o == elements[i]) {
                return true;
            }
        }
        return false;
    }

    protected int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (o == elements[i]) {
                return i;
            }
        }
        return -1;
    }

    protected void add(E e) {
        if (size == elements.length) {
            ensureCapasity(2);
        }
        elements[size++] = e;
    }

    protected void add(int index, E element) {
        for (int i = 0; i <= index && elements[index] != null; i++) {
            if (index == i) {
                if (size == elements.length) {
                    ensureCapasity(2);
                }
                for (int j = elements.length - 1; j > i; j--) {
                    elements[j] = elements[j - 1];
                }
                elements[i] = element;
            }
        }
    }

    protected void ensureCapasity(int minCapacity) {
        int newSize = elements.length * minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        return (E) elements[i];
    }

    public void clear() {
        elements = null;
        size = 0;
    }

    @Override
    public String toString() {
        return "Elements=" + Arrays.toString(elements);
    }
}
