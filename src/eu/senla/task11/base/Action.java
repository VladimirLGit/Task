// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task11.base;

public interface Action<T> {
    boolean add(T item);
    boolean remove(T item);
    int countItems();
    T getItem(int index);
    T extract(T extItem);
}
