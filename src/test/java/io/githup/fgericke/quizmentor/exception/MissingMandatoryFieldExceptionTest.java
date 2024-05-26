package io.githup.fgericke.quizmentor.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * This class contains unit tests for the MissingMandatoryFieldException class. It tests the
 * exception thrown when a mandatory field is missing.
 */
class MissingMandatoryFieldExceptionTest {

  /**
   * This test checks the exception thrown when a mandatory field is missing. It verifies that the
   * exception has the correct HTTP status code and reason.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndReason() {
    String missingFieldName = "username";

    MissingMandatoryFieldException exception = Assertions.assertThrows(
        MissingMandatoryFieldException.class, () -> {
          throw new MissingMandatoryFieldException(missingFieldName);
        });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(
        exception.getReason().contains("Missing Mandatory Field Exception: " + missingFieldName));
  }

  /**
   * This test checks the exception thrown when a mandatory field is missing and the field name is
   * empty. It verifies that the exception has the correct HTTP status code and reason.
   */
  @Test
  void shouldThrowExceptionWithEmptyFieldName() {
    String missingFieldName = "";

    MissingMandatoryFieldException exception = Assertions.assertThrows(
        MissingMandatoryFieldException.class, () -> {
          throw new MissingMandatoryFieldException(missingFieldName);
        });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains("Missing Mandatory Field Exception: "));
  }
}
