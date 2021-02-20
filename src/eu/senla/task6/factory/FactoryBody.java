package eu.senla.task6.factory;


import eu.senla.task6.robot.Body;
import eu.senla.task6.robot.Material;

import java.util.concurrent.Semaphore;


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
        int count = 10;
        semaphore.acquire();
        while (count>0){
            count--;
            this.add(new Body((int) (Math.random()*100), Material.getRandomMaterial()));
        }
        semaphore.release();
    }

}
