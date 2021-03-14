package eu.senla.task9.foods;

import eu.senla.task9.base.Base;
import eu.senla.task9.exception.CountException;
import eu.senla.task9.exception.OnlyOneTypeException;
import eu.senla.task9.exception.WeightException;

public class FoodBasketMeats extends Base<Food<Meats>> {
    public int maxWeight = 10;
    public int weightBasket = 0;

    public FoodBasketMeats(int maxLength) {
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
        Class<?> strClass = f.item.getClass();
        if (strClass==Meats.class) {
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
