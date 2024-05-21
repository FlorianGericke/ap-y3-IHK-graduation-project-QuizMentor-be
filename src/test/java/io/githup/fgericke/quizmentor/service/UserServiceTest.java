package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the UserService class. It tests the patch method of the
 * UserService class.
 */
class UserServiceTest {

  /**
   * Mock of UserRepository used in the tests.
   */
  @Mock
  private UserRepository userRepository;

  /**
   * Mock of UserRequest used in the tests.
   */
  @Mock
  private UserRequest userRequest;

  /**
   * Instance of UserService with injected mocks.
   */
  @InjectMocks
  private UserService userService;

  /**
   * Setup method that initializes the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the patch method when the UserRequest object has non-null fields. It creates a
   * User object and a UserRequest object with non-null fields, and calls the patch method. It then
   * checks if the fields in the updated User object match the ones in the UserRequest object.
   */
  @Test
  @Disabled
  void patchShouldUpdateNonNullFields() {
    User user = new User();
    userRequest.setMail("new@mail.com");
    userRequest.setPassword("newPassword");
    userRequest.setRole(Role.TRAINER);

    when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);

    User updatedUser = userService.patch(user, userRequest);

    assertEquals("new@mail.com", updatedUser.getMail());
    assertEquals("newPassword", updatedUser.getPassword());
    assertEquals(Role.TRAINER, updatedUser.getRole());
  }

  /**
   * This test checks the patch method when the UserRequest object has null fields. It creates a
   * User object with non-null fields and a UserRequest object with null fields, and calls the patch
   * method. It then checks if the fields in the updated User object remain the same.
   */
  @Test
  void patchShouldNotUpdateNullFields() {
    User user = new User();
    user.setMail("old@mail.com");
    user.setPassword("oldPassword");
    user.setRole(Role.TRAINER);

    when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);

    User updatedUser = userService.patch(user, userRequest);

    assertEquals("old@mail.com", updatedUser.getMail());
    assertEquals("oldPassword", updatedUser.getPassword());
    assertEquals(Role.TRAINER, updatedUser.getRole());
  }
}
