package io.githup.fgericke.quizmentor.bin.config;

import io.githup.fgericke.quizmentor.exception.QuizMentorException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * GlobalExceptionHandling is a class that handles all exceptions thrown across the application. It
 * uses the @ControllerAdvice annotation to be automatically used across all @Controller classes.
 */
@ControllerAdvice
public class GlobalExceptionHandling {

  /**
   * This method handles all QuizMentorException instances thrown across the application. It creates
   * a response body with details about the exception and returns it in a ResponseEntity.
   *
   * @param ex      The QuizMentorException instance to be handled.
   * @param request The WebRequest instance that caused the exception.
   * @return A ResponseEntity containing the response body with details about the exception.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleMyCustomException(QuizMentorException ex,
      WebRequest request) {
    // Create a response body, possibly a Map or a custom error object
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("type", ex.getClass().getSimpleName());
    body.put("message", ex.getMessage());

    // todo Only for Development
    body.put("stackTrace", ex.getStackTrace());

    // You can add more details to the body as needed
    return new ResponseEntity<>(body, ex.getStatusCode());
  }
}
