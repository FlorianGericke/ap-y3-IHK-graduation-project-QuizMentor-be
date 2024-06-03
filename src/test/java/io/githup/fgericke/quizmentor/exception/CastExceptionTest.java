package io.githup.fgericke.quizmentor.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * This class contains unit tests for the CastException class. Each method in this class represents
 * a test case for a specific scenario of the CastException.
 */
class CastExceptionTest {

  /**
   * This test case checks if the CastException is thrown with the correct status code and reason.
   * The expected outcome is that the exception is thrown and the status code and reason match the
   * provided values.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndReason() {
    String reason = "Failed to cast Integer to String";

    CastException exception = Assertions.assertThrows(CastException.class, () -> {
      throw new CastException(reason);
    });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains(reason));
  }

  /**
   * This test case checks if the CastException is thrown with an empty reason. The expected outcome
   * is that the exception is thrown and the status code and reason match the provided values.
   */
  @Test
  void shouldThrowExceptionWithEmptyReason() {
    String reason = "";

    CastException exception = Assertions.assertThrows(CastException.class, () -> {
      throw new CastException(reason);
    });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains("Cast Exception: "));
  }
}
