package eu.senla.task5;

public class Ship extends Base<Deck>{
    Ship(int maxLength) {
        super(maxLength);
    }

    public void createDeck(){
        this.add(new Deck(4));
    }

    public boolean addContainer(Container container){
        boolean isAdd = false;
        int space = amountOfSpace();
        if (space>0) {
            for (int i = 0; i < this.maxLengthItem; i++) {
                Deck deck = (Deck) this.getItem(i);
                space = deck.amountOfSpace();
                if (container instanceof BigContainer && (space-2>=0)) {
                    deck.add(container);
                    isAdd = true;
                    break;
                }
                if (container instanceof SmallContainer && (space-1>=0)) {
                    deck.add(container);
                    isAdd = true;
                    break;
                }
                else
                    isAdd = false;
            }
        }
        return isAdd;
    }

    public int amountOfSpace(){
        int amount = 0;
        for (int i = 0; i < this.maxLengthItem; i++)
            amount += ((Deck)this.getItem(i)).maxLengthItem;
        for (int i = 0; i < this.maxLengthItem; i++) {
            for (int j = 0; j < ((Deck)this.getItem(i)).countItems(); j++) {
                Container container = (Container) ((Deck)this.getItem(i)).getItem(j);
                if (container != null) {
                    if (container instanceof SmallContainer)
                        amount -= 1;
                    else if (container instanceof BigContainer)
                        amount -= 2;
                }
            }
        }
        return amount;
    }

    @Override
    public String toString() {
        double weight = 0.0;
        for (int i = 0; i < this.countItems(); i++) {
            Deck deck = (Deck) this.getItem(i);
            weight += Double.parseDouble(deck.toString());
        }
        return Double.toString(weight);
    }
}
