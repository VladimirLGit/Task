package eu.senla.task5;

import java.util.Random;

public class Yard extends Base<Container> {

    Yard(int loadItems) {
        super(loadItems);
    }

    public void createContainers(){
        Random random = new Random();
        for (int i = 0; i < this.maxLengthItem; i++) {
            switch (random.nextInt(2)){
                case 1:
                    this.add(new BigContainer(1 + random.nextInt(99),20, Shape.getRandomShape() ));
                    break;
                default: this.add(new SmallContainer(1 + random.nextInt(99),10, Shape.getRandomShape() ));
            }
        }
    };
}
