package io.githup.fgericke.quizmentor.bin.security.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This class contains unit tests for the JwtService class. It uses Mockito for mocking
 * dependencies.
 */
class JwtServiceTest {

  /**
   * The class under test.
   */
  @InjectMocks
  private JwtService jwtService;

  /**
   * A mock of UserDetails.
   */
  @Mock
  private UserDetails userDetails;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks if the generateToken method in JwtService works as expected. It asserts that
   * the generated token is not null.
   */
  @Test
  public void shouldGenerateToken() {
    when(userDetails.getUsername()).thenReturn("testUser");
    String token = jwtService.generateToken(userDetails);
    assertNotNull(token);
  }

  /**
   * This test checks if the generateToken method in JwtService works as expected when extra claims
   * are provided. It asserts that the generated token is not null.
   */
  @Test
  public void shouldGenerateTokenWithExtraClaims() {
    when(userDetails.getUsername()).thenReturn("testUser");
    String token = jwtService.generateToken(new HashMap<>(), userDetails);
    assertNotNull(token);
  }

  /**
   * This test checks if the isTokenValid method in JwtService works as expected. It asserts that
   * the token is valid.
   */
  @Test
  public void shouldValidateToken() throws Exception {
    when(userDetails.getUsername()).thenReturn("testUser");
    String token = jwtService.generateToken(userDetails);
    assertTrue(jwtService.isTokenValid(token, userDetails));
  }

  /**
   * This test checks if the isTokenValid method in JwtService works as expected when the username
   * does not match. It asserts that the token is not valid.
   */
  @Test
  public void shouldInvalidateTokenWhenUsernameDoesNotMatch() throws Exception {
    when(userDetails.getUsername()).thenReturn("testUser");
    String token = jwtService.generateToken(userDetails);
    when(userDetails.getUsername()).thenReturn("otherUser");
    assertFalse(jwtService.isTokenValid(token, userDetails));
  }
}
