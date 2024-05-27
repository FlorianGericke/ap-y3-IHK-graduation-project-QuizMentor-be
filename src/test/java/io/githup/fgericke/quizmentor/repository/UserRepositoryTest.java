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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * This class contains unit tests for the UserRepository class. It tests the basic CRUD operations:
 * save, find by ID, and delete by ID. The tests are currently disabled and need a test environment
 * to run against a test database.
 */
@Disabled
@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  //  @Mock
  private User user;

  /**
   * This method sets up the test environment before each test. It initializes a new User.
   */
  @BeforeEach
  public void init() {
//    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the find by ID operation of the UserRepository.
   * It verifies that a User can be found by its ID.
   */
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

  /**
   * This test checks the save operation of the UserRepository.
   * It verifies that a User can be saved.
   */
  @Test
  @Disabled
  public void shouldSaveUser() {
    when(userRepository.save(user)).thenReturn(user);

    User savedUser = userRepository.save(user);

    assertEquals(user, savedUser);
    verify(userRepository, times(1)).save(user);
  }

  /**
   * This test checks the find by ID operation of the UserRepository when the ID does not exist.
   * It verifies that a User cannot be found by a non-existing ID.
   */
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
