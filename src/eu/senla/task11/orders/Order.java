package eu.senla.task11.orders;

public class Order {
    private int id;
    public Order(int id) {
        this.id = id;
    }

    private static Order create(int id){
        return new Order(id);
    }
    public static Order of(String s) {
        return create(Integer.parseInt(s));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
