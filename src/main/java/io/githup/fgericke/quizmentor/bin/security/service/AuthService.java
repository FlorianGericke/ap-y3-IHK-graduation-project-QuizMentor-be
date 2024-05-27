package io.githup.fgericke.quizmentor.bin.security.service;

import io.githup.fgericke.quizmentor.bin.security.dto.request.AuthRequest;
import io.githup.fgericke.quizmentor.bin.security.dto.response.AuthResponse;
import io.githup.fgericke.quizmentor.dto.mapper.UserMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * This class provides services related to authentication. It uses UserService, UserMapper,
 * JwtService, and AuthenticationManager to perform its operations.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

  /**
   * The UserService, UserMapper, JwtService, and AuthenticationManager are automatically injected
   * into this service using the @RequiredArgsConstructor annotation from Lombok.
   */
  private final UserService userService;
  private final UserMapper userMapper;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  /**
   * This method is used to register a new user. It saves the user to the database and generates a
   * JWT token for the user.
   *
   * @param request the UserRequest object containing the user's details
   * @return an AuthResponse object containing the JWT token
   */
  public AuthResponse register(final UserRequest request) {
    var user = userMapper.toEntity(request);
    userService.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthResponse.builder()
        .token(jwtToken)
        .build();
  }

  /**
   * This method is used to authenticate a user. It verifies the user's credentials and generates a
   * JWT token for the user.
   *
   * @param request the AuthRequest object containing the user's email and password
   * @return an AuthResponse object containing the JWT token
   */
  public AuthResponse authenticate(final AuthRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );

    var admin = userService.findByMail(request.getEmail());

    var jwtToken = jwtService.generateToken(admin);
    return AuthResponse.builder()
        .token(jwtToken)
        .build();
  }
}
