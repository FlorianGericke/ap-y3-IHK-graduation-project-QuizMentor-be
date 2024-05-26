package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Quiz class. It tests the add, remove, and update
 * operations for categories and questions in a quiz. It also tests the update operations for the
 * title, description, visibility, and owner of a quiz.
 */
class QuizTest {

  // Instance of Quiz to be used in the tests
  private Quiz quiz;
  // Instances of Category, Question, and User to be used in the tests
  private Category category;
  private Question question;
  private User user;

  /**
   * This method sets up the Quiz, Category, Question, and User instances before each test.
   */
  @BeforeEach
  void setUp() {
    category = new Category();
    question = new Question();
    user = new User();
    quiz = Quiz.builder()
        .title("Test Quiz")
        .description("Test Description")
        .visibility(Visibility.DRAFT)
        .build();
  }

  /**
   * This test checks the add and remove operations for a category in a quiz. It verifies that a
   * category can be added to and removed from a quiz correctly.
   */
  @DisplayName("Should add and remove category correctly")
  @Test
  void shouldAddAndRemoveCategory() {
    assertTrue(quiz.getCategories().isEmpty());
    quiz.getCategories().add(category);
    assertTrue(quiz.getCategories().contains(category));
    quiz.getCategories().remove(category);
    assertFalse(quiz.getCategories().contains(category));
  }

  /**
   * This test checks the add and remove operations for a question in a quiz. It verifies that a
   * question can be added to and removed from a quiz correctly.
   */
  @DisplayName("Should add and remove question correctly")
  @Test
  void shouldAddAndRemoveQuestion() {
    assertTrue(quiz.getQuestions().isEmpty());
    quiz.getQuestions().add(question);
    assertTrue(quiz.getQuestions().contains(question));
    quiz.getQuestions().remove(question);
    assertFalse(quiz.getQuestions().contains(question));
  }

  /**
   * This test checks the update operation for the title of a quiz. It verifies that the title of a
   * quiz can be updated correctly.
   */
  @DisplayName("Should update title correctly")
  @Test
  void shouldUpdateTitle() {
    String newTitle = "New Title";
    quiz.setTitle(newTitle);
    assertEquals(newTitle, quiz.getTitle());
  }

  /**
   * This test checks the update operation for the description of a quiz. It verifies that the
   * description of a quiz can be updated correctly.
   */
  @DisplayName("Should update description correctly")
  @Test
  void shouldUpdateDescription() {
    String newDescription = "New Description";
    quiz.setDescription(newDescription);
    assertEquals(newDescription, quiz.getDescription());
  }

  /**
   * This test checks the update operation for the visibility of a quiz. It verifies that the
   * visibility of a quiz can be updated correctly.
   */
  @DisplayName("Should update visibility correctly")
  @Test
  void shouldUpdateVisibility() {
    Visibility newVisibility = Visibility.PUBLISHED;
    quiz.setVisibility(newVisibility);
    assertEquals(newVisibility, quiz.getVisibility());
  }

  /**
   * This test checks the update operation for the owner of a quiz. It verifies that the owner of a
   * quiz can be updated correctly.
   */
  @DisplayName("Should update owner correctly")
  @Test
  void shouldUpdateOwner() {
    quiz.setOwner(user);
    assertEquals(user, quiz.getOwner());
  }
}
