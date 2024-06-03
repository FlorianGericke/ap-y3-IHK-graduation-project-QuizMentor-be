package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the CategoryRequest class. It tests the getter and setter
 * methods of the CategoryRequest class.
 */
class CategoryRequestTest {

  // Instance of CategoryRequest to be used in the tests
  private CategoryRequest categoryRequest;

  /**
   * This method sets up the CategoryRequest instance before each test.
   */
  @BeforeEach
  void setUp() {
    categoryRequest = new CategoryRequest();
  }

  /**
   * This test checks the setter and getter for the name field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get name correctly")
  @Test
  void shouldSetAndGetName() {
    String expectedName = "Test Category";
    categoryRequest.setName(expectedName);
    String actualName = categoryRequest.getName();
    assertEquals(expectedName, actualName);
  }

  /**
   * This test checks the setter and getter for the questions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get questions correctly")
  @Test
  void shouldSetAndGetQuestions() {
    List<String> expectedQuestions = Arrays.asList("Question1", "Question2");
    categoryRequest.setQuestions(expectedQuestions);
    List<String> actualQuestions = categoryRequest.getQuestions();
    assertEquals(expectedQuestions, actualQuestions);
  }

  /**
   * This test checks the setter and getter for the quizzes field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get quizzes correctly")
  @Test
  void shouldSetAndGetQuizzes() {
    List<String> expectedQuizzes = Arrays.asList("Quiz1", "Quiz2");
    categoryRequest.setQuizzes(expectedQuizzes);
    List<String> actualQuizzes = categoryRequest.getQuizzes();
    assertEquals(expectedQuizzes, actualQuizzes);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    categoryRequest.setName(null);
    categoryRequest.setQuestions(null);
    categoryRequest.setQuizzes(null);

    assertNull(categoryRequest.getName());
    assertNull(categoryRequest.getQuestions());
    assertNull(categoryRequest.getQuizzes());
  }
}
