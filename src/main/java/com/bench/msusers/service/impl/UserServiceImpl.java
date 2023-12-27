package com.bench.msusers.service.impl;

import com.bench.msusers.UserResponseDTO;
import com.bench.msusers.model.User;
import com.bench.msusers.repositories.UserRepository;
import com.bench.msusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return null;
    }


//    @Transactional(readOnly = false)
//    public List<UserResponseDTO> findAll() {
//        List<User> userList = userRepository.findAll();
//        return userList.stream()
//                .map(userMapper::toDTO)
//                .collect(Collectors.toList());
//    }

//    @Transactional(readOnly = false)
//    public UserResponseDTO save(UserResponseDTO userResponseDTO) {
//        return null;
//    }

}
