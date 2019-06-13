package ru.kravchenko.ee.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class User extends AbstractEntity {

    private String login;

    private String password;

}
