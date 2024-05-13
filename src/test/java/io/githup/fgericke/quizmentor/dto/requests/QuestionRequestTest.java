import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The QuestionRequestTest class contains unit tests for the QuestionRequest class. It tests the
 * conversion of a QuestionRequest to a Question entity.
 */
class QuestionRequestTest {

  public static final int INTERNAL_SERVER_ERROR = 500;

  /**
   * The QuestionRequest object that will be used in the tests.
   */
  private QuestionRequest questionRequest;

  /**
   * This method is executed before each test. It initializes the QuestionRequest object.
   */
  @BeforeEach
  void setUp() {
    questionRequest = new QuestionRequest();
  }

  /**
   * This test checks the conversion of a QuestionRequest to a Question entity when the title is not
   * null. It sets the title, description, status, and score of the QuestionRequest, converts it to
   * a Question entity, and asserts that the title, description, status, and score of the Question
   * entity are the same as those set in the QuestionRequest.
   */
  @Test
  @DisplayName("Should convert to entity when title is not null")
  void shouldConvertToEntityWhenTitleIsNotNull() {
    questionRequest.setTitle("Test Question");
    questionRequest.setDescription("Test Description");
    questionRequest.setStatus(Visibility.PUBLISHED);
    questionRequest.setScore(10);

    Question question = questionRequest.toEntity();

    assertEquals("Test Question", question.getTitle());
    assertEquals("Test Description", question.getDescription());
    assertEquals(Visibility.PUBLISHED, question.getStatus());
    assertEquals(10, question.getScore());
  }

  /**
   * This test checks the conversion of a QuestionRequest to a Question entity when the title is
   * null. It sets the title of the QuestionRequest to null, tries to convert it to a Question
   * entity, and asserts that a ResponseStatusException is thrown with a 500 status code and a
   * specific error message.
   */
  @Test
  @DisplayName("Should throw exception when title is null")
  void shouldThrowExceptionWhenTitleIsNull() {
    questionRequest.setTitle(null);
    questionRequest.setDescription("Test Description");
    questionRequest.setStatus(Visibility.PUBLISHED);
    questionRequest.setScore(10);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        questionRequest::toEntity);

    assertEquals(HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR), exception.getStatusCode());
    assertEquals("[Question] Title cannot be null", exception.getReason());
  }
}
