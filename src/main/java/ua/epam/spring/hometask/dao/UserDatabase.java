package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserDatabase {

    private static Map<Long, User> registeredUsers = new HashMap<>();

    public Set<Map.Entry<Long, User>> entrySet() {
        return registeredUsers.entrySet();
    }

    public User get(Long key) {
        return registeredUsers.get(key);
    }

    public void put(Long id, User object) {
        registeredUsers.put(id, object);
    }

    public void remove(Long id) {
        registeredUsers.remove(id);
    }

    public Collection<User> values() {
        return registeredUsers.values();
    }
}
