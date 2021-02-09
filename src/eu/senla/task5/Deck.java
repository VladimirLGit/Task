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
            weight += Double.parseDouble(container.toString());
        }
        return Double.toString(weight);
    }
}
