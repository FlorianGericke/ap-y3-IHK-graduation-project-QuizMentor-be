package io.githup.fgericke.quizmentor.exception;

import org.springframework.http.HttpStatusCode;

/**
 * CastException is a custom exception class that extends the QuizMentorException. It is used to
 * throw exceptions when a casting operation fails. The exception includes the HTTP status code 500
 * and a custom reason that includes the details of the casting failure.
 */
public class CastException extends QuizMentorException {

  /**
   * Constructs a new CastException with the specified reason. The HTTP status code is set to 500
   * and the reason includes the details of the casting failure.
   *
   * @param reason The details of the casting failure.
   */
  public CastException(String reason) {
    super(HttpStatusCode.valueOf(500), "Cast Exception: " + reason);
  }
}
