package eu.senla.task7;

import java.util.*;

public interface MyList<E> extends Iterable<E> {
    boolean add(E object);
    void add(int index, E object);
    boolean addAll(MyList<? extends E> collection);
    boolean addAll(int index, MyList<? extends E> collection);
    int size();
    boolean isEmpty();
    E getItem(int index);
    int indexOf(Object object);
    int lastIndexOf(Object object);
    Iterator<E> iterator();
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);
    E[] toArray();
    <T> T[] toArray(T[] a);
    <E> MyList<E> ofList(Object... e);
    E remove(int index);
    boolean remove(Object o);
    E set(int index, E object);
    void sort(Comparator<? super E> comparator);
    MyList<E> subList(int start, int end);
}
