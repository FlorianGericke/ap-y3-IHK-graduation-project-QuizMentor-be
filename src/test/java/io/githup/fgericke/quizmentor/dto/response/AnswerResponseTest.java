package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the AnswerResponse class. It tests the getter and setter
 * methods of the AnswerResponse class.
 */
class AnswerResponseTest {

  // Instance of AnswerResponse to be used in the tests
  private AnswerResponse answerResponse;

  /**
   * This method sets up the AnswerResponse instance before each test.
   */
  @BeforeEach
  void setUp() {
    answerResponse = new AnswerResponse();
  }

  /**
   * This test checks the setter and getter for the id field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get id correctly")
  @Test
  void shouldSetAndGetId() {
    UUID expectedId = UUID.randomUUID();
    answerResponse.setId(expectedId);
    UUID actualId = answerResponse.getId();
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
    answerResponse.setIri(expectedIri);
    String actualIri = answerResponse.getIri();
    assertEquals(expectedIri, actualIri);
  }

  /**
   * This test checks the setter and getter for the answer field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get answer correctly")
  @Test
  void shouldSetAndGetAnswer() {
    String expectedAnswer = "testAnswer";
    answerResponse.setAnswer(expectedAnswer);
    String actualAnswer = answerResponse.getAnswer();
    assertEquals(expectedAnswer, actualAnswer);
  }

  /**
   * This test checks the setter and getter for the questionIri field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get questionIri correctly")
  @Test
  void shouldSetAndGetQuestionIri() {
    String expectedQuestionIri = "testQuestionIri";
    answerResponse.setQuestionIri(expectedQuestionIri);
    String actualQuestionIri = answerResponse.getQuestionIri();
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
    answerResponse.setOwnerIri(expectedOwnerIri);
    String actualOwnerIri = answerResponse.getOwnerIri();
    assertEquals(expectedOwnerIri, actualOwnerIri);
  }

  /**
   * This test checks the setter and getter for the reviewedFromIri field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get reviewedFromIri correctly")
  @Test
  void shouldSetAndGetReviewedFromIri() {
    String expectedReviewedFromIri = "testReviewedFromIri";
    answerResponse.setReviewedFromIri(expectedReviewedFromIri);
    String actualReviewedFromIri = answerResponse.getReviewedFromIri();
    assertEquals(expectedReviewedFromIri, actualReviewedFromIri);
  }

  /**
   * This test checks the setter and getter for the correct field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get correct correctly")
  @Test
  void shouldSetAndGetCorrect() {
    answerResponse.setCorrect(true);
    assertTrue(answerResponse.isCorrect());
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    answerResponse.setId(null);
    answerResponse.setIri(null);
    answerResponse.setAnswer(null);
    answerResponse.setQuestionIri(null);
    answerResponse.setOwnerIri(null);
    answerResponse.setReviewedFromIri(null);

    assertNull(answerResponse.getId());
    assertNull(answerResponse.getIri());
    assertNull(answerResponse.getAnswer());
    assertNull(answerResponse.getQuestionIri());
    assertNull(answerResponse.getOwnerIri());
    assertNull(answerResponse.getReviewedFromIri());
    assertFalse(answerResponse.isCorrect());
  }
}
