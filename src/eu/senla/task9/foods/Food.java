package eu.senla.task9.foods;

public class Food<T> {
    public T item;
    public String name;
    public double value;

    public Food(T item, String name, double value) {
        this.item = item;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Food{" +
                "item=" + item +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
