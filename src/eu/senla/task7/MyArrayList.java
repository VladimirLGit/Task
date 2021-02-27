package eu.senla.task7;

import java.util.*;

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
        Object[] a = collection.toArray();
        if ((size = a.length) != 0) {
            //arrayItem = Arrays.copyOf(a, size, Object[].class);
            arrayItem = new Object[size];
            for (int i = 0; i < size; i++) {
                arrayItem[i] = a[i];
            }
        } else {
            // replace with empty array.
            arrayItem = new Object[] {};
        }
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean add(E object) {
        Object[] arrayItemNew;
        arrayItemNew = new Object[++size];
        for (int i = 0; i < size-1; i++) {
            arrayItemNew[i] = arrayItem[i];
        }
        arrayItemNew[size-1] = object;
        arrayItem = arrayItemNew;
        return true;

    }

    @Override
    public void add(int index, E object) {
        Object[] arrayItemNew;
        if (index<size){
            arrayItemNew = new Object[++size];
//            for (int i = 0; i < index; i++) {
//                arrayItemNew[i] = arrayItem[i];
//            }
//            arrayItemNew[index] = object;
//            index++;
//            for (int i = index; i < size; i++) {
//                arrayItemNew[i] = arrayItem[i-1];
//            }
            for (int i = 0; i < size; i++) {
                arrayItemNew[i] = i<index ? arrayItem[i] : i==index ? object : arrayItem[i-1];
            }
            arrayItem = arrayItemNew;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
//        Iterator it = collection.iterator();
//        while (it.hasNext()) {
//            add(index, (E) it.next());
//            index++;
//        }
        Object[] a = collection.toArray();
        if (a.length == 0)
            return false;
        for (int i = 0; i < a.length; i++) {
           add(index, (E) a[i]);
           index++;
        }
        return true;
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
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays.asList(arrayItem).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] r = new Object[size()];
        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()) // fewer elements than expected
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return r;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public E getItem(int index) {
        return null;
    }


    @Override
    public int indexOf(Object object) {
        ListIterator it = listIterator();
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
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public <E1> MyList<E1> ofList(Object... e) {
        return null;
    }

    @Override
    public E remove(int index) {
        if (index<0 || index>size)
            return null;
        E element;
        Object[] arrayItemNew;
        arrayItemNew = new Object[--size];
        for (int i = 0; i < size; i++) {
            arrayItemNew[i] = i<index ? arrayItem[i] : arrayItem[i+1];
        }
        element = (E) arrayItem[index];
        arrayItem = arrayItemNew;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        Object[] arrayItemNew;
        arrayItemNew = new Object[--size];
        boolean findItem = false;
        for (int i = 0; i < size; i++) {
            if (!findItem)
                findItem = arrayItem[i].equals(o);
            arrayItemNew[i] = !findItem ? arrayItem[i] : arrayItem[i+1];
        }
        arrayItem = arrayItemNew;
        return false;
    }

    @Override
    public E set(int index, E object) {
        if (index<0 || index>size)
            return null;
        E oldElement = (E) arrayItem[index];
        arrayItem[index] = object;
        return oldElement;
    }

    @Override
    public void sort(Comparator comparator) {

    }

    @Override
    public MyList<E> subList(int start, int end) {
        return null;
    }


    @Override
    public String toString() {
        return Arrays.toString(arrayItem);
    }
}
