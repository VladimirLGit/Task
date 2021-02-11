// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

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

    public Yard getYardContainers() {
        return yardContainers;
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
        int contContainers = 0;
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
                   contContainers = yardContainers.countItems();
               } while (space!=0 && indexContainer<contContainers);
        }
    };

    public void transferAllContainers(Port port){
        System.out.println("Transfer all containers");
        int count = yardContainers.countItems();
        while (count>0){
            if (this.countItems()==0) {
                port.transferAllShips(this);
                loadContainer();
            }
            this.transferAllShips(port);
            for (int i = 0; i < 10; i++) {
                String num = Integer.toString(i);
                System.out.print(num);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }

                for (int j = 0, k = num.length(); j < k; j++) {
                    System.out.write( '\b');
                }
            }
            count = yardContainers.countItems();
            System.out.println("Count containers = " + count);
        }
    }

    public void transferAllShips(Port port){
        while (this.countItems()>0){
            Ship ship = this.extract(this.getItem(0));
            port.add(ship);
            int maxContainers = 0;
            for (int i = 0; i < ship.maxLengthItem; i++) {
                maxContainers += ship.getItem(i).maxLengthItem;
            }
            while (ship.amountOfSpace()!=maxContainers || port.getYardContainers().countItems()==0 ){
                for (int i = 0; i < ship.maxLengthItem; i++) {
                    while (ship.getItem(i).countItems()>0) {
                        Container container = ship.getItem(i).extract(ship.getItem(i).getItem(0));
                        port.getYardContainers().add(container);
                    }
                }
            }

        }

    }
    public String calculateTheVolume() {
        double sumVolumes = 0;
        for (int i = 0; i < this.countItems(); i++) {
            try {
                Ship ship = (Ship) this.getItem(i);
                System.out.print(ANSI_BLUE +"#" + (i+1) + ANSI_RESET + " ");
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
