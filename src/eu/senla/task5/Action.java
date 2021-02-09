package eu.senla.task5;

public interface Action<T> {
    boolean add(T item);
    boolean remove(T item);
    int countItems();
    T getItem(int index);
    T extract(T extItem);
}
