package io.githup.fgericke.quizmentor.bin.config;

import io.githup.fgericke.quizmentor.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * This class provides configuration for the application. It implements the RepositoryRestConfigurer
 * interface to customize the configuration for Spring Data REST. It also provides beans for
 * PasswordEncoder and AuthenticationManager.
 */
@Configuration
public class ApplicationConfiguration implements RepositoryRestConfigurer {

  /**
   * This method is used to customize the RepositoryRestConfiguration and CorsRegistry. It disables
   * the default exposure of all repositories and then calls the super implementation.
   *
   * @param config the RepositoryRestConfiguration object
   * @param cors   the CorsRegistry object
   */
  @Override
  public void configureRepositoryRestConfiguration(
      final RepositoryRestConfiguration config,
      final CorsRegistry cors) {
    // Disable the default exposure of all repositories
    config.disableDefaultExposure();

    // Call the super implementation
    RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
  }

  /**
   * This method provides a bean for PasswordEncoder. It uses BCryptPasswordEncoder for encoding
   * passwords.
   *
   * @return a PasswordEncoder object
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * This method provides a bean for AuthenticationManager. It uses the AuthenticationManager from
   * the provided AuthenticationConfiguration.
   *
   * @param authenticationConfiguration the AuthenticationConfiguration object
   * @return an AuthenticationManager object
   * @throws Exception if an error occurs while getting the AuthenticationManager
   */
  @Bean
  public AuthenticationManager authenticationManager(
      final AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  /**
   * This method provides a bean for UserDetailsService. It uses the UserService to find a user by
   * their email.
   *
   * @param userService the UserService object
   * @return a UserDetailsService object
   */
  @Bean
  public UserDetailsService userDetailsService(final UserService userService) {
    return userService::findByMail;
  }
}
