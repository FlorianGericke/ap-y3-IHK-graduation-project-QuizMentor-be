import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the Answer class.
 */
class AnswerTest {

  /**
   * The Answer instance that will be tested.
   */
  private Answer answer;

  /**
   * Mocked User instance representing the reviewer of the answer.
   */
  @Mock
  private User reviewedFrom;

  /**
   * Mocked User instance representing the user who answered.
   */
  @Mock
  private User answeredFrom;

  /**
   * This method sets up the testing environment before each test. It initializes a new Answer
   * instance with mocked dependencies.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    answer = Answer.builder()
        .answer("Test Answer")
        .isCorrect(true)
        .reviewedFrom(reviewedFrom)
        .answeredFrom(answeredFrom)
        .build();
  }

  /**
   * This test checks if the getAnswer method returns the correct answer.
   */
  @Test
  void givenAnswer_whenGetAnswer_thenReturnAnswer() {
    assertEquals("Test Answer", answer.getAnswer());
  }

  /**
   * This test checks if the getIsCorrect method returns the correct boolean value.
   */
  @Test
  void givenAnswer_whenGetIsCorrect_thenReturnIsCorrect() {
    assertTrue(answer.getIsCorrect());
  }

  /**
   * This test checks if the getReviewedFrom method returns the correct User instance.
   */
  @Test
  void givenAnswer_whenGetReviewedFrom_thenReturnReviewedFrom() {
    assertEquals(reviewedFrom, answer.getReviewedFrom());
  }

  /**
   * This test checks if the getAnsweredFrom method returns the correct User instance.
   */
  @Test
  void givenAnswer_whenGetAnsweredFrom_thenReturnAnsweredFrom() {
    assertEquals(answeredFrom, answer.getAnsweredFrom());
  }
}
