package io.githup.fgericke.quizmentor.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the CategoryService class.
 */
class CategoryServiceTest {

  @Mock
  private CategoryRepository categoryRepository;

  @Mock
  private CategoryResponse categoryResponse;

  @Mock
  private Category category;

  @Mock
  private CategoryRequest categoryRequest;

  private CategoryService categoryService;

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    categoryService = new CategoryService(categoryRepository, categoryResponse);
  }

  /**
   * This test checks if the patch method of the CategoryService class updates the category name
   * when the name is not null.
   */
  @DisplayName("patch updates category name when name is not null")
  @Test
  void patchUpdatesCategoryNameWhenNameIsNotNull() {
    when(categoryRequest.getName()).thenReturn("New Category Name");
    when(category.getName()).thenReturn("Old Category Name");

    categoryService.patch(category, categoryRequest);

    verify(category).setName("New Category Name");
  }

  /**
   * This test checks if the patch method of the CategoryService class does not update the category
   * name when the name is null.
   */
  @DisplayName("patch does not update category name when name is null")
  @Test
  void patchDoesNotUpdateCategoryNameWhenNameIsNull() {
    when(categoryRequest.getName()).thenReturn(null);
    when(category.getName()).thenReturn("Old Category Name");

    categoryService.patch(category, categoryRequest);

    verify(category).setName("Old Category Name");
  }
}
