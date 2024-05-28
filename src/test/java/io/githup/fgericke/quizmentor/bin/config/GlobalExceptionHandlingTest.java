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

public class GlobalExceptionHandlingTest {

  @InjectMocks
  private GlobalExceptionHandling globalExceptionHandling;

  @Mock
  private WebRequest webRequest;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

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
