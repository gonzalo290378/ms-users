package com.bench.msusers;

import com.bench.msusers.datos.Datos;
import com.bench.msusers.dto.UserResponseDTO;
import com.bench.msusers.exceptions.DniNotFoundException;
import com.bench.msusers.mapper.UserMapper;
import com.bench.msusers.repositories.UserRepository;
import com.bench.msusers.service.impl.UserServiceImpl;
import com.bench.users.commons.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {User.class})
@ExtendWith(SpringExtension.class)
class MsUsersApplicationTests {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;
    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    @DisplayName("A: findByIdTest")
    void findByIdTest() {

        //Given
        when(userRepository.findAll()).thenReturn(Datos.USERS);

        //When
        UserResponseDTO userDTO = userService.findById(4L);
        Optional<User> user = Optional.ofNullable(userMapper.toModel(userDTO));

        //Then
        assertTrue(user.isPresent());
        assertEquals(4L, user.orElseThrow().getId());
        assertEquals("7542361", user.get().getDni());
        verify(userRepository, times(1)).findAll();

    }


    @Test
    @DisplayName("B: findAllTest")
    void findAllTest() {

        //Given
        when(userRepository.findAll()).thenReturn(Datos.USERS);

        //When
        List<UserResponseDTO> listUserDTO = userService.findAll();
        Optional<List<User>> listUser = Optional.of(listUserDTO
                .stream()
                .map(e -> userMapper.toModel(e))
                .collect(Collectors.toList()));

        //Then
        assertTrue(listUser.isPresent());
        assertEquals(5L, listUser.get().size());
        verify(userRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("C: saveTest")
    void saveTest() {

        // Given
        User newUser = Datos.SINGLE_USER;

        // When
        when(userRepository.save(any(User.class))).thenReturn(Datos.SINGLE_USER);
        User user = userService.save(newUser);

        // Then
        assertNotNull(user.getId());
        assertEquals(2L, user.getId());
        assertEquals("26584220", user.getDni());

        verify(userRepository).save(any(User.class));

    }

    @Test
    @DisplayName("D: findByDniTest")
    void findByDniTest() {

        //Given
        when(userRepository.findAll()).thenReturn(Datos.USERS);

        //When
        UserResponseDTO userDTO = userService.findByDni("11255784");
        Optional<User> user = Optional.ofNullable(userMapper.toModel(userDTO));

        //Then
        assertTrue(user.isPresent());
        assertEquals(2L, user.orElseThrow().getId());

    }

    @Test
    @DisplayName("E: testManageException")
    void testManageException() {
        when(userRepository.findAll()).thenReturn(Datos.USERS);
        assertThrows(DniNotFoundException.class, () -> {
            userService.findByDni("111111111");
        });

        //verify(examenRepository).findAll();
        //verify(preguntaRepository).findPreguntasPorExamenId(anyLong());
    }

}
