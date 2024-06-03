package io.githup.fgericke.quizmentor.exception;

import org.springframework.http.HttpStatus;

/**
 * This class represents a specific type of QuizMentorException that is thrown when a mandatory
 * field is missing. It extends the QuizMentorException class and includes a specific HTTP status
 * code and reason.
 */
public class MissingMandatoryFieldException extends QuizMentorException {

  /**
   * Constructs a new MissingMandatoryFieldException with the specified HTTP status code and
   * reason.
   *
   * @param missingFieldName The name of the missing field that caused the exception.
   */
  public MissingMandatoryFieldException(final String missingFieldName) {
    super(HttpStatus.UNPROCESSABLE_ENTITY,
        "Missing Mandatory Field Exception: " + missingFieldName);
  }
}
