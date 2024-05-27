package io.githup.fgericke.quizmentor.bin.security.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class is a test class for the AuthRequest class. It contains unit tests that ensure the
 * correct behavior of the AuthRequest class.
 */
class AuthRequestTest {

  /**
   * The AuthRequest object that will be tested.
   */
  private AuthRequest authRequest;

  /**
   * This method sets up the testing environment before each test. It initializes the AuthRequest
   * object with a test email and password.
   */
  @BeforeEach
  void setUp() {
    authRequest = AuthRequest.builder().email("test@test.com").password("testPassword").build();
  }

  /**
   * This test ensures that the AuthRequest object is created with the correct email.
   */
  @Test
  @DisplayName("Should create AuthRequest with correct email")
  void shouldCreateAuthRequestWithCorrectEmail() {
    assertEquals("test@test.com", authRequest.getEmail());
  }

  /**
   * This test ensures that the AuthRequest object is created with the correct password.
   */
  @Test
  @DisplayName("Should create AuthRequest with correct password")
  void shouldCreateAuthRequestWithCorrectPassword() {
    assertEquals("testPassword", authRequest.getPassword());
  }

  /**
   * This test ensures that the AuthRequest object is not null when it is created.
   */
  @Test
  @DisplayName("Should create non-null AuthRequest")
  void shouldCreateNonNullAuthRequest() {
    assertNotNull(authRequest);
  }
}
