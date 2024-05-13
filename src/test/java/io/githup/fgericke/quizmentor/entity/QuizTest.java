import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.entity.Visibility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
   * The Category instance under test.
   */
  private Category category;

  /**
   * The Question instance under test.
   */
  private Question question;

  /**
   * This method sets up the test environment before each test. It creates a new instance of Quiz
   * with a title, description, and visibility status.
   */
  @BeforeEach
  void setUp() {
    category = new Category();
    question = new Question();
    user = User.builder()
        .mail("test@mail.com")
        .password("password")
        .role(io.githup.fgericke.quizmentor.entity.Role.TRAINEE)
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

  @Test
  void givenNewQuiz_whenCheckedCategories_thenCategoriesIsEmpty() {
    assertTrue(quiz.getCategories().isEmpty());
  }

  @Test
  void givenQuiz_whenCategoryAdded_thenCategoryIsInCategories() {
    quiz.getCategories().add(category);
    assertTrue(quiz.getCategories().contains(category));
  }

  @Test
  void givenQuizWithCategory_whenCategoryRemoved_thenCategoryIsNotInCategories() {
    quiz.getCategories().add(category);
    quiz.getCategories().remove(category);
    assertFalse(quiz.getCategories().contains(category));
  }

  @Test
  void givenQuizWithCategory_whenClearedCategories_thenCategoriesIsEmpty() {
    quiz.getCategories().add(category);
    quiz.getCategories().clear();
    assertTrue(quiz.getCategories().isEmpty());
  }

  /**
   * This test checks if a question can be added to a Quiz's questions set. It adds a question to
   * the set and then checks if the set contains the added question.
   */
  @Test
  void givenQuiz_whenQuestionAdded_thenQuestionIsInQuestions() {
    quiz.getQuestions().add(question);
    assertTrue(quiz.getQuestions().contains(question));
  }

  /**
   * This test checks if a question can be removed from a Quiz's questions set. It first adds a
   * question to the set, removes the same question, and then checks if the set does not contain the
   * removed question.
   */
  @Test
  void givenQuizWithQuestion_whenQuestionRemoved_thenQuestionIsNotInQuestions() {
    quiz.getQuestions().add(question);
    quiz.getQuestions().remove(question);
    assertFalse(quiz.getQuestions().contains(question));
  }

  /**
   * This test checks if all questions can be removed from a Quiz's questions set. It first adds a
   * question to the set, clears the set, and then checks if the set is empty.
   */
  @Test
  void givenQuizWithQuestion_whenClearedQuestions_thenQuestionsIsEmpty() {
    quiz.getQuestions().add(question);
    quiz.getQuestions().clear();
    assertTrue(quiz.getQuestions().isEmpty());
  }
}
