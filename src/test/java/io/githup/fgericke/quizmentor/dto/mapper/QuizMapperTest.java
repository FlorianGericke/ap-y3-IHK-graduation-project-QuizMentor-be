package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.UserService;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuizMapper class. It tests the conversion of QuizRequest
 * to Quiz entity and vice versa.
 */
class QuizMapperTest {

  // Mocked CategoryService instance
  @Mock
  private CategoryService categoryService;

  // Mocked UserService instance
  @Mock
  private UserService userService;

  // Mocked QuestionService instance
  @Mock
  private QuestionService questionService;

  // Injected QuizMapper instance
  @InjectMocks
  private QuizMapper quizMapper;

  /**
   * This method sets up the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the conversion of QuizRequest to Quiz entity. It verifies that the conversion
   * is successful when all required fields are present.
   */
  @DisplayName("Should convert QuizRequest to Quiz entity successfully")
  @Test
  @Disabled
  void toEntityHappyPath() {
    QuizRequest request = new QuizRequest();
    request.setTitle("Quiz");
    request.setCategories(Collections.emptyList());
    request.setQuestions(Collections.emptyList());

    Quiz result = quizMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("Quiz", result.getTitle());
  }

  /**
   * This test checks the conversion of QuizRequest to Quiz entity. It verifies that a
   * MissingMandatoryFieldException is thrown when required fields are missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when QuizRequest has missing title")
  @Test
  void toEntityMissingTitle() {
    QuizRequest request = new QuizRequest();
    request.setCategories(Collections.emptyList());
    request.setQuestions(Collections.emptyList());

    assertThrows(MissingMandatoryFieldException.class, () -> quizMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of Quiz entity to QuizResponse. It verifies that the conversion
   * is successful.
   */
  @DisplayName("Should convert Quiz entity to QuizResponse successfully")
  @Test
  void toDtoHappyPath() {
    Quiz quiz = new Quiz();
    quiz.setTitle("Quiz");

    QuizResponse result = quizMapper.toDto(quiz);

    assertNotNull(result);
    assertEquals("Quiz", result.getTitle());
  }

  /**
   * This test checks the conversion of Quiz entity to QuizResponse. It verifies that null is
   * returned when the input is null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    QuizResponse result = quizMapper.toDto(null);

    assertNull(result);
  }
}
