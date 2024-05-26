package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the User class. It tests the add, remove, and update
 * operations for questions, solutions, quizzes, and answers in a user. It also tests the update
 * operations for the mail, password, and role of a user.
 */
class UserTest {

  // Instance of User to be used in the tests
  private User user;
  // Instances of Question, Solution, Quiz, and Answer to be used in the tests
  private Question question;
  private Solution solution;
  private Quiz quiz;
  private Answer answer;

  /**
   * This method sets up the User, Question, Solution, Quiz, and Answer instances before each test.
   */
  @BeforeEach
  void setUp() {
    user = new User();
    question = new Question();
    solution = new Solution();
    quiz = new Quiz();
    answer = new Answer();
  }

  /**
   * This test checks the add and remove operations for a question in a user. It verifies that a
   * question can be added to and removed from a user correctly.
   */
  @DisplayName("Should add and remove question correctly")
  @Test
  void shouldAddAndRemoveQuestion() {
    assertTrue(user.getQuestions().isEmpty());
    user.getQuestions().add(question);
    assertTrue(user.getQuestions().contains(question));
    user.getQuestions().remove(question);
    assertFalse(user.getQuestions().contains(question));
  }

  /**
   * This test checks the add and remove operations for a solution in a user. It verifies that a
   * solution can be added to and removed from a user correctly.
   */
  @DisplayName("Should add and remove solution correctly")
  @Test
  void shouldAddAndRemoveSolution() {
    assertTrue(user.getSolutions().isEmpty());
    user.getSolutions().add(solution);
    assertTrue(user.getSolutions().contains(solution));
    user.getSolutions().remove(solution);
    assertFalse(user.getSolutions().contains(solution));
  }

  /**
   * This test checks the add and remove operations for a quiz in a user. It verifies that a quiz
   * can be added to and removed from a user correctly.
   */
  @DisplayName("Should add and remove quiz correctly")
  @Test
  void shouldAddAndRemoveQuiz() {
    assertTrue(user.getQuizzes().isEmpty());
    user.getQuizzes().add(quiz);
    assertTrue(user.getQuizzes().contains(quiz));
    user.getQuizzes().remove(quiz);
    assertFalse(user.getQuizzes().contains(quiz));
  }

  /**
   * This test checks the add and remove operations for an answer in a user. It verifies that an
   * answer can be added to and removed from a user correctly.
   */
  @DisplayName("Should add and remove answer correctly")
  @Test
  void shouldAddAndRemoveAnswer() {
    assertTrue(user.getAnswers().isEmpty());
    user.getAnswers().add(answer);
    assertTrue(user.getAnswers().contains(answer));
    user.getAnswers().remove(answer);
    assertFalse(user.getAnswers().contains(answer));
  }

  /**
   * This test checks the update operation for the mail of a user. It verifies that the mail of a
   * user can be updated correctly.
   */
  @DisplayName("Should update mail correctly")
  @Test
  void shouldUpdateMail() {
    String newMail = "new.mail@example.com";
    user.setMail(newMail);
    assertEquals(newMail, user.getMail());
  }

  /**
   * This test checks the update operation for the password of a user. It verifies that the password
   * of a user can be updated correctly.
   */
  @DisplayName("Should update password correctly")
  @Test
  void shouldUpdatePassword() {
    String newPassword = "newPassword";
    user.setPassword(newPassword);
    assertEquals(newPassword, user.getPassword());
  }

  /**
   * This test checks the update operation for the role of a user. It verifies that the role of a
   * user can be updated correctly.
   */
  @DisplayName("Should update role correctly")
  @Test
  void shouldUpdateRole() {
    Role newRole = Role.TRAINEE;
    user.setRole(newRole);
    assertEquals(newRole, user.getRole());
  }
}
