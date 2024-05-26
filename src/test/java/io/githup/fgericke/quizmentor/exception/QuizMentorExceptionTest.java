package io.githup.fgericke.quizmentor.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * This class contains unit tests for the QuizMentorException class. Each method in this class
 * represents a test case for a specific scenario of the QuizMentorException.
 */
class QuizMentorExceptionTest {

  /**
   * This test case checks if the QuizMentorException is thrown with the correct status code and
   * reason. The expected outcome is that the exception is thrown and the status code and reason
   * match the provided values.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndReason() {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    String reason = "Bad Request";

    QuizMentorException exception = Assertions.assertThrows(QuizMentorException.class, () -> {
      throw new QuizMentorException(status, reason);
    });

    Assertions.assertEquals(status, exception.getStatusCode());
    Assertions.assertEquals(reason, exception.getReason());
  }

  /**
   * This test case checks if the QuizMentorException is thrown with the correct status code and no
   * reason. The expected outcome is that the exception is thrown and the status code matches the
   * provided value, while the reason is null.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndNoReason() {
    HttpStatus status = HttpStatus.BAD_REQUEST;

    QuizMentorException exception = Assertions.assertThrows(QuizMentorException.class, () -> {
      throw new QuizMentorException(status, null);
    });

    Assertions.assertEquals(status, exception.getStatusCode());
    Assertions.assertNull(exception.getReason());
  }
}
