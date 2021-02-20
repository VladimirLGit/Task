// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task6;


import eu.senla.task6.factory.FactoryBody;
import eu.senla.task6.factory.FactoryHead;
import eu.senla.task6.factory.ThreadFactoryBody;
import eu.senla.task6.factory.ThreadFactoryHead;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // 1 разрешение
        ThreadFactoryBody factoryBody = new ThreadFactoryBody(new FactoryBody(semaphore,15),"factoryBody");
        ThreadFactoryHead factoryHead = new ThreadFactoryHead(new FactoryHead(semaphore,15),"factoryHead");

    }
}