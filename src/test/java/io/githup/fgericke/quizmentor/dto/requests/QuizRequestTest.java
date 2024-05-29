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
 * This class contains unit tests for the QuizRequest class. It tests the getter and setter methods
 * of the QuizRequest class.
 */
class QuizRequestTest {

  // Instance of QuizRequest to be used in the tests
  private QuizRequest quizRequest;

  /**
   * This method sets up the QuizRequest instance before each test.
   */
  @BeforeEach
  void setUp() {
    quizRequest = new QuizRequest();
  }

  /**
   * This test checks the setter and getter for the title field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get title correctly")
  @Test
  void shouldSetAndGetTitle() {
    String expectedTitle = "Test Title";
    quizRequest.setTitle(expectedTitle);
    String actualTitle = quizRequest.getTitle();
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
    quizRequest.setDescription(expectedDescription);
    String actualDescription = quizRequest.getDescription();
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
    quizRequest.setStatus(expectedStatus);
    Visibility actualStatus = quizRequest.getStatus();
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
    quizRequest.setCategories(expectedCategories);
    List<String> actualCategories = quizRequest.getCategories();
    assertEquals(expectedCategories, actualCategories);
  }

  /**
   * This test checks the setter and getter for the questions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get questions correctly")
  @Test
  void shouldSetAndGetQuestions() {
    List<String> expectedQuestions = Arrays.asList("Question1", "Question2");
    quizRequest.setQuestions(expectedQuestions);
    List<String> actualQuestions = quizRequest.getQuestions();
    assertEquals(expectedQuestions, actualQuestions);
  }

  /**
   * This test checks the setter and getter for the owner field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get owner correctly")
  @Test
  void shouldSetAndGetOwner() {
    String expectedOwner = "Test Owner";
    quizRequest.setCreatedFrom(expectedOwner);
    String actualOwner = quizRequest.getCreatedFrom();
    assertEquals(expectedOwner, actualOwner);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    quizRequest.setTitle(null);
    quizRequest.setDescription(null);
    quizRequest.setStatus(null);
    quizRequest.setCategories(null);
    quizRequest.setQuestions(null);
    quizRequest.setCreatedFrom(null);

    assertNull(quizRequest.getTitle());
    assertNull(quizRequest.getDescription());
    assertNull(quizRequest.getStatus());
    assertNull(quizRequest.getCategories());
    assertNull(quizRequest.getQuestions());
    assertNull(quizRequest.getCreatedFrom());
  }
}
