package io.githup.fgericke.quizmentor.exception;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * This class contains unit tests for the EntityNotFoundException class. Each method in this class
 * represents a test case for a specific scenario of the EntityNotFoundException.
 */
class EntityNotFoundExceptionTest {

  /**
   * This test case checks if the EntityNotFoundException is thrown with the correct status code and
   * reason. The expected outcome is that the exception is thrown and the status code and reason
   * match the provided values.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndReason() {
    String identifier = "id";
    String value = "123";

    EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class,
        () -> {
          throw new EntityNotFoundException(identifier, value);
        });

    Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains(identifier));
    Assertions.assertTrue(exception.getReason().contains(value));
  }

  /**
   * This test case checks if the EntityNotFoundException is thrown with the correct status code and
   * UUID reason. The expected outcome is that the exception is thrown and the status code and
   * reason match the provided values.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndUUIDReason() {
    String identifier = "id";
    UUID value = UUID.randomUUID();

    EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class,
        () -> {
          throw new EntityNotFoundException(identifier, value);
        });

    Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains(identifier));
    Assertions.assertTrue(exception.getReason().contains(value.toString()));
  }

  /**
   * This test case checks if the EntityNotFoundException is thrown with the correct status code and
   * UUID id. The expected outcome is that the exception is thrown and the status code and reason
   * match the provided values.
   */
  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndUUIDId() {
    UUID id = UUID.randomUUID();

    EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class,
        () -> {
          throw new EntityNotFoundException(id);
        });

    Assertions.assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains("id"));
    Assertions.assertTrue(exception.getReason().contains(id.toString()));
  }
}
