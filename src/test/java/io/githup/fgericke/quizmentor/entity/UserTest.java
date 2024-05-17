import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the User entity.
 */
class UserTest {

  private User user;
  private Quiz quiz;

  /**
   * This method sets up the test environment before each test. It initializes a new User and Quiz
   * object.
   */
  @BeforeEach
  void setUp() {
    user = new User();
    quiz = new Quiz();
  }

  /**
   * This test checks if the quizzes set of a new User is empty. It asserts that the quizzes set of
   * the user is empty after the user is initialized.
   */
  @Test
  void givenNewUser_whenCheckedQuizzes_thenQuizzesIsEmpty() {
    assertTrue(user.getQuizzes().isEmpty());
  }

  /**
   * This test checks if adding a quiz to a User's quizzes set updates the set. It adds a quiz to
   * the user's quizzes set and then asserts that the set contains the quiz.
   */
  @Test
  void givenUser_whenQuizAdded_thenQuizIsInQuizzes() {
    user.getQuizzes().add(quiz);
    assertTrue(user.getQuizzes().contains(quiz));
  }

  /**
   * This test checks if removing a quiz from a User's quizzes set updates the set. It adds a quiz
   * to the user's quizzes set, removes the quiz, and then asserts that the set does not contain the
   * quiz.
   */
  @Test
  void givenUserWithQuiz_whenQuizRemoved_thenQuizIsNotInQuizzes() {
    user.getQuizzes().add(quiz);
    user.getQuizzes().remove(quiz);
    assertFalse(user.getQuizzes().contains(quiz));
  }

  /**
   * This test checks if clearing a User's quizzes set updates the set. It adds a quiz to the user's
   * quizzes set, clears the set, and then asserts that the set is empty.
   */
  @Test
  void givenUserWithQuiz_whenClearedQuizzes_thenQuizzesIsEmpty() {
    user.getQuizzes().add(quiz);
    user.getQuizzes().clear();
    assertTrue(user.getQuizzes().isEmpty());
  }
}
