package io.githup.fgericke.quizmentor.bin.security.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.bin.security.dto.request.AuthRequest;
import io.githup.fgericke.quizmentor.bin.security.dto.response.AuthResponse;
import io.githup.fgericke.quizmentor.dto.mapper.UserMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * This class contains unit tests for the AuthService class. It uses Mockito for mocking
 * dependencies.
 */
public class AuthServiceTest {

  /**
   * The class under test.
   */
  @InjectMocks
  private AuthService authService;

  /**
   * A mock of UserService.
   */
  @Mock
  private UserService userService;

  /**
   * A mock of UserMapper.
   */
  @Mock
  private UserMapper userMapper;

  /**
   * A mock of JwtService.
   */
  @Mock
  private JwtService jwtService;

  /**
   * A mock of AuthenticationManager.
   */
  @Mock
  private AuthenticationManager authenticationManager;

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks if the register method in AuthService works as expected.
   */
  @Test
  public void shouldRegisterUser() {
    UserRequest userRequest = new UserRequest();
    User user = new User();
    when(userMapper.toEntity(userRequest)).thenReturn(user);
    doNothing().when(userService).save(user);
    when(jwtService.generateToken(user)).thenReturn("token");

    AuthResponse response = authService.register(userRequest);

    assertEquals("token", response.getToken());
  }

  /**
   * This test checks if the authenticate method in AuthService works as expected.
   */
  @Test
  public void shouldAuthenticateUser() {
    AuthRequest authRequest = new AuthRequest();
    authRequest.setEmail("test@test.com");
    authRequest.setPassword("password");
    User user = new User();
    when(userService.findByMail(authRequest.getEmail())).thenReturn(user);
    when(jwtService.generateToken(user)).thenReturn("token");

    AuthResponse response = authService.authenticate(authRequest);

    assertEquals("token", response.getToken());
  }
}
