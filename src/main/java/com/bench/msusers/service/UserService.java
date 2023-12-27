package com.bench.msusers.service;

import com.bench.msusers.UserResponseDTO;

import java.util.List;

public interface UserService {
    public UserResponseDTO findById(Long id);

    //public List<UserResponseDTO> findAll();

    //public UserResponseDTO save(UserResponseDTO userResponseDTO);

}