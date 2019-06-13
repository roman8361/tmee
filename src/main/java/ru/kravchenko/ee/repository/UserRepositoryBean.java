package ru.kravchenko.ee.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.ee.entity.User;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public enum UserRepositoryBean implements UserRepository {

    INSTANCES;

    @NotNull
    private Map<String, User> users = new LinkedHashMap<>();

    UserRepositoryBean() {
        init();
    }

    public void init() {
        final User user = new User();
        user.setLogin("11");
        user.setPassword("11");
        users.put(user.getId(), user);
    }

    @NotNull
    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Nullable
    @Override
    public User findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return users.get(id);
    }

    @Nullable
    @Override
    public User findByLogin(@Nullable final String login) {
        if (login == null || login.isEmpty()) return null;
        for (User user : findAll()) {
            if (login.equals(user.getLogin())) return user;
        }
        return null;
    }

    @Override
    public boolean loginExist(@Nullable final String login) {
        if (login == null || login.isEmpty()) return false;
        if (findByLogin(login) == null) return false;
        return true;
    }

    @Nullable
    @Override
    public User merge(@Nullable final User user) {
        if (user == null) return null;
        @Nullable final String id = user.getId();
        if (id == null || id.isEmpty()) return null;
        users.put(id, user);
        return user;
    }

    @Override
    public void removeById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        if (!users.containsKey(id)) return;
        users.remove(id);
    }

    @Override
    public void removeAll() {
        users.clear();
    }

}
