package eu.senla.task9.foods;

import java.util.Random;

public enum Meats {
    BEEF, VEAL, PORK, BACON, MUTTON, CHICKEN, DUCK, GOOSE;
    private static final Meats[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static Meats getRandomMeats() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
