package io.githup.fgericke.quizmentor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.entity.User;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * This class contains unit tests for the UserRepository. It uses the JUnit 5 and Mockito frameworks
 * for testing and mocking respectively. The class is currently disabled, meaning its tests won't be
 * run.
 */
@DataJpaTest
@Disabled
public class UserRepositoryTest {

  // The email that will be used in the tests
  private final String mail = "mail@example.com";
  // The User object that will be used in the tests
  private User user;
  // The UserRepository that will be tested
  @Autowired
  private UserRepository userRepository;

  /**
   * This method is run before each test. It initializes the User object that will be used in the
   * tests.
   */
  @BeforeEach
  public void init() {
    user = User.builder().mail(mail).build();
  }

  /**
   * This test checks the findByMail method of the UserRepository. It saves a User object to the
   * repository and then attempts to retrieve it using its email. The test asserts that the
   * retrieved User object is the same as the one that was saved.
   */
  @DisplayName("Should find user by mail")
  @Test
  public void shouldFindUserByMail() {
    userRepository.save(user);

    Optional<User> foundUser = userRepository.findByMail(mail);

    assertTrue(foundUser.isPresent());
    assertEquals(user, foundUser.get());
    verify(userRepository, times(1)).findByMail(mail);
  }

  /**
   * This test checks the findByMail method of the UserRepository when the user does not exist. It
   * attempts to retrieve a User object using a non-existing email and asserts that the result is
   * empty.
   */
  @DisplayName("Should not find user by non-existing mail")
  @Test
  public void shouldNotFindUserByNonExistingMail() {
    String mail = "non-existing@example.com";
    when(userRepository.findByMail(mail)).thenReturn(Optional.empty());

    Optional<User> foundUser = userRepository.findByMail(mail);

    assertTrue(foundUser.isEmpty());
    verify(userRepository, times(1)).findByMail(mail);
  }
}
