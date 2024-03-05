package com.bench.msusers;

import com.bench.msusers.datos.Datos;
import com.bench.msusers.dto.UserResponseDTO;
import com.bench.msusers.mapper.UserMapper;
import com.bench.msusers.repositories.UserRepository;
import com.bench.msusers.service.impl.UserServiceImpl;
import com.bench.users.commons.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {User.class})
@ExtendWith(SpringExtension.class)
class MsUsersApplicationTests {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;
    private User user;
    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
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


	}


//	@Test
//	void findExamenPorNombre() {
//		assertTrue(examen.isPresent());
//		assertEquals(5L, examen.orElseThrow().getId());
//		assertEquals("Matemáticas", examen.get().getNombre());
//	}

}
