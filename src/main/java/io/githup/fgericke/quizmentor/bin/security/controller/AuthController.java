package io.githup.fgericke.quizmentor.bin.security.controller;

import io.githup.fgericke.quizmentor.bin.security.dto.request.AuthRequest;
import io.githup.fgericke.quizmentor.bin.security.dto.response.AuthResponse;
import io.githup.fgericke.quizmentor.bin.security.service.AuthService;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController is a REST controller that handles authentication related requests. It provides
 * endpoints for user registration and login.
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  // AuthService is used to handle the business logic related to authentication.
  private final AuthService authService;

  /**
   * This method handles the user registration process. It takes a UserRequest object as input and
   * returns a ResponseEntity with an AuthResponse object.
   *
   * @param request A UserRequest object containing the user's registration details.
   * @return A ResponseEntity containing an AuthResponse object with the registration status.
   */
  @PostMapping("/register")
  public @ResponseBody ResponseEntity<AuthResponse> register(
      @RequestBody final UserRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }

  /**
   * This method handles the user login process. It takes an AuthRequest object as input and returns
   * a ResponseEntity with an AuthResponse object.
   *
   * @param request An AuthRequest object containing the user's login details.
   * @return A ResponseEntity containing an AuthResponse object with the login status.
   */
  @PostMapping("/login")
  public @ResponseBody ResponseEntity<AuthResponse> login(
      @RequestBody final AuthRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));
  }
}
