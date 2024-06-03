package io.githup.fgericke.quizmentor.bin.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.exception.QuizMentorException;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

/**
 * This class tests the functionality of the GlobalExceptionHandling class. It uses Mockito for
 * mocking dependencies and JUnit for running the tests.
 */
public class GlobalExceptionHandlingTest {

  // The GlobalExceptionHandling instance to be tested.
  @InjectMocks
  private GlobalExceptionHandling globalExceptionHandling;

  // The WebRequest instance to be mocked.
  @Mock
  private WebRequest webRequest;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks if the handleMyCustomException method of GlobalExceptionHandling returns the
   * expected response. It mocks the WebRequest's getDescription method to return a predefined
   * description. Then it asserts that the status code, type, and message of the response are as
   * expected.
   */
  @Test
  public void handleMyCustomExceptionShouldReturnExpectedResponse() {
    QuizMentorException ex = new QuizMentorException(HttpStatus.BAD_REQUEST, "Test exception");
    when(webRequest.getDescription(false)).thenReturn("Test request");

    ResponseEntity<Object> response = globalExceptionHandling.handleMyCustomException(ex,
        webRequest);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    Map<String, Object> body = (Map<String, Object>) response.getBody();
    assertEquals("QuizMentorException", body.get("type"));
    assertEquals("400 BAD_REQUEST \"Test exception\"", body.get("message"));
  }
}
