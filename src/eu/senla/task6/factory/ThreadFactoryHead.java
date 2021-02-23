package eu.senla.task6.factory;

public class ThreadFactoryHead extends Thread{

    public FactoryHead getFactoryHead() {
        return factoryHead;
    }

    private FactoryHead factoryHead;

    public ThreadFactoryHead(FactoryHead factoryHead, String name) {
        super(name);
        this.factoryHead = factoryHead;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                factoryHead.createHead();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
