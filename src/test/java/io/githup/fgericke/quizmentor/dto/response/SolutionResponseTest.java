package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the SolutionResponse class. It tests the getter and setter
 * methods of the SolutionResponse class.
 */
class SolutionResponseTest {

  final int EXPECTED_SCORE = 10;

  // Instance of SolutionResponse to be used in the tests
  private SolutionResponse solutionResponse;

  /**
   * This method sets up the SolutionResponse instance before each test.
   */
  @BeforeEach
  void setUp() {
    solutionResponse = new SolutionResponse();
  }

  /**
   * This test checks the setter and getter for the id field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get id correctly")
  @Test
  void shouldSetAndGetId() {
    UUID expectedId = UUID.randomUUID();
    solutionResponse.setId(expectedId);
    UUID actualId = solutionResponse.getId();
    assertEquals(expectedId, actualId);
  }

  /**
   * This test checks the setter and getter for the iri field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get iri correctly")
  @Test
  void shouldSetAndGetIri() {
    String expectedIri = "testIri";
    solutionResponse.setIri(expectedIri);
    String actualIri = solutionResponse.getIri();
    assertEquals(expectedIri, actualIri);
  }

  /**
   * This test checks the setter and getter for the questionIri field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get questionIri correctly")
  @Test
  void shouldSetAndGetQuestionIri() {
    String expectedQuestionIri = "testQuestionIri";
    solutionResponse.setQuestionIri(expectedQuestionIri);
    String actualQuestionIri = solutionResponse.getQuestionIri();
    assertEquals(expectedQuestionIri, actualQuestionIri);
  }

  /**
   * This test checks the setter and getter for the ownerIri field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get ownerIri correctly")
  @Test
  void shouldSetAndGetOwnerIri() {
    String expectedOwnerIri = "testOwnerIri";
    solutionResponse.setOwnerIri(expectedOwnerIri);
    String actualOwnerIri = solutionResponse.getOwnerIri();
    assertEquals(expectedOwnerIri, actualOwnerIri);
  }

  /**
   * This test checks the setter and getter for the score field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get score correctly")
  @Test
  void shouldSetAndGetScore() {
    solutionResponse.setScore(EXPECTED_SCORE);
    int actualScore = solutionResponse.getScore();
    assertEquals(EXPECTED_SCORE, actualScore);
  }

  /**
   * This test checks the setter and getter for the solution field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get solution correctly")
  @Test
  void shouldSetAndGetSolution() {
    String expectedSolution = "testSolution";
    solutionResponse.setSolution(expectedSolution);
    String actualSolution = solutionResponse.getSolution();
    assertEquals(expectedSolution, actualSolution);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    solutionResponse.setId(null);
    solutionResponse.setIri(null);
    solutionResponse.setQuestionIri(null);
    solutionResponse.setOwnerIri(null);
    solutionResponse.setScore(null);
    solutionResponse.setSolution(null);

    assertNull(solutionResponse.getId());
    assertNull(solutionResponse.getIri());
    assertNull(solutionResponse.getQuestionIri());
    assertNull(solutionResponse.getOwnerIri());
    assertNull(solutionResponse.getScore());
    assertNull(solutionResponse.getSolution());
  }
}
