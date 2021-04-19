// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task12;

import eu.senla.task12.users.DaoUserImpl;
import eu.senla.task12.users.User;

public class Main {
    public static void main(String[] args) {
        DaoUserImpl daoUser = new DaoUserImpl();
        //daoUser.createTableUsers();
        //daoUser.create(new User("Ivan", "qwerty"));
        //daoUser.create(new User("Dima", "1234"));
        //daoUser.create(new User("Sasha", "2345"));
        //daoUser.create(new User("Olay", "5678"));
        daoUser.readList();
        daoUser.update("Olay", new User("Olay", "889900"));
        User user = daoUser.read(new User("Olay","889900"));
        System.out.println(user);
        if (daoUser.delete("Ivan","qwerty")) {
            System.out.println("Successfully deleted");
        }
        if (daoUser.delete("Dima","1234")) {
            System.out.println("Successfully deleted");
        }
        daoUser.readList().forEach(System.out::println);
        daoUser.readAllUsers();
    }


}