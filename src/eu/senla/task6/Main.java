// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task6;


import eu.senla.task6.factory.*;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1); // 1 разрешение
        ThreadFactoryBody factoryBody = new ThreadFactoryBody(new FactoryBody(semaphore,15),"factoryBody");
        ThreadFactoryHead factoryHead = new ThreadFactoryHead(new FactoryHead(semaphore,15),"factoryHead");
        new Thread( new AssemblyPlant(semaphore,15, factoryHead.getFactoryHead(), factoryBody.getFactoryBody())).start();
        factoryBody.start();
        factoryHead.start();


    }
}