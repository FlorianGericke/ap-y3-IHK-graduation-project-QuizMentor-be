package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.CategoryMapper;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the CategoryService class. It tests the functionality of
 * updating an existing Category entity with new data provided in a CategoryRequest.
 */
class CategoryServiceTest {

  // Mock of CategoryRepository
  @Mock
  private CategoryRepository categoryRepository;

  // Mock of CategoryMapper
  @Mock
  private CategoryMapper categoryMapper;

  // The service under test
  @InjectMocks
  private CategoryService categoryService;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the functionality of updating an existing Category entity with a new name
   * provided in a CategoryRequest. It verifies that the updated Category entity has the new name.
   */
  @DisplayName("Should update Category entity name when new name is provided in CategoryRequest")
  @Test
  void patchShouldUpdateCategoryNameWhenNewNameIsProvided() {
    Category existingCategory = new Category();
    existingCategory.setName("Old Category Name");

    CategoryRequest categoryRequest = new CategoryRequest();
    categoryRequest.setName("New Category Name");

    Category updatedCategory = categoryService.patch(existingCategory, categoryRequest);

    assertEquals("New Category Name", updatedCategory.getName());
  }

  /**
   * This test checks the functionality of updating an existing Category entity when no new name is
   * provided in a CategoryRequest. It verifies that the existing name in the Category entity
   * remains unchanged.
   */
  @DisplayName("Should keep existing Category entity name when no new "
      + "name is provided in CategoryRequest")
  @Test
  void patchShouldKeepExistingCategoryNameWhenNoNewNameIsProvided() {
    Category existingCategory = new Category();
    existingCategory.setName("Existing Category Name");

    CategoryRequest categoryRequest = new CategoryRequest();

    Category updatedCategory = categoryService.patch(existingCategory, categoryRequest);

    assertEquals("Existing Category Name", updatedCategory.getName());
  }
}
