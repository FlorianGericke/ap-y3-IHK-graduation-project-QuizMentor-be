import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entities.Quiz;
import io.githup.fgericke.quizmentor.entities.Role;
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
   * This method sets up the User instance before each test.
   */
  @BeforeEach
  void setUp() {
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
}
