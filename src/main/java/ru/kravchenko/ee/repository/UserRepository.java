package ru.kravchenko.ee.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.ee.entity.User;

import java.util.Collection;

/**
 * @author Roman Kravchenko
 */


public interface UserRepository {

    @NotNull
    Collection<User> findAll();

    @Nullable
    User findById(@Nullable String id);

    @Nullable
    User findByLogin(@Nullable String login);

    @Nullable
    User merge(@Nullable User user);

    void removeById(@Nullable String id);

    void removeAll();

    void init();

    boolean loginExist(@Nullable String login);

}
