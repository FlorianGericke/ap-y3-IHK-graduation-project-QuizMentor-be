package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Quiz entity.
 */
class QuizTest {

  private Quiz quiz;

  /**
   * This method sets up the test environment before each test. It initializes a new Quiz object.
   */
  @BeforeEach
  void setUp() {
    quiz = new Quiz();
  }

  /**
   * This test checks if setting the title of a Quiz updates the title. It sets the title of the
   * quiz and then asserts that the title of the quiz is the same as the set title.
   */
  @Test
  void givenNewQuiz_whenSetTitle_thenTitleIsSet() {
    quiz.setTitle("New Quiz");
    assertEquals("New Quiz", quiz.getTitle());
  }

  /**
   * This test checks if setting the title of a Quiz to null throws a NullPointerException. It is
   * currently disabled.
   */
  @Test
  @Disabled
  void givenNewQuiz_whenSetTitleWithNull_thenThrowsException() {
    assertThrows(NullPointerException.class, () -> quiz.setTitle(null));
  }

  /**
   * This test checks if setting the description of a Quiz updates the description. It sets the
   * description of the quiz and then asserts that the description of the quiz is the same as the
   * set description.
   */
  @Test
  void givenNewQuiz_whenSetDescription_thenDescriptionIsSet() {
    quiz.setDescription("This is a new quiz");
    assertEquals("This is a new quiz", quiz.getDescription());
  }

  /**
   * This test checks if setting the visibility of a Quiz updates the visibility. It sets the
   * visibility of the quiz and then asserts that the visibility of the quiz is the same as the set
   * visibility.
   */
  @Test
  void givenNewQuiz_whenSetVisibility_thenVisibilityIsSet() {
    quiz.setVisibility(Visibility.PUBLISHED);
    assertEquals(Visibility.PUBLISHED, quiz.getVisibility());
  }

  /**
   * This test checks if setting the visibility of a Quiz to null throws a NullPointerException. It
   * is currently disabled.
   */
  @Test
  @Disabled
  void givenNewQuiz_whenSetVisibilityWithNull_thenThrowsException() {
    assertThrows(NullPointerException.class, () -> quiz.setVisibility(null));
  }

  /**
   * This test checks if adding a category to a Quiz's categories set updates the set. It adds a
   * category to the quiz's categories set and then asserts that the set contains the category.
   */
  @Test
  void givenNewQuiz_whenAddCategory_thenCategoryIsAdded() {
    Category category = new Category();
    quiz.getCategories().add(category);
    assertTrue(quiz.getCategories().contains(category));
  }

  /**
   * This test checks if adding a null category to a Quiz's categories set throws a
   * NullPointerException. It is currently disabled.
   */
  @Test
  @Disabled
  void givenNewQuiz_whenAddNullCategory_thenThrowsException() {
    assertThrows(NullPointerException.class, () -> quiz.getCategories().add(null));
  }

  /**
   * This test checks if removing a category from a Quiz's categories set updates the set. It adds a
   * category to the quiz's categories set, removes the category, and then asserts that the set does
   * not contain the category.
   */
  @Test
  void givenQuizWithCategory_whenRemoveCategory_thenCategoryIsRemoved() {
    Category category = new Category();
    quiz.getCategories().add(category);
    quiz.getCategories().remove(category);
    assertFalse(quiz.getCategories().contains(category));
  }

  /**
   * This test checks if removing a null category from a Quiz's categories set throws a
   * NullPointerException. It is currently disabled.
   */
  @Test
  @Disabled
  void givenQuizWithCategory_whenRemoveNullCategory_thenThrowsException() {
    Category category = new Category();
    quiz.getCategories().add(category);
    assertThrows(NullPointerException.class, () -> quiz.getCategories().remove(null));
  }

  /**
   * This test checks if adding a question to a Quiz's questions set updates the set. It adds a
   * question to the quiz's questions set and then asserts that the set contains the question.
   */
  @Test
  void givenNewQuiz_whenAddQuestion_thenQuestionIsAdded() {
    Question question = new Question();
    quiz.getQuestions().add(question);
    assertTrue(quiz.getQuestions().contains(question));
  }

  /**
   * This test checks if adding a null question to a Quiz's questions set throws a
   * NullPointerException. It is currently disabled.
   */
  @Test
  @Disabled
  void givenNewQuiz_whenAddNullQuestion_thenThrowsException() {
    assertThrows(NullPointerException.class, () -> quiz.getQuestions().add(null));
  }

  /**
   * This test checks if removing a question from a Quiz's questions set updates the set. It adds a
   * question to the quiz's questions set, removes the question, and then asserts that the set does
   * not contain the question.
   */
  @Test
  void givenQuizWithQuestion_whenRemoveQuestion_thenQuestionIsRemoved() {
    Question question = new Question();
    quiz.getQuestions().add(question);
    quiz.getQuestions().remove(question);
    assertFalse(quiz.getQuestions().contains(question));
  }

  /**
   * This test checks if removing a null question from a Quiz's questions set throws a
   * NullPointerException. It is currently disabled.
   */
  @Test
  @Disabled
  void givenQuizWithQuestion_whenRemoveNullQuestion_thenThrowsException() {
    Question question = new Question();
    quiz.getQuestions().add(question);
    assertThrows(NullPointerException.class, () -> quiz.getQuestions().remove(null));
  }

  /**
   * This test checks if setting the owner of a Quiz updates the owner. It sets the owner of the
   * quiz to a User object and then asserts that the owner of the quiz is the same User object.
   */
  @Test
  void givenNewQuiz_whenSetOwner_thenOwnerIsSet() {
    User user = new User();
    quiz.setOwner(user);
    assertEquals(user, quiz.getOwner());
  }

  /**
   * This test checks if setting the owner of a Quiz to null throws a NullPointerException. It is
   * currently disabled.
   */
  @Test
  @Disabled
  void givenNewQuiz_whenSetOwnerWithNull_thenThrowsException() {
    assertThrows(NullPointerException.class, () -> quiz.setOwner(null));
  }
}
