package eu.senla.task9.foods;

import eu.senla.task9.base.Base;
import eu.senla.task9.exception.CountException;
import eu.senla.task9.exception.OnlyOneTypeException;
import eu.senla.task9.exception.WeightException;

public class FoodBasketFruits extends Base<Food<Fruits>> {
    public int maxWeight = 10;
    public int weightBasket = 0;
    public FoodBasketFruits(int maxLength) {
        super(maxLength);
    }

    public int weight(){
        weightBasket = 0;
        for (int i = 0; i < this.countItems(); i++) {
            weightBasket += this.getItem(i).value;
        }
        return weightBasket;
    }
    public void put(Food f) throws WeightException, OnlyOneTypeException, CountException {
        if (f.item.getClass()==Fruits.class) {
            if (weight() + f.value > maxWeight)
                throw new WeightException("Превышен максимальный вес корзины");
            else {
                if (!add(f))
                    throw new CountException("Превышено максимальное количество продуктов в корзине");
            }
        }
        else {
            throw new OnlyOneTypeException("В корзине может находиться только один вид продуктов");
        }

    }
}
