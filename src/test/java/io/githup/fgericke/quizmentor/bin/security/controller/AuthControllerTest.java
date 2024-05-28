package io.githup.fgericke.quizmentor.bin.security.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.bin.security.dto.request.AuthRequest;
import io.githup.fgericke.quizmentor.bin.security.dto.response.AuthResponse;
import io.githup.fgericke.quizmentor.bin.security.service.AuthService;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

/**
 * AuthControllerTest is a test class for AuthController. It tests the functionality of the register
 * and login methods of AuthController.
 */
public class AuthControllerTest {

  // The AuthController instance to be tested.
  @InjectMocks
  private AuthController authController;

  // The AuthService instance to be mocked.
  @Mock
  private AuthService authService;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks if the register method of AuthController returns a successful response. It
   * mocks the AuthService's register method to return a predefined response. Then it asserts that
   * the response of the AuthController's register method is as expected.
   */
  @Test
  public void registerShouldReturnSuccessfulResponse() {
    UserRequest userRequest = new UserRequest();
    AuthResponse authResponse = new AuthResponse("Example_Token");
    when(authService.register(userRequest)).thenReturn(authResponse);

    ResponseEntity<AuthResponse> response = authController.register(userRequest);

    assertEquals(ResponseEntity.ok(authResponse), response);
  }

  /**
   * This test checks if the login method of AuthController returns a successful response. It mocks
   * the AuthService's authenticate method to return a predefined response. Then it asserts that the
   * response of the AuthController's login method is as expected.
   */
  @Test
  public void loginShouldReturnSuccessfulResponse() {
    AuthRequest authRequest = new AuthRequest();
    AuthResponse authResponse = new AuthResponse("Example_Token");
    when(authService.authenticate(authRequest)).thenReturn(authResponse);

    ResponseEntity<AuthResponse> response = authController.login(authRequest);

    assertEquals(ResponseEntity.ok(authResponse), response);
  }
}
