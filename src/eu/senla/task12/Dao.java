package eu.senla.task12;

import eu.senla.task12.users.User;

import java.util.List;

public interface Dao {
    User create(User user);
    User read(User user);
    User read(String name, String password);
    User update(String name, User newUser);
    boolean delete(String name, String password);
    List<User> readList();
}
