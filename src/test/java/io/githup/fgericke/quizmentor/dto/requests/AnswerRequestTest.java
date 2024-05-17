package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.entity.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * The AnswerRequestTest class contains unit tests for the AnswerRequest class. It tests the
 * conversion of an AnswerRequest to an Answer entity.
 */
class AnswerRequestTest {

  private static final String TEST_ANSWER = "Test Answer";
  private static final boolean TEST_CORRECTNESS = true;
  private static final String EXCEPTION_REASON = "[Answer] Title cannot be null";
  private static final HttpStatus EXCEPTION_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

  /**
   * The AnswerRequest object that will be used in the tests.
   */
  private AnswerRequest answerRequest;

  /**
   * This method is executed before each test. It initializes the AnswerRequest object.
   */
  @BeforeEach
  void setUp() {
    answerRequest = new AnswerRequest();
  }

  /**
   * This test checks the conversion of an AnswerRequest to an Answer entity when the answer is not
   * null. It sets the answer and correctness of the AnswerRequest, converts it to an Answer entity,
   * and asserts that the answer and correctness of the Answer entity are the same as those set in
   * the AnswerRequest.
   */
  @Test
  @DisplayName("Should convert to entity when answer is not null")
  void shouldConvertToEntityWhenAnswerIsNotNull() {
    answerRequest.setAnswer(TEST_ANSWER);
    answerRequest.setIsCorrect(TEST_CORRECTNESS);

    Answer answer = answerRequest.toEntity();

    assertEquals(TEST_ANSWER, answer.getAnswer());
    assertEquals(TEST_CORRECTNESS, answer.getIsCorrect());
  }

  /**
   * This test checks the conversion of an AnswerRequest to an Answer entity when the answer is
   * null. It sets the answer of the AnswerRequest to null, tries to convert it to an Answer entity,
   * and asserts that a ResponseStatusException is thrown with a 500 status code and a specific
   * error message.
   */
  @Test
  @DisplayName("Should throw exception when answer is null")
  void shouldThrowExceptionWhenAnswerIsNull() {
    answerRequest.setAnswer(null);
    answerRequest.setIsCorrect(TEST_CORRECTNESS);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        answerRequest::toEntity);

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }
}
