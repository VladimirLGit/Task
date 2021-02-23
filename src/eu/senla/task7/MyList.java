package eu.senla.task7;

import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;

public interface MyList<E> {
    void add(int index, E object);
    boolean addAll(int index, Collection<? extends E> collection);
    int size();
    boolean isEmpty();
    E getItem(int index);
    int indexOf(Object object);
    ListIterator<E> listIterator();
    <E> MyList<E> ofList(Object... e);
    E remove(int index);
    E set(int index, E object);
    void sort(Comparator<? super E> comparator);
    MyList<E> subList(int start, int end);
}
