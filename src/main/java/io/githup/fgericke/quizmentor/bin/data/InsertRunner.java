package io.githup.fgericke.quizmentor.bin.data;

import io.githup.fgericke.quizmentor.bin.security.service.AuthService;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * This class is a configuration class that is used to insert initial data into the application. It
 * implements CommandLineRunner which means it will execute the run method after the application
 * context is loaded. It is annotated with @Configuration to indicate that it is a configuration
 * class. It is also annotated with @RequiredArgsConstructor to generate a constructor with required
 * fields, in this case, AuthService.
 */
@Configuration
@RequiredArgsConstructor
public class InsertRunner implements CommandLineRunner {

  // AuthService is used to register a new user
  private final AuthService authService;

  /**
   * This method is executed after the application context is loaded. It registers a new user with
   * the email "admin@user.de", password "admin", and role "TRAINER". This is for development and
   * testing purposes only and should not be used in production.
   *
   * @param args command line arguments
   * @throws Exception if an error occurs during user registration
   */
  @Override
  public void run(final String... args) throws Exception {
    // todo: User and Password just for Development and testing, not for production
    authService.register(UserRequest.builder()
        .mail("admin@user.de")
        .password("admin")
        .role(Role.TRAINER)
        .build());
  }
}
