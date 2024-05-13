import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The UserRequestTest class contains unit tests for the UserRequest class. It tests the conversion
 * of a UserRequest to a User entity.
 */
class UserRequestTest {

  public static final int INTERNAL_SERVER_ERROR = 500;

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
    userRequest.setMail("test@mail.com");
    userRequest.setPassword("testPassword");
    userRequest.setRole(Role.MENTOR);

    User user = userRequest.toEntity();

    assertEquals("test@mail.com", user.getMail());
    assertEquals("testPassword", user.getPassword());
    assertEquals(Role.MENTOR, user.getRole());
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
    userRequest.setPassword("testPassword");
    userRequest.setRole(Role.TRAINEE);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        userRequest::toEntity);

    assertEquals(HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR), exception.getStatusCode());
    assertEquals("[User] Mail,Password cannot be null", exception.getReason());
  }

  /**
   * This test checks the conversion of a UserRequest to a User entity when the password is null. It
   * sets the password of the UserRequest to null, tries to convert it to a User entity, and asserts
   * that a ResponseStatusException is thrown with a 500 status code and a specific error message.
   */
  @Test
  @DisplayName("Should throw exception when password is null")
  void shouldThrowExceptionWhenPasswordIsNull() {
    userRequest.setMail("test@mail.com");
    userRequest.setPassword(null);
    userRequest.setRole(Role.TRAINER);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        userRequest::toEntity);

    assertEquals(HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR), exception.getStatusCode());
    assertEquals("[User] Mail,Password cannot be null", exception.getReason());
  }
}
