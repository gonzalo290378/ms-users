package com.bench.msusers.service.impl;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.msusers.exceptions.DniNotFoundException;
import com.bench.msusers.exceptions.UserNotFoundException;
import com.bench.msusers.exceptions.UsernameNotFoundException;
import com.bench.msusers.mapper.UserMapper;
import com.bench.msusers.repositories.UserRepository;
import com.bench.msusers.service.UserService;
import com.bench.users.commons.model.User;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    Environment environment;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, Environment environment) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.environment = environment;
    }


    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findAll()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElseThrow(() ->
                        new UserNotFoundException("id: " + id + " does not exist"));
        return userMapper.toDTO(user);
    }


    @Transactional(readOnly = true)
    public List<UserResponseDTO> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public User save(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()
                || userRepository.findByDni((user.getDni())).isPresent()) {
            throw new UserNotFoundException("Username/Dni was registered");
        }
        User newUser = new User().builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .dni(user.getDni())
                .roles(user.getRoles())
                .build();
        return userRepository.save(newUser);
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id: " + id + " does not exist");
        }
        userRepository.delete(user.get());
    }

    public UserResponseDTO findByDni(String dni) {
        User user = userRepository.findAll()
                .stream()
                .filter(e -> e.getDni().equals(dni))
                .findFirst().orElseThrow(() ->
                        new DniNotFoundException("dni: " + dni + " does not exist"));
        return userMapper.toDTO(user);
    }

    public UserResponseDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Username: " + username + " does not exist"));
        return userMapper.toDTO(user);
    }
}
