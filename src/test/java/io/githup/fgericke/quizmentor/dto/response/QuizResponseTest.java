import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.User;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the QuizResponse class.
 */
class QuizResponseTest {

  private Quiz quiz;
  private QuizResponse quizResponse;

  /**
   * This method sets up the test environment before each test. It initializes a new Quiz and
   * QuizResponse object.
   */
  @BeforeEach
  void setUp() {
    quiz = new Quiz();
    quizResponse = new QuizResponse();
  }

  /**
   * This test checks if the ID of a Quiz is correctly mapped to a QuizResponse. It sets the ID of
   * the quiz, maps the quiz to a QuizResponse, and then asserts that the ID of the QuizResponse is
   * the same as the ID of the Quiz.
   */
  @Test
  void givenQuiz_whenMapToResponse_thenIdIsSet() {
    quiz.setId(UUID.randomUUID());
    QuizResponse response = quizResponse.map(quiz);
    assertEquals(quiz.getId(), response.getId());
  }

  /**
   * This test checks if the title of a Quiz is correctly mapped to a QuizResponse. It sets the
   * title of the quiz, maps the quiz to a QuizResponse, and then asserts that the title of the
   * QuizResponse is the same as the title of the Quiz.
   */
  @Test
  void givenQuiz_whenMapToResponse_thenTitleIsSet() {
    quiz.setTitle("Test Quiz");
    QuizResponse response = quizResponse.map(quiz);
    assertEquals(quiz.getTitle(), response.getTitle());
  }

  /**
   * This test checks if the description of a Quiz is correctly mapped to a QuizResponse. It sets
   * the description of the quiz, maps the quiz to a QuizResponse, and then asserts that the
   * description of the QuizResponse is the same as the description of the Quiz.
   */
  @Test
  void givenQuiz_whenMapToResponse_thenDescriptionIsSet() {
    quiz.setDescription("Test Description");
    QuizResponse response = quizResponse.map(quiz);
    assertEquals(quiz.getDescription(), response.getDescription());
  }

  /**
   * This test checks if the IRI of a Quiz is correctly mapped to a QuizResponse. It sets the ID of
   * the quiz, maps the quiz to a QuizResponse, and then asserts that the IRI of the QuizResponse is
   * not null.
   */
  @Test
  void givenQuiz_whenMapToResponse_thenIriIsNotNull() {
    quiz.setId(UUID.randomUUID());
    QuizResponse response = quizResponse.map(quiz);
    assertNotNull(response.getIri());
  }

  /**
   * This test checks if the owner IRI of a Quiz is correctly mapped to a QuizResponse. It sets the
   * owner of the quiz, maps the quiz to a QuizResponse, and then asserts that the owner IRI of the
   * QuizResponse is not null.
   */
  @Test
  void givenQuiz_whenMapToResponse_thenOwnerIriIsNotNull() {
    User user = new User();
    user.setId(UUID.randomUUID());
    quiz.setOwner(user);
    QuizResponse response = quizResponse.map(quiz);
    assertNotNull(response.getOwnerIri());
  }
}
