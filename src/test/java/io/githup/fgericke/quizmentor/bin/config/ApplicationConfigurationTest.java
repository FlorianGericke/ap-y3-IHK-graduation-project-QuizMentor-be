package io.githup.fgericke.quizmentor.bin.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
}
