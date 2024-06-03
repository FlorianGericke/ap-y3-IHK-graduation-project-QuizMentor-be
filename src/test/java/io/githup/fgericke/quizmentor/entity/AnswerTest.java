package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
  private User owner;

  /**
   * Mocked Question instance representing the question to which the answer belongs.
   */
  @Mock
  private Question question;

  /**
   * This method sets up the testing environment before each test. It initializes a new Answer
   * instance with mocked dependencies.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    this.question = Question.builder().build();
    this.answer = Answer.builder()
        .answer("Test Answer")
        .isCorrect(true)
        .reviewedFrom(this.reviewedFrom)
        .owner(this.owner)
        .question(this.question)
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
    assertEquals(owner, answer.getOwner());
  }

  /**
   * This test checks if the answers set of a new Question is empty. It asserts that the answers set
   * of a newly created question is empty.
   */
  @DisplayName("Answers set of a new Question is empty")
  @Test
  void givenNewQuestion_whenCheckedAnswers_thenAnswersIsEmpty() {
    assertTrue(question.getAnswers().isEmpty());
  }

  /**
   * This test checks if an answer can be added to a Question's answers set. It adds an answer to
   * the set and then asserts that the set contains the added answer.
   */
  @DisplayName("Answer can be added to a Question's answers set")
  @Test
  void givenQuestion_whenAnswerAdded_thenAnswerIsInAnswers() {
    Question questionForTest = Question.builder().build();
    questionForTest.getAnswers().add(answer);
    assertTrue(questionForTest.getAnswers().contains(answer));
  }

  /**
   * This test checks if an answer can be removed from a Question's answers set. It first adds an
   * answer to the set, removes the same answer, and then asserts that the set does not contain the
   * removed answer.
   */
  @DisplayName("Answer can be removed from a Question's answers set")
  @Test
  void givenQuestionWithAnswer_whenAnswerRemoved_thenAnswerIsNotInAnswers() {
    question.getAnswers().add(answer);
    question.getAnswers().remove(answer);
    assertFalse(question.getAnswers().contains(answer));
  }

  /**
   * This test checks if all answers can be removed from a Question's answers set. It first adds an
   * answer to the set, clears the set, and then asserts that the set is empty.
   */
  @DisplayName("All answers can be removed from a Question's answers set")
  @Test
  void givenQuestionWithAnswer_whenClearedAnswers_thenAnswersIsEmpty() {
    question.getAnswers().add(answer);
    question.getAnswers().clear();
    assertTrue(question.getAnswers().isEmpty());
  }
}
