package eu.senla.task6.factory;

import eu.senla.task6.robot.Robot;
import eu.senla.task6.robot.TypeRobot;

import java.util.concurrent.Semaphore;

public class AssemblyPlant extends Base<Robot> implements Runnable {
    private Semaphore semaphore;
    FactoryHead factoryHead;
    FactoryBody factoryBody;
    AssemblyPlant(int maxLength) {
        super(maxLength);
    }
    public AssemblyPlant(Semaphore semaphore, int maxLength, FactoryHead fHead, FactoryBody fBody) {
        this(maxLength);
        this.semaphore = semaphore;
        this.factoryBody = fBody;
        this.factoryHead = fHead;
    }

    @Override
    public void run() {
        while (this.countItems()<maxLengthItem) {
            try {
                semaphore.acquire();
                this.add(new Robot("R1",
                                   factoryHead.extract(factoryHead.getItem(0)),
                                   factoryBody.extract(factoryBody.getItem(0)),
                                   TypeRobot.getRandomType()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }
    }
}
