package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.UserMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the UserService class.
 */
class UserServiceTest {

  @Mock
  private UserRepository userRepository; // Mock of UserRepository

  @Mock
  private UserMapper userMapper; // Mock of UserMapper

  @InjectMocks
  private UserService userService; // The service under test

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize the mocks
  }

  /**
   * This test verifies that the patch method of the UserService correctly updates the user fields
   * when new values are provided in the request.
   */
  @Test
  void patchShouldUpdateUserFieldsWhenNewValuesAreProvided() {
    User existingUser = new User();
    existingUser.setMail("old@mail.com");
    existingUser.setPassword("oldPassword");
    existingUser.setRole(Role.TRAINEE);

    UserRequest userRequest = new UserRequest();
    userRequest.setMail("new@mail.com");
    userRequest.setPassword("newPassword");
    userRequest.setRole(Role.MENTOR);

    User updatedUser = userService.patch(existingUser, userRequest);

    assertEquals("new@mail.com", updatedUser.getMail()); // Assert that the mail has been updated
    assertEquals("newPassword",
        updatedUser.getPassword()); // Assert that the password has been updated
    assertEquals(Role.MENTOR, updatedUser.getRole()); // Assert that the role has been updated
  }

  /**
   * This test verifies that the patch method of the UserService keeps the existing user fields when
   * no new values are provided in the request.
   */
  @Test
  void patchShouldKeepExistingUserFieldsWhenNoNewValuesAreProvided() {
    User existingUser = new User();
    existingUser.setMail("existing@mail.com");
    existingUser.setPassword("existingPassword");
    existingUser.setRole(Role.TRAINEE);

    UserRequest userRequest = new UserRequest();

    User updatedUser = userService.patch(existingUser, userRequest);

    assertEquals("existing@mail.com",
        updatedUser.getMail()); // Assert that the mail has not been updated
    assertEquals("existingPassword",
        updatedUser.getPassword()); // Assert that the password has not been updated
    assertEquals(Role.TRAINEE, updatedUser.getRole()); // Assert that the role has not been updated
  }
}
