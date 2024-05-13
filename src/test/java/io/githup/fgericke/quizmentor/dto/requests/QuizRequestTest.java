import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The QuizRequestTest class contains unit tests for the QuizRequest class. It tests the conversion
 * of a QuizRequest to a Quiz entity.
 */
class QuizRequestTest {

  public static final int INTERNAL_SERVER_ERROR = 500;

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
    quizRequest.setTitle("Test Quiz");
    quizRequest.setDescription("Test Description");
    quizRequest.setStatus(Visibility.PUBLISHED);

    Quiz quiz = quizRequest.toEntity();

    assertEquals("Test Quiz", quiz.getTitle());
    assertEquals("Test Description", quiz.getDescription());
    assertEquals(Visibility.PUBLISHED, quiz.getVisibility());
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
    quizRequest.setDescription("Test Description");
    quizRequest.setStatus(Visibility.PUBLISHED);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        quizRequest::toEntity);

    assertEquals(HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR), exception.getStatusCode());
    assertEquals("[QUIZ] Title cannot be null", exception.getReason());
  }
}
