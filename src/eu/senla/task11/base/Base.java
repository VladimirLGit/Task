// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task11.base;

import java.util.ArrayList;

public class Base<T> implements Action<T>, ColorText {
    protected int maxLengthItem = 0;
    public ArrayList<T> items;

    public Base(int maxLength){
        maxLengthItem = maxLength;
        items = new ArrayList<T>();
    }

    @Override
    public boolean add(T item) {
        if (items.size()<maxLengthItem)
            return items.add(item);
        else
            return false;
    }

    @Override
    public boolean remove(T item) {
        return items.remove(item);
    }

    @Override
    public int countItems() {
        return items.size();
    }

    @Override
    public T getItem(int index) {
        if (index<items.size())
            return items.get(index);
        else
            return null;
    }


    @Override
    public T extract(T extItem) {
        int index = items.indexOf(extItem);
        if (index != -1) {
            remove(extItem);
            return extItem;
        }
        else
            return null;
    }

}
