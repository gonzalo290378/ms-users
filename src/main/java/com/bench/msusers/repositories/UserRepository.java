package com.bench.msusers.repositories;

import com.bench.users.commons.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(@Param("id") Long id);

    public Optional<User> findByUsername(@Param(("username")) String username);

    public Optional<User> findByDni(@Param(("dni")) String dni);


}

