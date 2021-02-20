package eu.senla.task6.robot;

import java.util.Random;

    public enum Material {
        PlASTIC, METAL, TITANIUM;
    private static final Material[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();
    public static Material getRandomMaterial() {
        return VALUES[RANDOM.nextInt(SIZE)];
    }
}
