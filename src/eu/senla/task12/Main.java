// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package eu.senla.task12;

import eu.senla.task12.users.DaoUserImpl;
import eu.senla.task12.users.User;

public class Main {
    public static void main(String[] args) {
        DaoUserImpl daoUser = new DaoUserImpl();
        daoUser.createTableUsers();
        daoUser.create(new User("Ivan", "qwerty"));
    }


}