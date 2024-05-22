package io.githup.fgericke.quizmentor.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * This class contains unit tests for the MissingMandatoryAssociationException class. Each method in
 * this class represents a test case for a specific scenario of the
 * MissingMandatoryAssociationException.
 */
class MissingMandatoryAssociationExceptionTest {

  /**
   * This test case checks if the MissingMandatoryAssociationException is thrown with the correct
   * status code and reason. The expected outcome is that the exception is thrown and the status
   * code and reason match the provided values.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndReason() {
    String missingAssociationType = "User-Quiz";

    MissingMandatoryAssociationException exception = Assertions.assertThrows(
        MissingMandatoryAssociationException.class, () -> {
          throw new MissingMandatoryAssociationException(missingAssociationType);
        });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains(missingAssociationType));
  }

  /**
   * This test case checks if the MissingMandatoryAssociationException is thrown with an empty
   * association type. The expected outcome is that the exception is thrown and the status code and
   * reason match the provided values.
   */
  @Test
  void shouldThrowExceptionWithEmptyAssociationType() {
    String missingAssociationType = "";

    MissingMandatoryAssociationException exception = Assertions.assertThrows(
        MissingMandatoryAssociationException.class, () -> {
          throw new MissingMandatoryAssociationException(missingAssociationType);
        });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(
        exception.getReason().contains("Missing Mandatory Association Exception: "));
  }
}
