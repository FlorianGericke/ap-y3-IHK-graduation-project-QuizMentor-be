package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Solution;
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
 * This class contains unit tests for the SolutionMapper class. It tests the conversion of
 * SolutionRequest to Solution entity and vice versa.
 */
class SolutionMapperTest {

  private static final int EXISTING_SCORE = 10;

  // Mocked UserService instance
  @Mock
  private UserService userService;

  // Mocked QuestionService instance
  @Mock
  private QuestionService questionService;

  // Injected SolutionMapper instance
  @InjectMocks
  private SolutionMapper solutionMapper;

  /**
   * This method sets up the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the conversion of SolutionRequest to Solution entity. It verifies that a
   * MissingMandatoryFieldException is thrown when required fields are missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException "
      + "when SolutionRequest has missing fields")
  @Test
  void toEntityMissingFields() {
    SolutionRequest request = new SolutionRequest();

    assertThrows(MissingMandatoryFieldException.class, () -> solutionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of SolutionRequest to Solution entity when the solution field
   * is missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when SolutionRequest "
      + "has missing solution field")
  @Test
  void toEntityMissingSolutionField() {
    SolutionRequest request = new SolutionRequest();
    request.setCreatedFrom("CreatedFrom");
    request.setQuestion("Question");
    request.setScore(EXISTING_SCORE);

    assertThrows(MissingMandatoryFieldException.class, () -> solutionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of SolutionRequest to Solution entity when the createdFrom
   * field is missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when SolutionRequest "
      + "has missing createdFrom field")
  @Test
  void toEntityMissingCreatedFromField() {
    SolutionRequest request = new SolutionRequest();
    request.setSolution("Solution");
    request.setQuestion("Question");
    request.setScore(EXISTING_SCORE);

    assertThrows(MissingMandatoryFieldException.class, () -> solutionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of SolutionRequest to Solution entity when the question field
   * is missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when SolutionRequest "
      + "has missing question field")
  @Test
  void toEntityMissingQuestionField() {
    SolutionRequest request = new SolutionRequest();
    request.setSolution("Solution");
    request.setCreatedFrom("CreatedFrom");
    request.setScore(EXISTING_SCORE);

    assertThrows(MissingMandatoryFieldException.class, () -> solutionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of Solution entity to SolutionResponse. It verifies that the
   * conversion is successful and the resulting SolutionResponse has the expected values.
   */
  @DisplayName("Should convert Solution entity to SolutionResponse successfully")
  @Test
  void toDtoHappyPath() {
    Solution solution = new Solution();
    solution.setSolution("Solution");
    solution.setScore(EXISTING_SCORE);

    SolutionResponse result = solutionMapper.toDto(solution);

    assertNotNull(result);
    assertEquals("Solution", result.getSolution());
    assertEquals(EXISTING_SCORE, result.getScore());
  }

  /**
   * This test checks the conversion of null Solution entity to SolutionResponse. It verifies that
   * the conversion returns null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    SolutionResponse result = solutionMapper.toDto(null);

    assertNull(result);
  }
}
