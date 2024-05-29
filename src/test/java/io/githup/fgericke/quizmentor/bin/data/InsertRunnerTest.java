package io.githup.fgericke.quizmentor.bin.data;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.githup.fgericke.quizmentor.bin.security.service.AuthService;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class is a test class for the InsertRunner class. It uses Mockito for mocking dependencies
 * and JUnit for running the tests.
 */
public class InsertRunnerTest {

  // The class under test is annotated with @InjectMocks to inject the mocked dependencies
  @InjectMocks
  private InsertRunner insertRunner;

  // The AuthService dependency is mocked
  @Mock
  private AuthService authService;

  /**
   * This method is run before each test. It initializes the mocks.
   */
  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test verifies that a new user is registered when the application starts. It does this by
   * verifying that the register method of the AuthService is called with the expected UserRequest.
   *
   * @throws Exception if an error occurs during the test
   */
  @Test
  public void shouldRegisterNewUserOnApplicationStart() throws Exception {
    // Given
    UserRequest expectedUserRequest = UserRequest.builder()
        .mail("admin@user.de")
        .password("admin")
        .role(Role.TRAINER)
        .build();

    // When
    insertRunner.run();

    // Then
    verify(authService, times(1)).register(expectedUserRequest);
  }
}
