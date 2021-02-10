// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task5;

public class Deck extends Base<Container>{
    Deck(int maxLength) {
        super(maxLength);
    }

    public int amountOfSpace(){
        int amount = this.maxLengthItem;
        for (int i = 0; i < this.countItems(); i++) {
            Container container = (Container) this.getItem(i);
            if (container != null) {
                if (container instanceof SmallContainer)
                    amount -= 1;
                else if (container instanceof BigContainer)
                    amount -= 2;
            }
        }

        return amount;
    };

    @Override
    public String toString() {
        double weight = 0.0;
        for (int i = 0; i < this.countItems(); i++) {
            Container container = (Container) this.getItem(i);
            System.out.print( container instanceof BigContainer? "Container\tBig\t" : "Container\tSmall\t");
            System.out.print(container.shape + "\t");
            weight += Double.parseDouble(container.toString());
        }
        System.out.println();
        //System.out.println("================================");
        return Double.toString(weight);
    }
}
