package eu.senla.task5;

import java.util.Random;

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
    Port(int maxLength) {
        super(maxLength);
        yardContainers = new Yard(100);
    }

    public void createContainers(){
        yardContainers.createContainers();
    }

    public void createShips(){
        for (int i = 0; i < this.maxLengthItem; i++) {
            Ship ship = new Ship(SizeShip.getRandomSize().getSize());
            for (int j = 0; j < ship.maxLengthItem; j++) {
                ship.createDeck();
            }
            this.add(ship);
        }
    };

    public void loadContainer(){
        int space = 0;
        int indexContainer;
        for (int i = 0; i < this.countItems(); i++) {
            indexContainer = 0;
            Ship ship = (Ship) this.getItem(i);
            if (ship!=null)
               do {
                   Container container = (Container) yardContainers.getItem(indexContainer);
                   if (!ship.addContainer(container))
                       indexContainer++;
                   else
                       yardContainers.extract(container);
                   space = ship.amountOfSpace();
               } while (space!=0);
        }
    };

    public String calculateTheVolume() {
        double sumVolumes = 0;
        for (int i = 0; i < this.countItems(); i++) {
            try {
                Ship ship = (Ship) this.getItem(i);
                String strItem = ship.toString();
                sumVolumes += Double.parseDouble(strItem);
            } catch (NumberFormatException nfe)
            {
                sumVolumes += 0;
            }

        }
        return Double.toString(sumVolumes);
    }
}
