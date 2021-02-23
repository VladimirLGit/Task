package eu.senla.task7;

import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;

public class MyArrayList<E> implements MyList<E> {
    private int size;
    private Object[] arrayItem;
    public MyArrayList() {
        this.arrayItem = new Object[] {};
    }

    public MyArrayList(int capacity){
        if (capacity > 0) {
            this.arrayItem = new Object[capacity];
        } else if (capacity == 0) {
            this.arrayItem = new Object[] {};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
    }

    public MyArrayList(Collection<? extends E> collection){

    }


    @Override
    public void add(int index, E object) {

    }

    @Override
    public boolean addAll(int index, Collection collection) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E getItem(int index) {
        return null;
    }

    @Override
    public int indexOf(Object object) {
        ListIterator<E> it = listIterator();
        if (object==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return it.previousIndex();
        } else {
            while (it.hasNext())
                if (object.equals(it.next()))
                    return it.previousIndex();
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E object) {
        return null;
    }

    @Override
    public void sort(Comparator comparator) {

    }

    @Override
    public MyList subList(int start, int end) {
        return null;
    }

    @Override
    public MyList ofList(Object... e) {
        return null;
    }
}
