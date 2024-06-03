package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.AnswerMapper;
import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.repository.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the AnswerService class. It tests the functionality of
 * updating an existing Answer entity with new data provided in an AnswerRequest.
 */
class AnswerServiceTest {

  // Mock of AnswerRepository
  @Mock
  private AnswerRepository answerRepository;

  // Mock of AnswerMapper
  @Mock
  private AnswerMapper answerMapper;

  // The service under test
  @InjectMocks
  private AnswerService answerService;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the functionality of updating an existing Answer entity with a new answer
   * provided in an AnswerRequest. It verifies that the updated Answer entity has the new answer.
   */
  @DisplayName("Should update Answer entity with new answer when provided in AnswerRequest")
  @Test
  void patchShouldUpdateAnswerWhenNewAnswerIsProvided() {
    Answer existingAnswer = new Answer();
    existingAnswer.setAnswer("Old Answer");

    AnswerRequest answerRequest = new AnswerRequest();
    answerRequest.setAnswer("New Answer");

    Answer updatedAnswer = answerService.patch(existingAnswer, answerRequest);

    assertEquals("New Answer", updatedAnswer.getAnswer());
  }

  /**
   * This test checks the functionality of updating an existing Answer entity when no new answer is
   * provided in an AnswerRequest. It verifies that the existing answer in the Answer entity remains
   * unchanged.
   */
  @DisplayName("Should keep existing answer in Answer entity when no new "
      + "answer is provided in AnswerRequest")
  @Test
  void patchShouldKeepExistingAnswerWhenNoNewAnswerIsProvided() {
    Answer existingAnswer = new Answer();
    existingAnswer.setAnswer("Existing Answer");

    AnswerRequest answerRequest = new AnswerRequest();

    Answer updatedAnswer = answerService.patch(existingAnswer, answerRequest);

    assertEquals("Existing Answer", updatedAnswer.getAnswer());
  }
}
