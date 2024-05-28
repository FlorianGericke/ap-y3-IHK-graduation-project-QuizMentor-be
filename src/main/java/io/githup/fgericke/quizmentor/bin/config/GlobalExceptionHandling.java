package io.githup.fgericke.quizmentor.bin.config;

import io.githup.fgericke.quizmentor.exception.QuizMentorException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * GlobalExceptionHandling is a class that handles all exceptions thrown across the application. It
 * uses the @ControllerAdvice annotation to be automatically used across all @Controller classes.
 * This class is final, meaning it cannot be subclassed.
 */
@ControllerAdvice
public final class GlobalExceptionHandling {

  /**
   * This method handles all QuizMentorException instances thrown across the application. It creates
   * a response body with details about the exception and returns it in a ResponseEntity. The
   * response body includes the timestamp of the exception, the type of the exception, and the
   * message of the exception. During development, the stack trace of the exception is also included
   * in the response body.
   *
   * @param ex      The QuizMentorException instance to be handled. This is the exception that was
   *                thrown.
   * @param request The WebRequest instance that caused the exception. This is the request during
   *                which the exception was thrown.
   * @return A ResponseEntity containing the response body with details about the exception. The
   * status code of the ResponseEntity is the same as the status code of the exception.
   */
  @ExceptionHandler(QuizMentorException.class)
  public ResponseEntity<Object> handleMyCustomException(final QuizMentorException ex,
      final WebRequest request) {
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

  // todo: Only for Development

  /**
   * This method handles all Exception instances thrown across the application. It creates a
   * response body with details about the exception and returns it in a ResponseEntity. The response
   * body includes the timestamp of the exception, the type of the exception, and the message of the
   * exception. During development, the stack trace of the exception is also included in the
   * response body.
   *
   * @param ex      The Exception instance to be handled. This is the exception that was thrown.
   * @param request The WebRequest instance that caused the exception. This is the request during
   *                which the exception was thrown.
   * @return A ResponseEntity containing the response body with details about the exception. The
   * status code of the ResponseEntity is 500, indicating an internal server error.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleMyCustomException(final Exception ex,
      final WebRequest request) {
    // Create a response body, possibly a Map or a custom error object
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("type", ex.getClass().getSimpleName());
    body.put("message", ex.getMessage());

    // todo Only for Development
    body.put("stackTrace", ex.getStackTrace());

    // You can add more details to the body as needed
    return new ResponseEntity<>(body, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
  }
}
