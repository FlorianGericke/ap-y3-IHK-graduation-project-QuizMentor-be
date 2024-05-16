package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.User;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AnswerResponseTest {

  private AnswerResponse answerResponse;
  private Answer answer;

  @Mock
  private Question question;

  @Mock
  private User owner;

  @Mock
  private User reviewedFrom;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    answer = new Answer();
    answerResponse = new AnswerResponse();
  }

  @DisplayName("Mapping null Answer results in null")
  @Test
  void mapNullAnswerResultsInNull() {
    assertNull(answerResponse.map(null));
  }

  @DisplayName("Mapping Answer with null fields results in corresponding AnswerResponse")
  @Test
  @Disabled
  void mapAnswerWithNullFieldsResultsInCorrespondingAnswerResponse() {
    AnswerResponse result = answerResponse.map(answer);
    assertNull(result.getId());
    assertNull(result.getIri());
    assertNull(result.getAnswer());
    assertNull(result.getQuestionIri());
    assertNull(result.getOwnerIri());
    assertNull(result.getReviewedFromIri());
    assertFalse(result.isCorrect());
  }

  @DisplayName("Mapping Answer with non-null fields results in corresponding AnswerResponse")
  @Test
  void mapAnswerWithNonNullFieldsResultsInCorrespondingAnswerResponse() {
    UUID id = UUID.randomUUID();
    answer.setId(id);
    answer.setAnswer("Answer");
    answer.setQuestion(question);
    answer.setOwner(owner);
    answer.setReviewedFrom(reviewedFrom);
    answer.setIsCorrect(true);

    AnswerResponse result = answerResponse.map(answer);
    assertEquals(id, result.getId());
    assertEquals("Answer", result.getAnswer());
    assertTrue(result.isCorrect());
  }
}
