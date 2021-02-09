package eu.senla.task5;

import java.util.Random;

import static java.lang.Math.random;

    enum SizeShip {
    SINGLE(1), DOUBLE(2);
    private static final SizeShip[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
        int size;
        SizeShip(int i) {
            size = i;
        }

        public int getSize() {
            return size;
        }

        public static SizeShip getRandomSize() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

public class Port extends Base<Ship> {
    private Yard yardContainers;
    Port(int loadItems) {
        super(loadItems);
        yardContainers = new Yard(100);
    }

    public void createShips(){
        for (int i = 0; i < this.maxLengthItem; i++) {
           this.add(new Ship(SizeShip.getRandomSize().getSize()));
        }
    };

    public boolean loadContainer(){
        int space;
        for (int i = 0; i < this.maxLengthItem; i++) {
           Ship ship = (Ship) this.getItem(i);
           if (ship!=null)

               do {
                   space = ship.amountOfSpace();
                   ship.add(yardContainers.extract(yardContainers.getItem(i)));
               } while (space==0);

        }
        return false;
    };
}
