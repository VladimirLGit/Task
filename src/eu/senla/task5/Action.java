package eu.senla.task5;

public interface Action<T> {
    boolean add(T item);
    boolean remove(T item);
    T getItem(int index);
    T extract(T extItem);
    String calculateTheVolume();
}
