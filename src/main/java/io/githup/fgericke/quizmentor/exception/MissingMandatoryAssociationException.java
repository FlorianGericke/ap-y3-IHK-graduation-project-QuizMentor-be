package io.githup.fgericke.quizmentor.exception;

import org.springframework.http.HttpStatus;

/**
 * MissingMandatoryAssociationException is a custom exception class that extends the
 * QuizMentorException. It is used to throw exceptions when a mandatory association is missing in
 * the database. The exception includes a custom HTTP status code and a custom reason that includes
 * the details of the missing association.
 */
public class MissingMandatoryAssociationException extends QuizMentorException {

  /**
   * Constructs a new MissingMandatoryAssociationException with the specified status and reason. The
   * HTTP status code and the reason are provided as parameters.
   *
   * @param missingAssociationType The details of the missing association.
   */
  public MissingMandatoryAssociationException(final String missingAssociationType) {
    super(HttpStatus.UNPROCESSABLE_ENTITY,
        "Missing Mandatory Association Exception: " + missingAssociationType);
  }
}
