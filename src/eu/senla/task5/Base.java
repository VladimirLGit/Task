package eu.senla.task5;

import java.util.ArrayList;

public class Base<T> implements Action {
    private int maxLengthItem = 0;
    private int countItem = 0;
    private ArrayList<T> items;

    Base(int loadItems){
        maxLengthItem = loadItems;
        items = new ArrayList<T>();
    }

    @Override
    public boolean add(Object item) {
        if (items.size()==maxLengthItem)
            return items.add((T) item);
        else
            return false;
    }

    @Override
    public boolean remove(Object item) {
        return items.remove(item);
    }

    @Override
    public String calculateTheVolume() {
        double sumVolumes = 0;
        for (T item: items) {
            try {
                sumVolumes += Double.parseDouble(item.toString());
            } catch (NumberFormatException nfe)
            {
                sumVolumes += 0;
            }

        }
        return String.valueOf(sumVolumes);
    }
}
