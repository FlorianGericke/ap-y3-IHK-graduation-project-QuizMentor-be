package io.githup.fgericke.quizmentor.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * QuizMentorException is a custom exception class that extends the ResponseStatusException. It is
 * used to throw custom exceptions with a specific HTTP status code and a reason.
 */
public class QuizMentorException extends ResponseStatusException {

  /**
   * Constructs a new QuizMentorException with the specified HTTP status code and reason.
   *
   * @param status The HTTP status code.
   * @param reason The associated reason for the exception.
   */
  public QuizMentorException(HttpStatusCode status, String reason) {
    super(status, reason);
  }
}
