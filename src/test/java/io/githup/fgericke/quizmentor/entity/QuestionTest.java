package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Question class. It tests the add, remove, and update
 * operations for quizzes, categories, solutions, and answers in a question. It also tests the
 * isOpenQuestion method.
 */
class QuestionTest {

  final int TEST_SCORE = 10;
  final int NEW_SCORE = 20;

  // Instance of Question to be used in the tests
  private Question question;
  // Instances of Quiz, Category, Solution, and Answer to be used in the tests
  private Quiz quiz;
  private Category category;
  private Solution solution;
  private Answer answer;

  /**
   * This method sets up the Question, Quiz, Category, Solution, and Answer instances before each
   * test.
   */
  @BeforeEach
  void setUp() {
    quiz = new Quiz();
    category = new Category();
    solution = new Solution();
    answer = new Answer();
    question = Question.builder()
        .title("Test Question")
        .description("Test Description")
        .score(TEST_SCORE)
        .status(Visibility.DRAFT)
        .build();
  }

  /**
   * This test checks the add and remove operations for a quiz in a question. It verifies that a
   * quiz can be added to and removed from a question correctly.
   */
  @DisplayName("Should add and remove quiz correctly")
  @Test
  void shouldAddAndRemoveQuiz() {
    assertTrue(question.getQuizzes().isEmpty());
    question.getQuizzes().add(quiz);
    assertTrue(question.getQuizzes().contains(quiz));
    question.getQuizzes().remove(quiz);
    assertFalse(question.getQuizzes().contains(quiz));
  }

  /**
   * This test checks the add and remove operations for a category in a question. It verifies that a
   * category can be added to and removed from a question correctly.
   */
  @DisplayName("Should add and remove category correctly")
  @Test
  void shouldAddAndRemoveCategory() {
    assertTrue(question.getCategories().isEmpty());
    question.getCategories().add(category);
    assertTrue(question.getCategories().contains(category));
    question.getCategories().remove(category);
    assertFalse(question.getCategories().contains(category));
  }

  /**
   * This test checks the add and remove operations for a solution in a question. It verifies that a
   * solution can be added to and removed from a question correctly.
   */
  @DisplayName("Should add and remove solution correctly")
  @Test
  void shouldAddAndRemoveSolution() {
    assertTrue(question.getSolutions().isEmpty());
    question.getSolutions().add(solution);
    assertTrue(question.getSolutions().contains(solution));
    question.getSolutions().remove(solution);
    assertFalse(question.getSolutions().contains(solution));
  }

  /**
   * This test checks the add and remove operations for an answer in a question. It verifies that an
   * answer can be added to and removed from a question correctly.
   */
  @DisplayName("Should add and remove answer correctly")
  @Test
  void shouldAddAndRemoveAnswer() {
    assertTrue(question.getAnswers().isEmpty());
    question.getAnswers().add(answer);
    assertTrue(question.getAnswers().contains(answer));
    question.getAnswers().remove(answer);
    assertFalse(question.getAnswers().contains(answer));
  }

  /**
   * This test checks the update operation for the score of a question. It verifies that the score
   * of a question can be updated correctly.
   */
  @DisplayName("Should update score correctly")
  @Test
  void shouldUpdateScore() {
    question.setScore(NEW_SCORE);
    assertEquals(NEW_SCORE, question.getScore());
  }

  /**
   * This test checks the update operation for the status of a question. It verifies that the status
   * of a question can be updated correctly.
   */
  @DisplayName("Should update status correctly")
  @Test
  void shouldUpdateStatus() {
    Visibility newStatus = Visibility.PUBLISHED;
    question.setStatus(newStatus);
    assertEquals(newStatus, question.getStatus());
  }

  /**
   * This test checks the isOpenQuestion method of a question. It verifies that the method returns
   * true if the score is not null, and false otherwise.
   */
  @DisplayName("Should check if question is open correctly")
  @Test
  void shouldCheckIfQuestionIsOpen() {
    assertTrue(question.isOpenQuestion());
    question.setScore(null);
    assertFalse(question.isOpenQuestion());
  }
}
