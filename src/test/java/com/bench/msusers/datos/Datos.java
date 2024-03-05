package com.bench.msusers.datos;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.users.commons.model.Role;
import com.bench.users.commons.model.User;
import java.util.Arrays;
import java.util.List;

public class Datos {

    public final static List<Role> roles = Arrays.asList(new Role(1L, "ROLE_USER"));
    public final static List<User> USERS = Arrays.asList(

            new User(1L, "romina.garcia",
                    "12345", "romina@gmail.com", "26584224", roles, 0),

            new User(2L, "gonzalo.zabala",
                    "12345", "gonzalo@gmail.com", "11255784", roles, 0),

            new User(3L, "nilda.duarte",
                    "12345", "nilda@gmail.com", "74584021", roles, 0),

            new User(4L, "sergio.dimeo",
                    "12345", "sergio@gmail.com", "7542361", roles, 0));



//    public final static List<Examen> EXAMENES_ID_NEGATIVOS = Arrays.asList(new Examen(-5L, "Matemáticas"),
//            new Examen(-6L, "Lenguaje"),
//            new Examen(null, "Historia"));
//
//    public final static List<String> PREGUNTAS = Arrays.asList("aritmética","integrales",
//            "derivadas", "trigonometría", "geometría");
//    public final static Examen EXAMEN = new Examen(8L, "Física");
}
