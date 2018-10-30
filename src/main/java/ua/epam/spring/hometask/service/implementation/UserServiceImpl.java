package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.dao.UserDatabase;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class UserServiceImpl implements UserService {

    private UserDatabase registeredUsers;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return registeredUsers.entrySet()
                .stream()
                .filter(entry -> registeredUsers.get(entry.getKey()).getEmail().equals(email))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    @Override
    public User save(@Nonnull User object) {
        registeredUsers.put(object.getId(), object);
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        registeredUsers.remove(object.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return registeredUsers
                .entrySet()
                .stream()
                .filter(entry -> registeredUsers.get(entry.getKey()).getId().equals(id))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return registeredUsers.values();
    }

    public void setRegisteredUsers(UserDatabase registeredUsers) {
        this.registeredUsers = registeredUsers;
    }
}
