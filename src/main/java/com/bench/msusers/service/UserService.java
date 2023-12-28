package com.bench.msusers.service;

import com.bench.msusers.dto.UserResponseDTO;

public interface UserService {
    public UserResponseDTO findById(Long id);


}