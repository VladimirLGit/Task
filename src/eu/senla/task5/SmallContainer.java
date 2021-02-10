// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task5;

public class SmallContainer extends Container {
    private int place = 0;
    SmallContainer(int height, int diagonal, Shape shape) {
        super(height, diagonal, shape);
        this.place = 1;
    }

    public int getPlace() {
        return place;
    }
}
