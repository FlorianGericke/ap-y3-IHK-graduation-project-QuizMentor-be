import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entities.Category;
import io.githup.fgericke.quizmentor.entities.Question;
import io.githup.fgericke.quizmentor.entities.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Category entity.
 */
class CategoryTest {

  private Category category;
  private Quiz quiz;
  private Question question;

  /**
   * This method sets up the objects used in the tests. It is run before each test.
   */
  @BeforeEach
  void setUp() {
    quiz = new Quiz();
    question = new Question();
    category = Category.builder()
        .name("Test Category")
        .build();
  }

  /**
   * This test checks if the quizzes set of a new Category is empty.
   */
  @Test
  void givenNewCategory_whenCheckedQuizzes_thenQuizzesIsEmpty() {
    assertTrue(category.getQuizze().isEmpty());
  }

  /**
   * This test checks if a quiz can be added to a Category's quizzes set. It adds a quiz to the set
   * and then checks if the set contains the added quiz.
   */
  @Test
  void givenCategory_whenQuizAdded_thenQuizIsInQuizzes() {
    category.getQuizze().add(quiz);
    assertTrue(category.getQuizze().contains(quiz));
  }

  /**
   * This test checks if a quiz can be removed from a Category's quizzes set. It first adds a quiz
   * to the set, removes the same quiz, and then checks if the set does not contain the removed
   * quiz.
   */
  @Test
  void givenCategoryWithQuiz_whenQuizRemoved_thenQuizIsNotInQuizzes() {
    category.getQuizze().add(quiz);
    category.getQuizze().remove(quiz);
    assertFalse(category.getQuizze().contains(quiz));
  }

  /**
   * This test checks if all quizzes can be removed from a Category's quizzes set. It first adds a
   * quiz to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenCategoryWithQuiz_whenClearedQuizzes_thenQuizzesIsEmpty() {
    category.getQuizze().add(quiz);
    category.getQuizze().clear();
    assertTrue(category.getQuizze().isEmpty());
  }

  /**
   * This test checks if the questions set of a new Category is empty.
   */
  @Test
  void givenNewCategory_whenCheckedQuestions_thenQuestionsIsEmpty() {
    assertTrue(category.getQuestions().isEmpty());
  }

  /**
   * This test checks if a question can be added to a Category's questions set. It adds a question
   * to the set and then checks if the set contains the added question.
   */
  @Test
  void givenCategory_whenQuestionAdded_thenQuestionIsInQuestions() {
    category.getQuestions().add(question);
    assertTrue(category.getQuestions().contains(question));
  }

  /**
   * This test checks if a question can be removed from a Category's questions set. It first adds a
   * question to the set, removes the same question, and then checks if the set does not contain the
   * removed question.
   */
  @Test
  void givenCategoryWithQuestion_whenQuestionRemoved_thenQuestionIsNotInQuestions() {
    category.getQuestions().add(question);
    category.getQuestions().remove(question);
    assertFalse(category.getQuestions().contains(question));
  }

  /**
   * This test checks if all questions can be removed from a Category's questions set. It first adds
   * a question to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenCategoryWithQuestion_whenClearedQuestions_thenQuestionsIsEmpty() {
    category.getQuestions().add(question);
    category.getQuestions().clear();
    assertTrue(category.getQuestions().isEmpty());
  }
}
