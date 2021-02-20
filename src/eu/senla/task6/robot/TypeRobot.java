package eu.senla.task6.robot;

import java.util.Random;

    public enum TypeRobot {
        CLEANER, COOK, DEFENDER;
    private static final TypeRobot[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static TypeRobot getRandomType() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
