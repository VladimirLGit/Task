package eu.senla.task11.foods;

import java.util.Random;

public enum Fruits {
    APPLE, ORANGE, PEAR, BANANA, PAPAYA, PINEAPPLE, PEACH, PLUM, KIWI, LIME, LEMON, MANGO;
    private static final Fruits[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Fruits getRandomFruits() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
