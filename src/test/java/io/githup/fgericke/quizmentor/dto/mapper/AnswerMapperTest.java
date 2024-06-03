package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.UserService;
import org.junit.jupiter.api.BeforeEach;
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

  // Mocked UserService instance
  @Mock
  private UserService userService;

  // Mocked QuestionService instance
  @Mock
  private QuestionService questionService;

  // Injected AnswerMapper instance
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
   * This test checks the conversion of Answer entity to AnswerResponse. It verifies that null is
   * returned when the input is null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    AnswerResponse result = answerMapper.toDto(null);

    assertNull(result);
  }

  /**
   * This test checks the conversion of AnswerRequest to Answer entity. It verifies that a
   * MissingMandatoryFieldException is thrown when the Answer field is missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when AnswerRequest "
      + "has missing Answer field")
  @Test
  void toEntityMissingAnswerField() {
    AnswerRequest request = new AnswerRequest();
    request.setQuestion("Question");
    request.setCreatedFrom("Owner");

    assertThrows(MissingMandatoryFieldException.class, () -> answerMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of AnswerRequest to Answer entity. It verifies that a
   * MissingMandatoryFieldException is thrown when the Question field is missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when AnswerRequest "
      + "has missing Question field")
  @Test
  void toEntityMissingQuestionField() {
    AnswerRequest request = new AnswerRequest();
    request.setAnswer("Answer");
    request.setCreatedFrom("Owner");

    assertThrows(MissingMandatoryFieldException.class, () -> answerMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of AnswerRequest to Answer entity. It verifies that a
   * MissingMandatoryFieldException is thrown when the User field is missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when AnswerRequest "
      + "has missing User field")
  @Test
  void toEntityMissingUserField() {
    AnswerRequest request = new AnswerRequest();
    request.setAnswer("Answer");
    request.setQuestion("Question");

    assertThrows(MissingMandatoryFieldException.class, () -> answerMapper.toEntity(request));
  }
}
