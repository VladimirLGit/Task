package eu.senla.task11;

class OrderProduct {
    private int id;
    public OrderProduct(int id) {
        this.id = id;
    }

    private static OrderProduct create(int id){
        return new OrderProduct(id);
    }
    public static OrderProduct of(String s) {
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
