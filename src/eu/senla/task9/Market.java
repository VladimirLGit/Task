package eu.senla.task9;

import eu.senla.task9.foods.Food;
import eu.senla.task9.foods.Fruits;
import eu.senla.task9.foods.Meats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Market {
    public ArrayList<Food> arrayFoods;
    public void createFoods(){
        Random RANDOM = new Random();
        arrayFoods = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (i%2==0) {
                Fruits fruits = Fruits.getRandomFruits();
                arrayFoods.add(new Food(fruits, fruits.name(), 1+RANDOM.nextInt(2) ));
            }
            else {
                Meats meats = Meats.getRandomMeats();
                arrayFoods.add(new Food(meats, meats.name(), 1+RANDOM.nextInt(4)));
            }
        }

    }
}
