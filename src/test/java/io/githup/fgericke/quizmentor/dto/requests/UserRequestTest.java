package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The UserRequestTest class contains unit tests for the UserRequest class. It tests the conversion
 * of a UserRequest to a User entity.
 */
class UserRequestTest {

  private static final String TEST_MAIL = "test@mail.com";
  private static final String TEST_PASSWORD = "testPassword";
  private static final Role TEST_ROLE_MENTOR = Role.MENTOR;
  private static final Role TEST_ROLE_TRAINEE = Role.TRAINEE;
  private static final Role TEST_ROLE_TRAINER = Role.TRAINER;
  private static final String EXCEPTION_REASON = "[User] Mail,Password cannot be null";
  private static final HttpStatus EXCEPTION_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

  /**
   * The UserRequest object that will be used in the tests.
   */
  private UserRequest userRequest;

  /**
   * This method is executed before each test. It initializes the UserRequest object.
   */
  @BeforeEach
  void setUp() {
    userRequest = new UserRequest();
  }

  /**
   * This test checks the conversion of a UserRequest to a User entity when the mail and password
   * are not null. It sets the mail, password, and role of the UserRequest, converts it to a User
   * entity, and asserts that the mail, password, and role of the User entity are the same as those
   * set in the UserRequest.
   */
  @Test
  @DisplayName("Should convert to entity when mail and password are not null")
  void shouldConvertToEntityWhenMailAndPasswordAreNotNull() {
    userRequest.setMail(TEST_MAIL);
    userRequest.setPassword(TEST_PASSWORD);
    userRequest.setRole(TEST_ROLE_MENTOR);

    User user = userRequest.toEntity();

    assertEquals(TEST_MAIL, user.getMail());
    assertEquals(TEST_PASSWORD, user.getPassword());
    assertEquals(TEST_ROLE_MENTOR, user.getRole());
  }

  /**
   * This test checks the conversion of a UserRequest to a User entity when the mail is null. It
   * sets the mail of the UserRequest to null, tries to convert it to a User entity, and asserts
   * that a ResponseStatusException is thrown with a 500 status code and a specific error message.
   */
  @Test
  @DisplayName("Should throw exception when mail is null")
  void shouldThrowExceptionWhenMailIsNull() {
    userRequest.setMail(null);
    userRequest.setPassword(TEST_PASSWORD);
    userRequest.setRole(TEST_ROLE_TRAINEE);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        userRequest::toEntity);

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }

  /**
   * This test checks the conversion of a UserRequest to a User entity when the password is null. It
   * sets the password of the UserRequest to null, tries to convert it to a User entity, and asserts
   * that a ResponseStatusException is thrown with a 500 status code and a specific error message.
   */
  @Test
  @DisplayName("Should throw exception when password is null")
  void shouldThrowExceptionWhenPasswordIsNull() {
    userRequest.setMail(TEST_MAIL);
    userRequest.setPassword(null);
    userRequest.setRole(TEST_ROLE_TRAINER);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        userRequest::toEntity);

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }
}
