import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entities.Question;
import io.githup.fgericke.quizmentor.entities.Quiz;
import io.githup.fgericke.quizmentor.entities.Role;
import io.githup.fgericke.quizmentor.entities.Solution;
import io.githup.fgericke.quizmentor.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the User entity.
 */
class UserTest {

  /**
   * The User instance that will be used in the tests.
   */
  private User user;

  /**
   * The Quiz instance that will be used in the tests.
   */
  private Quiz quiz;

  /**
   * The Question instance that will be used in the tests.
   */
  private Question question;

  private Solution solution;
  private Solution reviewedSolution;

  /**
   * This method sets up the User instance before each test.
   */
  @BeforeEach
  void setUp() {
    question = new Question();
    user = User.builder()
        .mail("test@mail.com")
        .password("password")
        .role(Role.TRAINEE)
        .build();

    user = User.builder()
        .mail("test@mail.com")
        .password("password")
        .role(Role.TRAINEE)
        .build();

    solution = new Solution();
    reviewedSolution = new Solution();
  }

  /**
   * This test checks if the mail of a new User is correct.
   */
  @Test
  void givenNewUser_whenCheckedMail_thenMailIsCorrect() {
    assertEquals("test@mail.com", user.getMail());
  }

  /**
   * This test checks if the password of a new User is correct.
   */
  @Test
  void givenNewUser_whenCheckedPassword_thenPasswordIsCorrect() {
    assertEquals("password", user.getPassword());
  }

  /**
   * This test checks if the role of a new User is correct.
   */
  @Test
  void givenNewUser_whenCheckedRole_thenRoleIsUser() {
    assertEquals(Role.TRAINEE, user.getRole());
  }

  /**
   * This test checks if the role of a User is updated correctly.
   */
  @Test
  void givenUser_whenRoleChanged_thenRoleIsUpdated() {
    user.setRole(Role.TRAINER);
    assertEquals(Role.TRAINER, user.getRole());
  }

  /**
   * This test checks if the username of a User is correct.
   */
  @Test
  void givenUser_whenUsernameChecked_thenUsernameIsMail() {
    assertEquals("test@mail.com", user.getUsername());
  }

  /**
   * This test checks if the account of a User is not expired.
   */
  @Test
  void givenUser_whenCheckedAccountNonExpired_thenReturnsTrue() {
    assertTrue(user.isAccountNonExpired());
  }

  /**
   * This test checks if the account of a User is not locked.
   */
  @Test
  void givenUser_whenCheckedAccountNonLocked_thenReturnsTrue() {
    assertTrue(user.isAccountNonLocked());
  }

  /**
   * This test checks if the credentials of a User are not expired.
   */
  @Test
  void givenUser_whenCheckedCredentialsNonExpired_thenReturnsTrue() {
    assertTrue(user.isCredentialsNonExpired());
  }

  /**
   * This test checks if the account of a User is enabled.
   */
  @Test
  void givenUser_whenCheckedEnabled_thenReturnsTrue() {
    assertTrue(user.isEnabled());
  }

  /**
   * This test checks if the quizzes set of a new User is empty.
   */
  @Test
  void givenNewUser_whenCheckedQuizzes_thenQuizzesIsEmpty() {
    assertTrue(user.getQuizzes().isEmpty());
  }

  /**
   * This test checks if a quiz can be added to a User's quizzes set. It adds a quiz to the set and
   * then checks if the set contains the added quiz.
   */
  @Test
  void givenUser_whenQuizAdded_thenQuizIsInQuizzes() {
    user.getQuizzes().add(quiz);
    assertTrue(user.getQuizzes().contains(quiz));
  }

  /**
   * This test checks if a quiz can be removed from a User's quizzes set. It first adds a quiz to
   * the set, removes the same quiz, and then checks if the set does not contain the removed quiz.
   */
  @Test
  void givenUserWithQuiz_whenQuizRemoved_thenQuizIsNotInQuizzes() {
    user.getQuizzes().add(quiz);
    user.getQuizzes().remove(quiz);
    assertFalse(user.getQuizzes().contains(quiz));
  }

  /**
   * This test checks if all quizzes can be removed from a User's quizzes set. It first adds a quiz
   * to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenUserWithQuiz_whenClearedQuizzes_thenQuizzesIsEmpty() {
    user.getQuizzes().add(quiz);
    user.getQuizzes().clear();
    assertTrue(user.getQuizzes().isEmpty());
  }

  /**
   * This test checks if the questions set of a new User is empty.
   */
  @Test
  void givenNewUser_whenCheckedQuestions_thenQuestionsIsEmpty() {
    assertTrue(user.getQuestions().isEmpty());
  }

  /**
   * This test checks if a question can be added to a User's questions set. It adds a question to
   * the set and then checks if the set contains the added question.
   */
  @Test
  void givenUser_whenQuestionAdded_thenQuestionIsInQuestions() {
    user.getQuestions().add(question);
    assertTrue(user.getQuestions().contains(question));
  }

  /**
   * This test checks if a question can be removed from a User's questions set. It first adds a
   * question to the set, removes the same question, and then checks if the set does not contain the
   * removed question.
   */
  @Test
  void givenUserWithQuestion_whenQuestionRemoved_thenQuestionIsNotInQuestions() {
    user.getQuestions().add(question);
    user.getQuestions().remove(question);
    assertFalse(user.getQuestions().contains(question));
  }

  /**
   * This test checks if all questions can be removed from a User's questions set. It first adds a
   * question to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenUserWithQuestion_whenClearedQuestions_thenQuestionsIsEmpty() {
    user.getQuestions().add(question);
    user.getQuestions().clear();
    assertTrue(user.getQuestions().isEmpty());
  }

  /**
   * This test checks if the solutions set of a new User is empty.
   */
  @Test
  void givenNewUser_whenCheckedSolutions_thenSolutionsIsEmpty() {
    assertTrue(user.getSolutions().isEmpty());
  }

  /**
   * This test checks if a solution can be added to a User's solutions set. It adds a solution to
   * the set and then checks if the set contains the added solution.
   */
  @Test
  void givenUser_whenSolutionAdded_thenSolutionIsInSolutions() {
    user.getSolutions().add(solution);
    assertTrue(user.getSolutions().contains(solution));
  }

  /**
   * This test checks if a solution can be removed from a User's solutions set. It first adds a
   * solution to the set, removes the same solution, and then checks if the set does not contain the
   * removed solution.
   */
  @Test
  void givenUserWithSolution_whenSolutionRemoved_thenSolutionIsNotInSolutions() {
    user.getSolutions().add(solution);
    user.getSolutions().remove(solution);
    assertFalse(user.getSolutions().contains(solution));
  }

  /**
   * This test checks if all solutions can be removed from a User's solutions set. It first adds a
   * solution to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenUserWithSolution_whenClearedSolutions_thenSolutionsIsEmpty() {
    user.getSolutions().add(solution);
    user.getSolutions().clear();
    assertTrue(user.getSolutions().isEmpty());
  }
}
