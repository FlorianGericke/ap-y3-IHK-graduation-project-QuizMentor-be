package io.githup.fgericke.quizmentor.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class CastExceptionTest {

  @Test
  void shouldThrowExceptionWithCorrectStatusCodeAndReason() {
    String reason = "Failed to cast Integer to String";

    CastException exception = Assertions.assertThrows(CastException.class, () -> {
      throw new CastException(reason);
    });

    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatusCode());
    Assertions.assertTrue(exception.getReason().contains(reason));
  }

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
