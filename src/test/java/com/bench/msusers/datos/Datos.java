package com.bench.msusers.datos;

import com.bench.users.commons.model.Role;
import com.bench.users.commons.model.User;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public final static List<Role> roles = Arrays.asList(new Role(1L, "ROLE_USER"));
    public final static List<User> USERS = Arrays.asList(

            new User(1L, "romina.garcia",
                    "12345", "romina@gmail.com", "36584224", roles, 0),

            new User(2L, "gonzalo.zabala",
                    "12345", "gonzalo@gmail.com", "11255784", roles, 0),

            new User(3L, "nilda.duarte",
                    "12345", "nilda@gmail.com", "74584021", roles, 0),

            new User(4L, "sergio.dimeo",
                    "12345", "sergio@gmail.com", "7542361", roles, 0),

            new User(5L, "roberto.suarez",
                    "12345", "roberto@gmail.com", "54987201", roles, 0));


    public final static User SINGLE_USER =
            new User(2L, "gonzalo.zabala",
                                 "12345", "gonzalo@gmail.com", "26584220", roles, 0);

}
