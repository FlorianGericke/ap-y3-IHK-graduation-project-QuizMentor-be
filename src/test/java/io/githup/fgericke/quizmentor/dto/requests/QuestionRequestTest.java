package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the QuestionRequest class. It tests the getter and setter
 * methods of the QuestionRequest class.
 */
class QuestionRequestTest {

  private static final int EXPECTED_SCORE = 10;
  // Instance of QuestionRequest to be used in the tests
  private QuestionRequest questionRequest;

  /**
   * This method sets up the QuestionRequest instance before each test.
   */
  @BeforeEach
  void setUp() {
    questionRequest = new QuestionRequest();
  }

  /**
   * This test checks the setter and getter for the title field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get title correctly")
  @Test
  void shouldSetAndGetTitle() {
    String expectedTitle = "Test Title";
    questionRequest.setTitle(expectedTitle);
    String actualTitle = questionRequest.getTitle();
    assertEquals(expectedTitle, actualTitle);
  }

  /**
   * This test checks the setter and getter for the description field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get description correctly")
  @Test
  void shouldSetAndGetDescription() {
    String expectedDescription = "Test Description";
    questionRequest.setDescription(expectedDescription);
    String actualDescription = questionRequest.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  /**
   * This test checks the setter and getter for the status field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get status correctly")
  @Test
  void shouldSetAndGetStatus() {
    Visibility expectedStatus = Visibility.PUBLISHED;
    questionRequest.setStatus(expectedStatus);
    Visibility actualStatus = questionRequest.getStatus();
    assertEquals(expectedStatus, actualStatus);
  }

  /**
   * This test checks the setter and getter for the categories field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get categories correctly")
  @Test
  void shouldSetAndGetCategories() {
    List<String> expectedCategories = Arrays.asList("Category1", "Category2");
    questionRequest.setCategories(expectedCategories);
    List<String> actualCategories = questionRequest.getCategories();
    assertEquals(expectedCategories, actualCategories);
  }

  /**
   * This test checks the setter and getter for the solutions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get solutions correctly")
  @Test
  void shouldSetAndGetSolutions() {
    List<String> expectedSolutions = Arrays.asList("Solution1", "Solution2");
    questionRequest.setSolutions(expectedSolutions);
    List<String> actualSolutions = questionRequest.getSolutions();
    assertEquals(expectedSolutions, actualSolutions);
  }

  /**
   * This test checks the setter and getter for the quizzes field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get quizzes correctly")
  @Test
  void shouldSetAndGetQuizzes() {
    List<String> expectedQuizzes = Arrays.asList("Quiz1", "Quiz2");
    questionRequest.setQuizzes(expectedQuizzes);
    List<String> actualQuizzes = questionRequest.getQuizzes();
    assertEquals(expectedQuizzes, actualQuizzes);
  }

  /**
   * This test checks the setter and getter for the score field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get score correctly")
  @Test
  void shouldSetAndGetScore() {
    questionRequest.setScore(EXPECTED_SCORE);
    int actualScore = questionRequest.getScore();
    assertEquals(EXPECTED_SCORE, actualScore);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    questionRequest.setTitle(null);
    questionRequest.setDescription(null);
    questionRequest.setStatus(null);
    questionRequest.setCategories(null);
    questionRequest.setSolutions(null);
    questionRequest.setQuizzes(null);
    questionRequest.setScore(0);

    assertNull(questionRequest.getTitle());
    assertNull(questionRequest.getDescription());
    assertNull(questionRequest.getStatus());
    assertNull(questionRequest.getCategories());
    assertNull(questionRequest.getSolutions());
    assertNull(questionRequest.getQuizzes());
    assertEquals(0, questionRequest.getScore());
  }

  /**
   * This test checks the setter and getter for the createdFrom field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get createdFrom correctly")
  @Test
  void shouldSetAndGetCreatedFrom() {
    String expectedCreatedFrom = "User1";
    questionRequest.setCreatedFrom(expectedCreatedFrom);
    String actualCreatedFrom = questionRequest.getCreatedFrom();
    assertEquals(expectedCreatedFrom, actualCreatedFrom);
  }

  /**
   * This test checks the handling of null values by the setter and getter for the createdFrom
   * field. It verifies that null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null value for createdFrom correctly")
  @Test
  void shouldHandleNullCreatedFrom() {
    questionRequest.setCreatedFrom(null);
    assertNull(questionRequest.getCreatedFrom());
  }
}
