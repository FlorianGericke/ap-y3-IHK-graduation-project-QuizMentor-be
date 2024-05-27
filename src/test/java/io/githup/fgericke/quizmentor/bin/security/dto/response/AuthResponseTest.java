package io.githup.fgericke.quizmentor.bin.security.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class is a test class for the AuthResponse class. It contains unit tests that ensure the
 * correct behavior of the AuthResponse class.
 */
class AuthResponseTest {

  /**
   * The AuthResponse object that will be tested.
   */
  private AuthResponse authResponse;

  /**
   * This method sets up the testing environment before each test. It initializes the AuthResponse
   * object with a test token.
   */
  @BeforeEach
  void setUp() {
    authResponse = AuthResponse.builder().token("testToken").build();
  }

  /**
   * This test ensures that the AuthResponse object is created with the correct token.
   */
  @Test
  @DisplayName("Should create AuthResponse with correct token")
  void shouldCreateAuthResponseWithCorrectToken() {
    assertEquals("testToken", authResponse.getToken());
  }

  /**
   * This test ensures that the AuthResponse object is not null when it is created.
   */
  @Test
  @DisplayName("Should create non-null AuthResponse")
  void shouldCreateNonNullAuthResponse() {
    assertNotNull(authResponse);
  }
}
