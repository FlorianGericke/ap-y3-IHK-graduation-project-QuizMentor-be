package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.CategoryMapper;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the CategoryService class.
 */
class CategoryServiceTest {

  @Mock
  private CategoryRepository categoryRepository; // Mock of CategoryRepository

  @Mock
  private CategoryMapper categoryMapper; // Mock of CategoryMapper

  @InjectMocks
  private CategoryService categoryService; // The service under test

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize the mocks
  }

  /**
   * This test verifies that the patch method of the CategoryService correctly updates the category
   * name when a new name is provided in the request.
   */
  @Test
  void patchShouldUpdateCategoryNameWhenNewNameIsProvided() {
    Category existingCategory = new Category();
    existingCategory.setName("Old Category Name");

    CategoryRequest categoryRequest = new CategoryRequest();
    categoryRequest.setName("New Category Name");

    Category updatedCategory = categoryService.patch(existingCategory, categoryRequest);

    assertEquals("New Category Name",
        updatedCategory.getName()); // Assert that the category name has been updated
  }

  /**
   * This test verifies that the patch method of the CategoryService keeps the existing category
   * name when no new name is provided in the request.
   */
  @Test
  void patchShouldKeepExistingCategoryNameWhenNoNewNameIsProvided() {
    Category existingCategory = new Category();
    existingCategory.setName("Existing Category Name");

    CategoryRequest categoryRequest = new CategoryRequest();

    Category updatedCategory = categoryService.patch(existingCategory, categoryRequest);

    assertEquals("Existing Category Name",
        updatedCategory.getName()); // Assert that the category name has not been updated
  }
}
