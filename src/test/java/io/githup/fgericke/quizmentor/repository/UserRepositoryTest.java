package io.githup.fgericke.quizmentor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//ToDo : Create a Test Environment to Test against a test database

@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  //  @Mock
  User user;

  @BeforeEach
  public void init() {
//    MockitoAnnotations.openMocks(this);
  }

  @Test
  @Disabled
  public void shouldFindUserById() {
    UUID id = UUID.randomUUID();
    when(userRepository.findById(id)).thenReturn(Optional.of(user));

    Optional<User> foundUser = userRepository.findById(id);

    assertTrue(foundUser.isPresent());
    assertEquals(user, foundUser.get());
    verify(userRepository, times(1)).findById(id);
  }

  @Test
  @Disabled
  public void shouldSaveUser() {
    when(userRepository.save(user)).thenReturn(user);

    User savedUser = userRepository.save(user);

    assertEquals(user, savedUser);
    verify(userRepository, times(1)).save(user);
  }

  @Test
  @Disabled
  public void shouldNotFindUserById() {
    UUID id = UUID.randomUUID();
    when(userRepository.findById(id)).thenReturn(Optional.empty());

    Optional<User> foundUser = userRepository.findById(id);

    assertTrue(foundUser.isEmpty());
    verify(userRepository, times(1)).findById(id);
  }
}
