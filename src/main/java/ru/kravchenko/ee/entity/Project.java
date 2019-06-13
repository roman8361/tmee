package ru.kravchenko.ee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Project extends AbstractEntity {

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    public Project(@Nullable final String name) { this.name = name; }

}
