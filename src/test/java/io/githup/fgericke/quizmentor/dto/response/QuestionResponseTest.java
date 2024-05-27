package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the QuestionResponse class. It tests the getter and setter
 * methods of the QuestionResponse class.
 */
class QuestionResponseTest {

  private static final int EXPECTED_SCORE = 10;

  // Instance of QuestionResponse to be used in the tests
  private QuestionResponse questionResponse;

  /**
   * This method sets up the QuestionResponse instance before each test.
   */
  @BeforeEach
  void setUp() {
    questionResponse = new QuestionResponse();
  }

  /**
   * This test checks the setter and getter for the id field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get id correctly")
  @Test
  void shouldSetAndGetId() {
    UUID expectedId = UUID.randomUUID();
    questionResponse.setId(expectedId);
    UUID actualId = questionResponse.getId();
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
    questionResponse.setIri(expectedIri);
    String actualIri = questionResponse.getIri();
    assertEquals(expectedIri, actualIri);
  }

  /**
   * This test checks the setter and getter for the title field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get title correctly")
  @Test
  void shouldSetAndGetTitle() {
    String expectedTitle = "testTitle";
    questionResponse.setTitle(expectedTitle);
    String actualTitle = questionResponse.getTitle();
    assertEquals(expectedTitle, actualTitle);
  }

  /**
   * This test checks the setter and getter for the description field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get description correctly")
  @Test
  void shouldSetAndGetDescription() {
    String expectedDescription = "testDescription";
    questionResponse.setDescription(expectedDescription);
    String actualDescription = questionResponse.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  /**
   * This test checks the setter and getter for the isOpen field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get isOpen correctly")
  @Test
  void shouldSetAndGetIsOpen() {
    questionResponse.setIsOpen(true);
    assertEquals(true, questionResponse.getIsOpen());
  }

  /**
   * This test checks the setter and getter for the score field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get score correctly")
  @Test
  void shouldSetAndGetScore() {
    questionResponse.setScore(EXPECTED_SCORE);
    Integer actualScore = questionResponse.getScore();
    assertEquals(EXPECTED_SCORE, actualScore);
  }

  /**
   * This test checks the setter and getter for the status field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get status correctly")
  @Test
  void shouldSetAndGetStatus() {
    Visibility expectedStatus = Visibility.PUBLISHED;
    questionResponse.setStatus(expectedStatus);
    Visibility actualStatus = questionResponse.getStatus();
    assertEquals(expectedStatus, actualStatus);
  }

  /**
   * This test checks the setter and getter for the solutions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get solutions correctly")
  @Test
  void shouldSetAndGetSolutions() {
    List<String> expectedSolutions = Arrays.asList("solution1", "solution2");
    questionResponse.setSolutions(expectedSolutions);
    List<String> actualSolutions = questionResponse.getSolutions();
    assertEquals(expectedSolutions, actualSolutions);
  }

  /**
   * This test checks the setter and getter for the answers field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get answers correctly")
  @Test
  void shouldSetAndGetAnswers() {
    List<String> expectedAnswers = Arrays.asList("answer1", "answer2");
    questionResponse.setAnswers(expectedAnswers);
    List<String> actualAnswers = questionResponse.getAnswers();
    assertEquals(expectedAnswers, actualAnswers);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    questionResponse.setId(null);
    questionResponse.setIri(null);
    questionResponse.setTitle(null);
    questionResponse.setDescription(null);
    questionResponse.setIsOpen(null);
    questionResponse.setScore(null);
    questionResponse.setStatus(null);
    questionResponse.setSolutions(null);
    questionResponse.setAnswers(null);

    assertNull(questionResponse.getId());
    assertNull(questionResponse.getIri());
    assertNull(questionResponse.getTitle());
    assertNull(questionResponse.getDescription());
    assertNull(questionResponse.getIsOpen());
    assertNull(questionResponse.getScore());
    assertNull(questionResponse.getStatus());
    assertNull(questionResponse.getSolutions());
    assertNull(questionResponse.getAnswers());
  }
}
