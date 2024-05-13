package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The QuizRequestTest class contains unit tests for the QuizRequest class. It tests the conversion
 * of a QuizRequest to a Quiz entity.
 */
class QuizRequestTest {

  private static final String TEST_QUIZ = "Test Quiz";
  private static final String TEST_DESCRIPTION = "Test Description";
  private static final Visibility TEST_VISIBILITY = Visibility.PUBLISHED;
  private static final String EXCEPTION_REASON = "[QUIZ] Title cannot be null";
  private static final HttpStatus EXCEPTION_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;


  /**
   * The QuizRequest object that will be used in the tests.
   */
  private QuizRequest quizRequest;

  /**
   * This method is executed before each test. It initializes the QuizRequest object.
   */
  @BeforeEach
  void setUp() {
    quizRequest = new QuizRequest();
  }

  /**
   * This test checks the conversion of a QuizRequest to a Quiz entity when the title is not null.
   * It sets the title, description, and status of the QuizRequest, converts it to a Quiz entity,
   * and asserts that the title, description, and status of the Quiz entity are the same as those
   * set in the QuizRequest.
   */
  @Test
  @DisplayName("Should convert to entity when title is not null")
  void shouldConvertToEntityWhenTitleIsNotNull() {
    quizRequest.setTitle(TEST_QUIZ);
    quizRequest.setDescription(TEST_DESCRIPTION);
    quizRequest.setStatus(TEST_VISIBILITY);

    Quiz quiz = quizRequest.toEntity();

    assertEquals(TEST_QUIZ, quiz.getTitle());
    assertEquals(TEST_DESCRIPTION, quiz.getDescription());
    assertEquals(TEST_VISIBILITY, quiz.getVisibility());
  }

  /**
   * This test checks the conversion of a QuizRequest to a Quiz entity when the title is null. It
   * sets the title of the QuizRequest to null, tries to convert it to a Quiz entity, and asserts
   * that a ResponseStatusException is thrown with a 500 status code and a specific error message.
   */
  @Test
  @DisplayName("Should throw exception when title is null")
  void shouldThrowExceptionWhenTitleIsNull() {
    quizRequest.setTitle(null);
    quizRequest.setDescription(TEST_DESCRIPTION);
    quizRequest.setStatus(TEST_VISIBILITY);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        quizRequest::toEntity);

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }
}
