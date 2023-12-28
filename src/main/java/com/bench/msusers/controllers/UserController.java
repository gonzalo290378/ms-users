package com.bench.msusers.controllers;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.msusers.model.User;
import com.bench.msusers.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        log.info("Calling findAll with {}");
        return ResponseEntity.ok(userServiceImpl.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable(name = "id", required = true) Long id) {
        log.info("Calling findById with {}", id);
        return ResponseEntity.ok(userServiceImpl.findById(id));
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        log.info("Calling save with {}", user);
        return ResponseEntity.ok(userServiceImpl.save(user));
    }

}
