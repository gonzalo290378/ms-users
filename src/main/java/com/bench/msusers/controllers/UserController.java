package com.bench.msusers.controllers;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.msusers.service.impl.UserServiceImpl;
import com.bench.users.commons.model.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private Environment environment;

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        log.info("Calling findAll with {}");
        String port = environment.getProperty("local.server.port");
        return ResponseEntity.ok(userServiceImpl.findAll().stream()
                .peek(user -> user.setPort(Integer.parseInt(port)))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable(name = "id", required = true) Long id) {
        log.info("Calling findById with {}", id);
        return ResponseEntity.ok(userServiceImpl.findById(id));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UserResponseDTO> findByDni(@PathVariable(name = "dni", required = true) String dni) {
        log.info("Calling findByDni with {}", dni);
        return ResponseEntity.ok(userServiceImpl.findByDni(dni));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDTO> findByUsername(@PathVariable(name = "username", required = true) String username) {
        log.info("Calling findByUsername with {}", username);
        return ResponseEntity.ok(userServiceImpl.findByUsername(username));
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        log.info("Calling save with {}", user);
        return ResponseEntity.ok(userServiceImpl.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id", required = true) Long id) {
        userServiceImpl.delete(id);
        log.info("Calling delete with {}", id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @GetMapping("/authorized")
    public Map<String, String> authorized(@RequestParam String code) {
        log.info("Calling authorized with {}", code);
        return Collections.singletonMap("code", code);
    }

}
