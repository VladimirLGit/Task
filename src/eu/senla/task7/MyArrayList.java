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

    public MyArrayList(MyList<? extends E> collection){
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

    public MyArrayList(Object[] e) {
        this.arrayItem = new Object[e.length];
        for (int i = 0; i < e.length; i++) {
            arrayItem[i] = e[i];
        }
        size = e.length;
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
    public boolean addAll(MyList<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, MyList<? extends E> collection) {
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
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays.asList(arrayItem).iterator();
    }

    @Override
    public E[] toArray() {
        Object[] r = new Object[size()];
        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()) // fewer elements than expected
                return (E[]) Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return (E[]) r;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size){
            for (int i = 0; i < a.length; i++) {
                a[i] = (T) arrayItem[i];
            }
            return a;
        }
        for (int i = 0; i < size; i++) {
            a[i] = (T) arrayItem[i];
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public E getItem(int index) {
        return (E) arrayItem[index];
    }


    @Override
    public int indexOf(Object object) {
        ListIterator<E> it = listIterator();
        if (object==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return it.nextIndex();
        } else {
            while (it.hasNext())
                if (object.equals(it.next()))
                    return it.nextIndex();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        ListIterator<E> it = listIterator(size);
        if (object==null) {
            while (it.hasPrevious())
                if (it.previous()==null)
                    return it.nextIndex();
        } else {
            while (it.hasPrevious())
                if (object.equals(it.previous()))
                    return it.nextIndex();
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
        private int currentPosition = 0;
        private int lastPosition = -1;
        ListItr(int index) {
            super();
            currentPosition = index - 1;
        }

        @Override
        public boolean hasNext() {
            return currentPosition != size;
        }

        @Override
        public E next() {
            int i = currentPosition + 1;
            if (i>=0 && i<size) {
                lastPosition = currentPosition;
                currentPosition = i;
                return (E) arrayItem[i];
            }
            else
                return null;
        }

        public boolean hasPrevious() {
            return currentPosition != 0;
        }

        public int nextIndex() {
            return currentPosition;
        }

        public int previousIndex() {
            return currentPosition - 1;
        }

        @Override
        public void remove() {

        }

        @SuppressWarnings("unchecked")
        public E previous() {
            int i = currentPosition - 1;
            if (i>=0 && i<size) {
                lastPosition = currentPosition;
                currentPosition = i;
                return (E) arrayItem[i];
            }
            else
                return null;
        }

        public void set(E e) {
            try {
                MyArrayList.this.set(lastPosition, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            try {
                int i = currentPosition;
                MyArrayList.this.add(i, e);
                currentPosition = i + 1;
                lastPosition = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public <E> MyList<E> ofList(Object... e) {
        return new MyArrayList<E>(e);
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
        for( int i=0; i < size; i++) {            // i - номер прохода
            for (int j = size - 1; j > i; j--) {     // внутренний цикл прохода
                if (comparator.compare(arrayItem[j - 1], arrayItem[j]) > 0) {
                    Object x = arrayItem[j - 1];
                    arrayItem[j - 1] = arrayItem[j];
                    arrayItem[j] = x;
                }
            }
        }
    }

    @Override
    public MyList<E> subList(int start, int end) {
        MyArrayList<E> newArrayItem;
        newArrayItem = new MyArrayList<E>();
        for (int i = start; i < end; i++) {
            newArrayItem.add((E) arrayItem[i]);
        }
        return newArrayItem;
    }


    @Override
    public String toString() {
        return Arrays.toString(arrayItem);
    }
}
