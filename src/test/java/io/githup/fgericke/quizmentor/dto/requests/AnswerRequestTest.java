package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the AnswerRequest class.
 * It tests the getter and setter methods of the AnswerRequest class.
 */
class AnswerRequestTest {

  // Instance of AnswerRequest to be used in the tests
  private AnswerRequest answerRequest;

  /**
   * This method sets up the AnswerRequest instance before each test.
   */
  @BeforeEach
  void setUp() {
    answerRequest = new AnswerRequest();
  }

  /**
   * This test checks the setter and getter for the answer field.
   * It verifies that the set value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get answer correctly")
  @Test
  void shouldSetAndGetAnswer() {
    String expectedAnswer = "Test Answer";
    answerRequest.setAnswer(expectedAnswer);
    String actualAnswer = answerRequest.getAnswer();
    assertEquals(expectedAnswer, actualAnswer);
  }

  /**
   * This test checks the setter and getter for the isCorrect field.
   * It verifies that the set value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get correctness correctly")
  @Test
  void shouldSetAndGetCorrectness() {
    Boolean expectedCorrectness = true;
    answerRequest.setIsCorrect(expectedCorrectness);
    Boolean actualCorrectness = answerRequest.getIsCorrect();
    assertEquals(expectedCorrectness, actualCorrectness);
  }

  /**
   * This test checks the setter and getter for the reviewedFrom field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get reviewedFrom correctly")
  @Test
  void shouldSetAndGetReviewedFrom() {
    String expectedReviewedFrom = "Reviewer";
    answerRequest.setReviewedFrom(expectedReviewedFrom);
    String actualReviewedFrom = answerRequest.getReviewedFrom();
    assertEquals(expectedReviewedFrom, actualReviewedFrom);
  }

  /**
   * This test checks the setter and getter for the question field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get question correctly")
  @Test
  void shouldSetAndGetQuestion() {
    String expectedQuestion = "Question";
    answerRequest.setQuestion(expectedQuestion);
    String actualQuestion = answerRequest.getQuestion();
    assertEquals(expectedQuestion, actualQuestion);
  }

  /**
   * This test checks the setter and getter for the owner field.
   * It verifies that the set value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get owner correctly")
  @Test
  void shouldSetAndGetOwner() {
    String expectedOwner = "Owner";
    answerRequest.setOwner(expectedOwner);
    String actualOwner = answerRequest.getOwner();
    assertEquals(expectedOwner, actualOwner);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    answerRequest.setAnswer(null);
    answerRequest.setIsCorrect(null);
    answerRequest.setReviewedFrom(null);
    answerRequest.setQuestion(null);
    answerRequest.setOwner(null);

    assertNull(answerRequest.getAnswer());
    assertNull(answerRequest.getIsCorrect());
    assertNull(answerRequest.getReviewedFrom());
    assertNull(answerRequest.getQuestion());
    assertNull(answerRequest.getOwner());
  }
}
