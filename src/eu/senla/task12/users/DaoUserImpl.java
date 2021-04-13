package eu.senla.task12.users;

import eu.senla.task12.Connector;
import eu.senla.task12.Dao;

import java.util.List;

public class DaoUserImpl implements Dao {
    private Connector conn;

    public DaoUserImpl() {
        try {
            conn = new Connector();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User create(User user) {
        return new User(user.getName(), user.getPassword());
    }

    @Override
    public User read(User user) {
        return null;
    }

    @Override
    public User read(String name, String password) {
        return null;
    }

    @Override
    public User update(String name, User newUser) {
        return null;
    }

    @Override
    public boolean delete(String name, String password) {
        return false;
    }

    @Override
    public List<User> readList() {
        return null;
    }
}
