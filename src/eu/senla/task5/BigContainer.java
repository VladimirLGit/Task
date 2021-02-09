package eu.senla.task5;

public class BigContainer extends Container {
    private int place = 0;
    BigContainer(int height, int diagonal, Shape shape) {
        super(height, diagonal, shape);
        this.place = 2;
    }

    public int getPlace() {
        return place;
    }

}
