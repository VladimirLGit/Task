// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task6;


import eu.senla.task6.factory.Factory;
import eu.senla.task6.robot.Body;
import eu.senla.task6.robot.Head;

public class Main {
    public static void main(String[] args) {
        Factory<Body> factoryBody = new Factory<Body>(100);
        Factory<Head> factoryHead = new Factory<Head>(100);



    }
}