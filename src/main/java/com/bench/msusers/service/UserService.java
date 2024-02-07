package com.bench.msusers.service;

import com.bench.msusers.dto.UserResponseDTO;
import com.bench.users.commons.model.User;
import java.util.List;

public interface UserService {
    public UserResponseDTO findById(Long id);

    public List<UserResponseDTO> findAll();

    public User save(User user);

    public void delete(Long id);

    public UserResponseDTO findByUsername(String username);
}