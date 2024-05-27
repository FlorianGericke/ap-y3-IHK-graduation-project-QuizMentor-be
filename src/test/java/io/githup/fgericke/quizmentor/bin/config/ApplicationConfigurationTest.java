package io.githup.fgericke.quizmentor.bin.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * This class contains unit tests for the ApplicationConfiguration class. It uses Mockito for
 * mocking dependencies.
 */
public class ApplicationConfigurationTest {

  /**
   * The class under test.
   */
  @InjectMocks
  private ApplicationConfiguration applicationConfiguration;

  /**
   * A mock of RepositoryRestConfiguration.
   */
  @Mock
  private RepositoryRestConfiguration repositoryRestConfiguration;

  /**
   * A mock of CorsRegistry.
   */
  @Mock
  private CorsRegistry corsRegistry;

  /**
   * A mock of AuthenticationConfiguration.
   */
  @Mock
  private AuthenticationConfiguration authenticationConfiguration;

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * A mock of UserService. This mock object is used to simulate the data layer and can be
   * programmed to return predefined values in response to method calls. It is used in the tests to
   * isolate the class under test from its dependencies.
   */
  @Mock
  private UserService userService;

  /**
   * This test checks if the RepositoryRestConfiguration is correctly configured.
   */
  @Test
  public void shouldConfigureRepositoryRestConfiguration() {
    applicationConfiguration.configureRepositoryRestConfiguration(repositoryRestConfiguration,
        corsRegistry);
    verify(repositoryRestConfiguration).disableDefaultExposure();
  }

  /**
   * This test checks if the PasswordEncoder bean is correctly provided.
   */
  @Test
  public void shouldProvidePasswordEncoder() {
    PasswordEncoder passwordEncoder = applicationConfiguration.passwordEncoder();
    assertNotNull(passwordEncoder);
  }

  /**
   * This test checks if the AuthenticationManager bean is correctly provided.
   */
  @Test
  @Disabled
  public void shouldProvideAuthenticationManager() throws Exception {
    AuthenticationManager authenticationManager = applicationConfiguration.authenticationManager(
        authenticationConfiguration);
    assertNotNull(authenticationManager);
  }

  /**
   * This test checks if the userDetailsService method in the ApplicationConfiguration class returns
   * a non-null UserDetailsService object when a non-null UserService object is provided. It first
   * mocks the UserService's findByMail method to return a new User object. Then it calls the
   * userDetailsService method with the mocked UserService object and asserts that the returned
   * UserDetailsService object is not null.
   */
  @Test
  public void userDetailsServiceReturnsNotNullWhenUserServiceIsNotNull() {
    when(userService.findByMail(anyString())).thenReturn(new User());
    UserDetailsService userDetailsService = applicationConfiguration.userDetailsService(
        userService);
    assertNotNull(userDetailsService);
  }

  /**
   * This test checks if the userDetailsService method in the ApplicationConfiguration class returns
   * a null UserDetailsService object when a null UserService object is provided. It calls the
   * userDetailsService method with null and asserts that the returned UserDetailsService object is
   * null.
   */
  @Test
  @Disabled
  public void userDetailsServiceReturnsNullWhenUserServiceIsNull() {
    UserDetailsService userDetailsService = applicationConfiguration.userDetailsService(null);
    assertNull(userDetailsService);
  }
}
