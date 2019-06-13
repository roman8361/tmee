package ru.kravchenko.ee.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.ee.entity.Task;

import java.util.Collection;

public interface TaskRepository {

    @NotNull
    Collection<Task> findAll();

    @Nullable
    Task findById(@Nullable String id);

    @NotNull
    Collection<Task> findByIds(@Nullable Collection<String> ids);

    @Nullable
    Task merge(@Nullable Task project);

    @Nullable
    Collection<Task> merge(@Nullable Collection<Task> tasks);

    void removeById(@Nullable String id);

    void removeByIds(@Nullable Collection<String> ids);

    void remove(@Nullable Collection<Task> tasks);

    void removeAll();

}
