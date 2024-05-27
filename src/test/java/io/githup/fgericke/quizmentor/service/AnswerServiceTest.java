package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.AnswerMapper;
import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.repository.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the AnswerService class.
 */
class AnswerServiceTest {

  @Mock
  private AnswerRepository answerRepository; // Mock of AnswerRepository

  @Mock
  private AnswerMapper answerMapper; // Mock of AnswerMapper

  @InjectMocks
  private AnswerService answerService; // The service under test

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize the mocks
  }

  /**
   * This test verifies that the patch method of the AnswerService correctly updates the answer when
   * a new answer is provided in the request.
   */
  @Test
  void patchShouldUpdateAnswerWhenNewAnswerIsProvided() {
    Answer existingAnswer = new Answer();
    existingAnswer.setAnswer("Old Answer");

    AnswerRequest answerRequest = new AnswerRequest();
    answerRequest.setAnswer("New Answer");

    Answer updatedAnswer = answerService.patch(existingAnswer, answerRequest);

    assertEquals("New Answer",
        updatedAnswer.getAnswer()); // Assert that the answer has been updated
  }

  /**
   * This test verifies that the patch method of the AnswerService keeps the existing answer when no
   * new answer is provided in the request.
   */
  @Test
  void patchShouldKeepExistingAnswerWhenNoNewAnswerIsProvided() {
    Answer existingAnswer = new Answer();
    existingAnswer.setAnswer("Existing Answer");

    AnswerRequest answerRequest = new AnswerRequest();

    Answer updatedAnswer = answerService.patch(existingAnswer, answerRequest);

    assertEquals("Existing Answer",
        updatedAnswer.getAnswer()); // Assert that the answer has not been updated
  }
}
