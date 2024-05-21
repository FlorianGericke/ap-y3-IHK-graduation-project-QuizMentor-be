package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the UserResponse class. It tests the map method of the
 * UserResponse class.
 */
class UserResponseTest {

  /**
   * This test checks the map method when the User object is not null. It creates a User object with
   * a mail and a role, and maps it to a UserResponse object. It then checks if the mail and role in
   * the UserResponse object match the ones in the User object.
   */
  @Test
  void mapShouldReturnUserResponseWhenUserIsNotNull() {
    // Given
    User user = new User();
    user.setMail("test@mail.com");
    user.setRole(Role.TRAINER);

    UserResponse userResponse = new UserResponse();

    // When
    UserResponse result = userResponse.map(user);

    // Then
    assertEquals("test@mail.com", result.getMail());
    assertEquals(Role.TRAINER, result.getRole());
  }

  /**
   * This test checks the map method when the User object is null. It tries to map a null User
   * object to a UserResponse object. It then checks if the result is null.
   */
  @Test
  void mapShouldReturnNullWhenUserIsNull() {
    // Given
    UserResponse userResponse = new UserResponse();

    // When
    UserResponse result = userResponse.map(null);

    // Then
    assertNull(result);
  }
}
