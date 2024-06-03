package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.QuizService;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the CategoryMapper class. It tests the conversion of
 * CategoryRequest to Category entity and vice versa.
 */
class CategoryMapperTest {

  // Mocked QuestionService instance
  @Mock
  private QuestionService questionService;

  // Mocked QuizService instance
  @Mock
  private QuizService quizService;

  // Injected CategoryMapper instance
  @InjectMocks
  private CategoryMapper categoryMapper;

  /**
   * This method sets up the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the conversion of CategoryRequest to Category entity. It verifies that the
   * conversion is successful when all required fields are present.
   */
  @DisplayName("Should convert CategoryRequest to Category entity successfully")
  @Test
  void toEntityHappyPath() {
    CategoryRequest request = new CategoryRequest();
    request.setName("Category");
    request.setQuestions(Collections.emptyList());
    request.setQuizzes(Collections.emptyList());

    Category result = categoryMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("Category", result.getName());
  }

  /**
   * This test checks the conversion of CategoryRequest to Category entity. It verifies that a
   * MissingMandatoryFieldException is thrown when required fields are missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when CategoryRequest has missing name")
  @Test
  void toEntityMissingName() {
    CategoryRequest request = new CategoryRequest();
    request.setQuestions(Collections.emptyList());
    request.setQuizzes(Collections.emptyList());

    assertThrows(MissingMandatoryFieldException.class, () -> categoryMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of Category entity to CategoryResponse. It verifies that the
   * conversion is successful.
   */
  @DisplayName("Should convert Category entity to CategoryResponse successfully")
  @Test
  void toDtoHappyPath() {
    Category category = new Category();
    category.setName("Category");

    CategoryResponse result = categoryMapper.toDto(category);

    assertNotNull(result);
    assertEquals("Category", result.getName());
  }

  /**
   * This test checks the conversion of Category entity to CategoryResponse. It verifies that null
   * is returned when the input is null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    CategoryResponse result = categoryMapper.toDto(null);

    assertNull(result);
  }
}
