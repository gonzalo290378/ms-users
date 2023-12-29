package com.bench.msusers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=5, message = "Username should have at least 5 characters")
    @Column(name = "username")
    private String username;

    @Size(min=5, message = "Password should have at least 5 characters")
    @Column(name = "password")
    private String password;

    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Dni cannot be empty")
    @Column(name = "dni")
    private Long dni;

}
