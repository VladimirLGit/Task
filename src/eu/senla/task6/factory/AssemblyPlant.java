package eu.senla.task6.factory;

import eu.senla.task6.robot.Robot;
import eu.senla.task6.robot.TypeRobot;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

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
                if (factoryHead.countItems()>0 && factoryBody.countItems()>0) {
                    semaphore.acquire();
                    this.add(new Robot("R1",
                            factoryHead.extract(factoryHead.getItem(0)),
                            factoryBody.extract(factoryBody.getItem(0)),
                            TypeRobot.getRandomType()));
                    System.out.println("Create Robot");
                    sleep(2000);
                }
                else
                    sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }
        if (this.countItems()>=maxLengthItem) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
