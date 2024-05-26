package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the SolutionRequest class. It tests the getter and setter
 * methods of the SolutionRequest class.
 */
class SolutionRequestTest {

  final int EXPECTED_SCORE = 10;

  // Instance of SolutionRequest to be used in the tests
  private SolutionRequest solutionRequest;

  /**
   * This method sets up the SolutionRequest instance before each test.
   */
  @BeforeEach
  void setUp() {
    solutionRequest = new SolutionRequest();
  }

  /**
   * This test checks the setter and getter for the solution field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get solution correctly")
  @Test
  void shouldSetAndGetSolution() {
    String expectedSolution = "Test Solution";
    solutionRequest.setSolution(expectedSolution);
    String actualSolution = solutionRequest.getSolution();
    assertEquals(expectedSolution, actualSolution);
  }

  /**
   * This test checks the setter and getter for the score field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get score correctly")
  @Test
  void shouldSetAndGetScore() {
    solutionRequest.setScore(EXPECTED_SCORE);
    int actualScore = solutionRequest.getScore();
    assertEquals(EXPECTED_SCORE, actualScore);
  }

  /**
   * This test checks the setter and getter for the createdFrom field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get createdFrom correctly")
  @Test
  void shouldSetAndGetCreatedFrom() {
    String expectedCreatedFrom = "Test Creator";
    solutionRequest.setCreatedFrom(expectedCreatedFrom);
    String actualCreatedFrom = solutionRequest.getCreatedFrom();
    assertEquals(expectedCreatedFrom, actualCreatedFrom);
  }

  /**
   * This test checks the setter and getter for the question field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get question correctly")
  @Test
  void shouldSetAndGetQuestion() {
    String expectedQuestion = "Test Question";
    solutionRequest.setQuestion(expectedQuestion);
    String actualQuestion = solutionRequest.getQuestion();
    assertEquals(expectedQuestion, actualQuestion);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    solutionRequest.setSolution(null);
    solutionRequest.setScore(0);
    solutionRequest.setCreatedFrom(null);
    solutionRequest.setQuestion(null);

    assertNull(solutionRequest.getSolution());
    assertEquals(0, solutionRequest.getScore());
    assertNull(solutionRequest.getCreatedFrom());
    assertNull(solutionRequest.getQuestion());
  }
}
