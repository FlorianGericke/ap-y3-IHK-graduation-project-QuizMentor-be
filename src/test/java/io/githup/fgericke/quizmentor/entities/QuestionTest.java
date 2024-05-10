import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entities.Category;
import io.githup.fgericke.quizmentor.entities.Question;
import io.githup.fgericke.quizmentor.entities.Quiz;
import io.githup.fgericke.quizmentor.entities.Visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Question entity.
 */
class QuestionTest {

  private Question question;
  private Quiz quiz;
  private Category category;
  private static final int INITIAL_SCORE = 10;
  private static final int UPDATED_SCORE = 20;

  /**
   * This method sets up the objects used in the tests. It is run before each test.
   */
  @BeforeEach
  void setUp() {
    quiz = new Quiz();
    category = new Category();
    question = Question.builder()
        .score(INITIAL_SCORE)
        .status(Visibility.DRAFT)
        .build();
  }

  /**
   * This test checks if the quizzes set of a new Question is empty.
   */
  @Test
  void givenNewQuestion_whenCheckedQuizzes_thenQuizzesIsEmpty() {
    assertTrue(question.getQuizzes().isEmpty());
  }

  /**
   * This test checks if a quiz can be added to a Question's quizzes set. It adds a quiz to the set
   * and then checks if the set contains the added quiz.
   */
  @Test
  void givenQuestion_whenQuizAdded_thenQuizIsInQuizzes() {
    question.getQuizzes().add(quiz);
    assertTrue(question.getQuizzes().contains(quiz));
  }

  /**
   * This test checks if a quiz can be removed from a Question's quizzes set. It first adds a quiz
   * to the set, removes the same quiz, and then checks if the set does not contain the removed
   * quiz.
   */
  @Test
  void givenQuestionWithQuiz_whenQuizRemoved_thenQuizIsNotInQuizzes() {
    question.getQuizzes().add(quiz);
    question.getQuizzes().remove(quiz);
    assertFalse(question.getQuizzes().contains(quiz));
  }

  /**
   * This test checks if all quizzes can be removed from a Question's quizzes set. It first adds a
   * quiz to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenQuestionWithQuiz_whenClearedQuizzes_thenQuizzesIsEmpty() {
    question.getQuizzes().add(quiz);
    question.getQuizzes().clear();
    assertTrue(question.getQuizzes().isEmpty());
  }

  /**
   * This test checks if the categories set of a new Question is empty.
   */
  @Test
  void givenNewQuestion_whenCheckedCategories_thenCategoriesIsEmpty() {
    assertTrue(question.getCategories().isEmpty());
  }

  /**
   * This test checks if a category can be added to a Question's categories set. It adds a category
   * to the set and then checks if the set contains the added category.
   */
  @Test
  void givenQuestion_whenCategoryAdded_thenCategoryIsInCategories() {
    question.getCategories().add(category);
    assertTrue(question.getCategories().contains(category));
  }

  /**
   * This test checks if a category can be removed from a Question's categories set. It first adds a
   * category to the set, removes the same category, and then checks if the set does not contain the
   * removed category.
   */
  @Test
  void givenQuestionWithCategory_whenCategoryRemoved_thenCategoryIsNotInCategories() {
    question.getCategories().add(category);
    question.getCategories().remove(category);
    assertFalse(question.getCategories().contains(category));
  }

  /**
   * This test checks if all categories can be removed from a Question's categories set. It first
   * adds a category to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenQuestionWithCategory_whenClearedCategories_thenCategoriesIsEmpty() {
    question.getCategories().add(category);
    question.getCategories().clear();
    assertTrue(question.getCategories().isEmpty());
  }

  /**
   * This test checks the score of a Question. It checks if the score of the question is as
   * expected.
   */
  @Test
  void givenQuestion_whenCheckedScore_thenScoreIsCorrect() {
    assertEquals(INITIAL_SCORE, question.getScore());
  }

  /**
   * This test checks if the score of a Question can be updated. It first changes the score of the
   * question, and then checks if the updated score is as expected.
   */
  @Test
  void givenQuestion_whenScoreChanged_thenScoreIsUpdated() {
    question.setScore(UPDATED_SCORE);
    assertEquals(UPDATED_SCORE, question.getScore());
  }

  /**
   * This test checks the visibility status of a Question. It checks if the visibility status of the
   * question is as expected.
   */
  @Test
  void givenQuestion_whenCheckedStatus_thenStatusIsDraft() {
    assertEquals(Visibility.DRAFT, question.getStatus());
  }

  /**
   * This test checks if the visibility status of a Question can be updated. It first changes the
   * visibility status of the question, and then checks if the updated visibility status is as
   * expected.
   */
  @Test
  void givenQuestion_whenStatusChangedToPublished_thenStatusIsUpdated() {
    question.setStatus(Visibility.PUBLISHED);
    assertEquals(Visibility.PUBLISHED, question.getStatus());
  }
}
