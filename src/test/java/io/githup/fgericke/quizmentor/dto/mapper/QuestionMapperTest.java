package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.githup.fgericke.quizmentor.service.SolutionService;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuestionMapper class. It tests the conversion of
 * QuestionRequest to Question entity and vice versa.
 */
class QuestionMapperTest {

  // Mocked CategoryService instance
  @Mock
  private CategoryService categoryService;

  // Mocked SolutionService instance
  @Mock
  private SolutionService solutionService;

  // Mocked QuizService instance
  @Mock
  private QuizService quizService;

  // Injected QuestionMapper instance
  @InjectMocks
  private QuestionMapper questionMapper;

  /**
   * This method sets up the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the conversion of QuestionRequest to Question entity. It verifies that the
   * conversion is successful when all required fields are present.
   */
  @DisplayName("Should convert QuestionRequest to Question entity successfully")
  @Test
  @Disabled
  void toEntityHappyPath() {
    QuestionRequest request = new QuestionRequest();
    request.setTitle("Question");
    request.setCategories(Collections.emptyList());
    request.setSolutions(Collections.emptyList());

    Question result = questionMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("Question", result.getTitle());
  }

  /**
   * This test checks the conversion of QuestionRequest to Question entity when all fields are
   * present. It verifies that the conversion is successful.
   */
  @DisplayName("Should convert QuestionRequest to Question entity successfully when all fields are present")
  @Test
  @Disabled
  void toEntityAllFieldsPresent() {
    QuestionRequest request = new QuestionRequest();
    request.setTitle("Question");
    request.setCategories(Collections.emptyList());
    request.setSolutions(Collections.emptyList());

    Question result = questionMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("Question", result.getTitle());
  }

  /**
   * This test checks the conversion of QuestionRequest to Question entity when the title field is
   * missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when QuestionRequest has missing title")
  @Test
  void toEntityMissingTitle() {
    QuestionRequest request = new QuestionRequest();
    request.setCategories(Collections.emptyList());
    request.setSolutions(Collections.emptyList());

    assertThrows(MissingMandatoryFieldException.class, () -> questionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of Question entity to QuestionResponse. It verifies that the
   * conversion is successful.
   */
  @DisplayName("Should convert Question entity to QuestionResponse successfully")
  @Test
  void toDtoHappyPath() {
    Question question = new Question();
    question.setTitle("Question");

    QuestionResponse result = questionMapper.toDto(question);

    assertNotNull(result);
    assertEquals("Question", result.getTitle());
  }

  /**
   * This test checks the conversion of null to QuestionResponse. It verifies that the conversion
   * returns null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    QuestionResponse result = questionMapper.toDto(null);

    assertNull(result);
  }
}
