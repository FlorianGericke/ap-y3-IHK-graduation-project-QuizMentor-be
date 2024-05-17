import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuestionResponse class. It tests the mapToResponse method
 * with different scenarios.
 */
class QuestionResponseTest {

  private static final int TEST_SCORE = 10;

  // The QuestionResponse object to be tested
  private QuestionResponse questionResponse;

  // The Question object used as input for the mapToResponse method
  private Question question;

  // Mocked Solution object to be used in tests
  @Mock
  private Solution solution;

  // Mocked Answer object to be used in tests
  @Mock
  private Answer answers;

  /**
   * This method sets up the test environment before each test. It initializes the QuestionResponse
   * and Question objects.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    question = new Question();
    questionResponse = new QuestionResponse();
  }

  /**
   * This test checks if the mapToResponse method returns null when the input is null.
   */
  @DisplayName("Mapping null Question results in null")
  @Test
  void mapNullQuestionResultsInNull() {
    assertNull(questionResponse.map(null));
  }

  /**
   * This test checks if the mapToResponse method correctly maps a Question object with null fields
   * to a QuestionResponse object.
   */
  @DisplayName("Mapping Question with null fields results in corresponding QuestionResponse")
  @Test
  void mapQuestionWithNullFieldsResultsInCorrespondingQuestionResponse() {
    QuestionResponse result = questionResponse.map(question);
    assertNull(result.getId());
    assertNull(result.getIri());
    assertNull(result.getTitle());
    assertNull(result.getDescription());
    assertNull(result.getScore());
  }

  /**
   * This test checks if the mapToResponse method correctly maps a Question object with non-null
   * fields to a QuestionResponse object.
   */
  @DisplayName("Mapping Question with non-null fields results in corresponding QuestionResponse")
  @Test
  void mapQuestionWithNonNullFieldsResultsInCorrespondingQuestionResponse() {
    UUID id = UUID.randomUUID();
    question.setId(id);
    question.setTitle("Question Title");
    question.setDescription("Question Description");
    question.setScore(TEST_SCORE);
    question.setStatus(Visibility.PUBLISHED);
    question.getSolutions().add(solution);
    question.getAnswers().add(answers);

    QuestionResponse result = questionResponse.map(question);
    assertEquals(id, result.getId());
    assertEquals("Question Title", result.getTitle());
    assertEquals("Question Description", result.getDescription());
    assertEquals(true, result.getIsOpen());
    assertEquals(TEST_SCORE, result.getScore());
    assertEquals(Visibility.PUBLISHED, result.getStatus());
    assertNotNull(result.getSolutions());
    assertNotNull(result.getAnswers());
  }
}
