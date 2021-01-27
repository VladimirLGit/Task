package eu.senla.task3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Volt","fff",1);
        Cat cat2 = new Cat("Tom","sdgfs",2);
        Cat cat3 = new Cat("Tom","sdgfs",2);
        System.out.println(cat1.toString());
        System.out.println(cat2.toString());
        if (cat1.equals(cat2)) {
            System.out.println("true");
        }
        else
            System.out.println("false");
        if (cat2.equals(cat3)) {
            System.out.println("true");
        }
        else
            System.out.println("false");
        if (cat1.hashCode() == cat3.hashCode()) {
            System.out.println("hashCode = true");
        }
        else
            System.out.println("hashCode = false");

        Random rand = new Random(); //instance of random class
        HashSet<Cat> cats = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            cats.add(new Cat("ddd","ttt", rand.nextInt(7)));
        }

        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("do ... while");
        iterator = cats.iterator();
        do {
            System.out.println(iterator.next());
        } while (iterator.hasNext());

        // using forEach to print out the list using
        // lambda expression
        System.out.println("lambda expression");
        //cats.forEach(cat -> System.out.println(cat));
        cats.forEach(System.out::println);


    }
}
