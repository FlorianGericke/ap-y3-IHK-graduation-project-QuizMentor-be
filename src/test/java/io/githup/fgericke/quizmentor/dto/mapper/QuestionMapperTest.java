package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.githup.fgericke.quizmentor.service.SolutionService;
import io.githup.fgericke.quizmentor.service.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
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

  // Mocked UserService instance
  @Mock
  private UserService userService;

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
   * This test checks the conversion of QuestionRequest to Question entity when the title field is
   * missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when QuestionRequest"
      + " has missing title")
  @Test
  void toEntityMissingTitle() {
    QuestionRequest request = new QuestionRequest();
    request.setCategories(Collections.emptyList());
    request.setSolutions(Collections.emptyList());

    assertThrows(MissingMandatoryFieldException.class, () -> questionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of QuestionRequest to Question entity when all fields are
   * present. It verifies that the conversion is successful and the resulting Question entity has
   * the expected values.
   */
  @DisplayName("Should convert QuestionRequest to Question entity successfully "
      + "when all fields are present")
  @Test
  void toEntityHappyPath() {
    QuestionRequest request = new QuestionRequest();
    request.setTitle("Question");
    request.setCategories(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setSolutions(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setQuizzes(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setCreatedFrom("Owner");

    User user = new User();
    user.setMail("Owner");
    when(userService.findByMail(anyString())).thenReturn(user);
    when(categoryService.getReference(any())).thenReturn(new Category());
    when(solutionService.getReference(any())).thenReturn(new Solution());
    when(quizService.getReference(any())).thenReturn(new Quiz());

    Question result = questionMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("Question", result.getTitle());
    assertEquals("Owner", result.getCreatedFrom().getMail());
  }

  /**
   * This test checks the conversion of QuestionRequest to Question entity when the title field is
   * missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when "
      + "QuestionRequest has missing title field")
  @Test
  void toEntityMissingTitleField() {
    QuestionRequest request = new QuestionRequest();
    request.setCategories(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setSolutions(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setQuizzes(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setCreatedFrom("Owner");

    assertThrows(MissingMandatoryFieldException.class, () -> questionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of QuestionRequest to Question entity when the categories field
   * is missing. It verifies that the conversion throws a MissingMandatoryFieldException.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when "
      + "QuestionRequest has missing categories field")
  @Test
  void toEntityMissingCategoriesField() {
    QuestionRequest request = new QuestionRequest();
    request.setTitle("Question");
    request.setSolutions(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setQuizzes(Collections.singletonList(String.valueOf(UUID.randomUUID())));
    request.setCreatedFrom("Owner");

    assertThrows(MissingMandatoryFieldException.class, () -> questionMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of Question entity to QuestionResponse. It verifies that the
   * conversion is successful and the resulting QuestionResponse has the expected values.
   */
  @DisplayName("Should convert Question entity to QuestionResponse successfully")
  @Test
  void toDtoHappyPath() {
    Question question = new Question();
    question.setTitle("Question");
    question.setAnswers(new ArrayList<>());
    question.setSolutions(new ArrayList<>());

    QuestionResponse result = questionMapper.toDto(question);

    assertNotNull(result);
    assertEquals("Question", result.getTitle());
  }

  /**
   * This test checks the conversion of null Question entity to QuestionResponse. It verifies that
   * the conversion returns null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    QuestionResponse result = questionMapper.toDto(null);

    assertNull(result);
  }
}
