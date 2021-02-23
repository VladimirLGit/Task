package eu.senla.task6.factory;


import eu.senla.task6.robot.Body;
import eu.senla.task6.robot.Material;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;


public class FactoryBody extends Base<Body> {
    private Semaphore semaphore;
    public FactoryBody(int maxLength) {
        super(maxLength);
    }
    public FactoryBody(Semaphore semaphore, int maxLength) {
        this(maxLength);
        this.semaphore = semaphore;
    }
    public void createBody() throws InterruptedException {
        int count = 1;
        semaphore.acquire();
        if (this.countItems()==0)
        while (count>0 && this.countItems()<this.maxLengthItem){
            count--;
            this.add(new Body((int) (Math.random()*100), Material.getRandomMaterial()));
            System.out.println("Create body");
            sleep(300);
        }
        semaphore.release();
    }

}
