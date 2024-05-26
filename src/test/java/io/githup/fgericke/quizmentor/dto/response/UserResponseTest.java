package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the UserResponse class. It tests the getter and setter methods
 * of the UserResponse class.
 */
class UserResponseTest {

  // Instance of UserResponse to be used in the tests
  private UserResponse userResponse;

  /**
   * This method sets up the UserResponse instance before each test.
   */
  @BeforeEach
  void setUp() {
    userResponse = new UserResponse();
  }

  /**
   * This test checks the setter and getter for the mail field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get mail correctly")
  @Test
  void shouldSetAndGetMail() {
    String expectedMail = "test@mail.com";
    userResponse.setMail(expectedMail);
    String actualMail = userResponse.getMail();
    assertEquals(expectedMail, actualMail);
  }

  /**
   * This test checks the setter and getter for the role field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get role correctly")
  @Test
  void shouldSetAndGetRole() {
    Role expectedRole = Role.TRAINER;
    userResponse.setRole(expectedRole);
    Role actualRole = userResponse.getRole();
    assertEquals(expectedRole, actualRole);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    userResponse.setMail(null);
    userResponse.setRole(null);

    assertNull(userResponse.getMail());
    assertNull(userResponse.getRole());
  }
}
