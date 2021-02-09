package eu.senla.task5;

public class Ship extends Base<Container>{
    Ship(int loadItems) {
        super(loadItems*4);
    }
    public int amountOfSpace(){
        int amount = this.maxLengthItem;
        for (int i = 0; i < this.maxLengthItem; i++) {
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
}
