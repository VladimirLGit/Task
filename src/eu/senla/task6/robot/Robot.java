package eu.senla.task6.robot;


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
            case CLEANER:
                System.out.println("house cleaning");
                break;
            case COOK:
                System.out.println("food cooking");
                break;
            case DEFENDER:
                System.out.println("perimeter protection");
                break;
        }
    }
}
