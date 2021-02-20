package eu.senla.task6.factory;

public class ThreadFactoryBody extends Thread{

    private FactoryBody factoryBody;

    public ThreadFactoryBody(FactoryBody factoryBody, String name) {
        super(name);
        this.factoryBody = factoryBody;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                factoryBody.createBody();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
