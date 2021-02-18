package eu.senla.task6.robot;


import java.util.Random;

    enum TypeRobot {
        CLEANER, COOK, DEFENDER;
        private static final TypeRobot[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static TypeRobot getRandomType() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

public class Robot implements ActionRobot {
    private String name;
    private Head head;
    private Body body;
    private TypeRobot typeRobot;

    public Robot(String name, Head head, Body body, TypeRobot typeRobot) {
        this.name = name;
        this.head = head;
        this.body = body;
        this.typeRobot = typeRobot;
    }

    @Override
    public void work() {
        switch (typeRobot){
            case CLEANER -> {
                System.out.println("house cleaning");
            }
            case COOK -> {
                System.out.println("food cooking");
            }
            case DEFENDER -> {
                System.out.println("perimeter protection");
            }
        }
    }
}
