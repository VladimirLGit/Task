package eu.senla.task6.factory;


import eu.senla.task6.robot.Head;
import eu.senla.task6.robot.Material;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

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
        if (this.countItems()==0)
        while (count>0 && this.countItems()<this.maxLengthItem){
            count--;
            this.add(new Head(Material.getRandomMaterial()));
            System.out.println("Create head");
            sleep(200);
        }
        semaphore.release();
    }
}
