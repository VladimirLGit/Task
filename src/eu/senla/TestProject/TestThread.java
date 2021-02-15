package eu.senla.TestProject;

import java.util.concurrent.Phaser;

public class TestThread extends Thread{
    Phaser phaser;
    public ProgressBar pb;
    private int pauseRandom = 0;

    public TestThread(Phaser p, String name, int random) {
        super(name);
        this.phaser = p;
        this.pauseRandom = random;
        phaser.register();
        pb = new ProgressBar(name,20);
    }

    public void run(){
        while (!isInterrupted()) {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(pauseRandom);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pb.nextPercent();
            }
            phaser.arriveAndAwaitAdvance();
        }
    }
    public static void main(String[] args) throws Throwable {
        Phaser phaser = new Phaser(1);
        TestThread thread1 = new TestThread(phaser,"JThread1", (int) (Math.random()*300));
        TestThread thread2 = new TestThread(phaser,"JThread2", (int) (Math.random()*300));

        thread1.start();
        thread2.start();

        while (thread1.pb.getDone()<100 || thread2.pb.getDone()<100) {
            // ждем завершения фазы

            int phase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.println("\u001b[2J");
            System.out.flush();

            thread1.pb.showStateBar();
            thread2.pb.showStateBar();
        }
        thread1.interrupt();
        thread2.interrupt();

    }
}
