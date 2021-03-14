// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task9;

import eu.senla.task9.exception.CountException;
import eu.senla.task9.exception.OnlyOneTypeException;
import eu.senla.task9.exception.WeightException;
import eu.senla.task9.foods.FoodBasketFruits;
import eu.senla.task9.foods.FoodBasketMeats;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        FoodBasketMeats fbm = new FoodBasketMeats(10);
        FoodBasketFruits fbf = new FoodBasketFruits(10);
        market.createFoods();
        int index = 0;
        while (fbm.countItems()<fbm.maxWeight || index>=market.arrayFoods.size()){
            try {
                fbm.put(market.arrayFoods.get(index));
                market.arrayFoods.remove(index);
            } catch (WeightException | CountException e) {
                //e.printStackTrace();
               break;
            } catch (OnlyOneTypeException e) {
                index++;
            }
        }
        index = 0;
        while (fbf.countItems()<fbf.maxWeight || index>=market.arrayFoods.size()){
            try {
                fbf.put(market.arrayFoods.get(index));
                market.arrayFoods.remove(index);
            } catch (WeightException | CountException e) {
                //e.printStackTrace();
                break;
            } catch (OnlyOneTypeException e) {
                index++;
            }
        }
        System.out.println("*************************");
        for (int i = 0; i < fbm.countItems(); i++) {
            System.out.println(fbm.getItem(i));
        }
        System.out.println("*************************");
        for (int i = 0; i < fbf.countItems(); i++) {
            System.out.println(fbf.getItem(i));
        }

    }
}