package com.bench.msusers.service.impl;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.msusers.exceptions.UserNotFoundException;
import com.bench.msusers.mapper.UserMapper;
import com.bench.msusers.model.User;
import com.bench.msusers.repositories.UserRepository;
import com.bench.msusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("id: " +  id + " does not exist"));
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
        User newUser = new User().builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .dni(user.getDni())
                .build();

        return userRepository.save(newUser);
    }

}
