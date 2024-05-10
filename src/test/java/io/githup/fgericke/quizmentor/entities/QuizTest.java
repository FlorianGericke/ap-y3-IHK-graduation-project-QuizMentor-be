import io.githup.fgericke.quizmentor.entities.Quiz;
import io.githup.fgericke.quizmentor.entities.User;
import io.githup.fgericke.quizmentor.entities.Visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Quiz class. It tests the properties and behavior of a Quiz
 * instance.
 */
class QuizTest {

  /**
   * The Quiz instance under test.
   */
  private Quiz quiz;

  /**
   * The User instance under test.
   */
  private User user;

  /**
   * This method sets up the test environment before each test. It creates a new instance of Quiz
   * with a title, description, and visibility status.
   */
  @BeforeEach
  void setUp() {
    quiz = Quiz.builder()
        .title("Test Quiz")
        .description("This is a test quiz")
        .visibility(Visibility.DRAFT)
        .build();

    quiz = Quiz.builder()
        .title("Test Quiz")
        .description("This is a test quiz")
        .visibility(Visibility.DRAFT)
        .user(user)
        .build();
  }

  /**
   * This test checks if the title of a new Quiz is set correctly.
   */
  @Test
  void givenNewQuiz_whenCheckedTitle_thenTitleIsCorrect() {
    assertEquals("Test Quiz", quiz.getTitle());
  }

  /**
   * This test checks if the description of a new Quiz is set correctly.
   */
  @Test
  void givenNewQuiz_whenCheckedDescription_thenDescriptionIsCorrect() {
    assertEquals("This is a test quiz", quiz.getDescription());
  }

  /**
   * This test checks if the visibility status of a new Quiz is set to DRAFT.
   */
  @Test
  void givenNewQuiz_whenCheckedVisibility_thenVisibilityIsDraft() {
    assertEquals(Visibility.DRAFT, quiz.getVisibility());
  }

  /**
   * This test checks if the visibility status of a Quiz can be updated.
   */
  @Test
  void givenQuiz_whenVisibilityChanged_thenVisibilityIsUpdated() {
    quiz.setVisibility(Visibility.PUBLISHED);
    assertEquals(Visibility.PUBLISHED, quiz.getVisibility());
  }

  /**
   * This test checks if the User of a new Quiz is set correctly.
   */
  @Test
  void givenNewQuiz_whenCheckedUser_thenUserIsCorrect() {
    assertEquals(user, quiz.getUser());
  }

  /**
   * This test checks if the User of a Quiz can be updated. It creates a new mock User, sets it as
   * the User of the Quiz, and then checks if the User of the Quiz is the new User.
   */
  @Test
  void givenQuiz_whenUserChanged_thenUserIsUpdated() {
    User newUser = Mockito.mock(User.class);
    quiz.setUser(newUser);
    assertEquals(newUser, quiz.getUser());
  }
}
