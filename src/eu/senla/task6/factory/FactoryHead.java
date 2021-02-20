package eu.senla.task6.factory;


import eu.senla.task6.robot.Body;
import eu.senla.task6.robot.Head;
import eu.senla.task6.robot.Material;

import java.util.concurrent.Semaphore;

public class FactoryHead extends Base<Head> {
    private Semaphore semaphore;
    public FactoryHead(int maxLength) {
        super(maxLength);
    }
    public FactoryHead(Semaphore semaphore, int maxLength) {
        this(maxLength);
        this.semaphore = semaphore;
    }
    public void createHead() throws InterruptedException {
        int count = 1;
        semaphore.acquire();
        while (count>0){
            count--;
            this.add(new Head(Material.getRandomMaterial()));
        }
        semaphore.release();
    }
}
