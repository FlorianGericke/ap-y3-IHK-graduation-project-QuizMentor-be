package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Category class. It tests the add, remove, and clear
 * operations for quizzes and questions in a category.
 */
class CategoryTest {

  // Instance of Category to be used in the tests
  private Category category;
  // Instance of Quiz to be used in the tests
  private Quiz quiz;
  // Instance of Question to be used in the tests
  private Question question;

  /**
   * This method sets up the Category, Quiz, and Question instances before each test.
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
   * This test checks the add and remove operations for a quiz in a category. It verifies that a
   * quiz can be added to and removed from a category correctly.
   */
  @DisplayName("Should add and remove quiz correctly")
  @Test
  void shouldAddAndRemoveQuiz() {
    assertTrue(category.getQuizze().isEmpty());
    category.getQuizze().add(quiz);
    assertTrue(category.getQuizze().contains(quiz));
    category.getQuizze().remove(quiz);
    assertFalse(category.getQuizze().contains(quiz));
  }

  /**
   * This test checks the add and remove operations for a question in a category. It verifies that a
   * question can be added to and removed from a category correctly.
   */
  @DisplayName("Should add and remove question correctly")
  @Test
  void shouldAddAndRemoveQuestion() {
    assertTrue(category.getQuestions().isEmpty());
    category.getQuestions().add(question);
    assertTrue(category.getQuestions().contains(question));
    category.getQuestions().remove(question);
    assertFalse(category.getQuestions().contains(question));
  }

  /**
   * This test checks the clear operation for quizzes in a category. It verifies that all quizzes
   * can be removed from a category correctly.
   */
  @DisplayName("Should clear quizzes correctly")
  @Test
  void shouldClearQuizzes() {
    category.getQuizze().add(quiz);
    category.getQuizze().clear();
    assertTrue(category.getQuizze().isEmpty());
  }

  /**
   * This test checks the clear operation for questions in a category. It verifies that all
   * questions can be removed from a category correctly.
   */
  @DisplayName("Should clear questions correctly")
  @Test
  void shouldClearQuestions() {
    category.getQuestions().add(question);
    category.getQuestions().clear();
    assertTrue(category.getQuestions().isEmpty());
  }
}
