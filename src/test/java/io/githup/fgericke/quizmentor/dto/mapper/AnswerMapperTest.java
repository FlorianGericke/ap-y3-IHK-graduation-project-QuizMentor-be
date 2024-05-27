package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the AnswerMapper class. It tests the conversion of
 * AnswerRequest to Answer entity and vice versa.
 */
class AnswerMapperTest {

  @Mock
  private UserService userService;

  @Mock
  private QuestionService questionService;

  @InjectMocks
  private AnswerMapper answerMapper;

  /**
   * This method sets up the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the conversion of AnswerRequest to Answer entity. It verifies that the
   * conversion is successful when all required fields are present.
   */
  @DisplayName("Should convert AnswerRequest to Answer entity successfully")
  @Test
  @Disabled
  void toEntityHappyPath() {
    AnswerRequest request = new AnswerRequest();
    request.setAnswer("Answer");
    request.setQuestion("Question");
    request.setOwner("Owner");

    Answer result = answerMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("Answer", result.getAnswer());
    assertEquals("Question", result.getQuestion().getId().toString());
    assertEquals("Owner", result.getOwner().getId().toString());
  }

  /**
   * This test checks the conversion of AnswerRequest to Answer entity. It verifies that a
   * MissingMandatoryFieldException is thrown when required fields are missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when AnswerRequest has missing fields")
  @Test
  void toEntityMissingFields() {
    AnswerRequest request = new AnswerRequest();

    assertThrows(MissingMandatoryFieldException.class, () -> answerMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of Answer entity to AnswerResponse. It verifies that the
   * conversion is successful.
   */
  @DisplayName("Should convert Answer entity to AnswerResponse successfully")
  @Test
  @Disabled
  void toDtoHappyPath() {
    Answer answer = new Answer();
    answer.setAnswer("Answer");

    AnswerResponse result = answerMapper.toDto(answer);

    assertNotNull(result);
    assertEquals("Answer", result.getAnswer());
  }

  /**
   * This test checks the conversion of Answer entity to AnswerResponse. It verifies that null is
   * returned when the input is null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    AnswerResponse result = answerMapper.toDto(null);

    assertNull(result);
  }
}
