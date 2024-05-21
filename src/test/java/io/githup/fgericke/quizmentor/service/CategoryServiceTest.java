package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * This class is a test class for the CategoryService class. It uses JUnit and Mockito for testing.
 */
class CategoryServiceTest {

  private static final int PAGE_SIZE = 100;
  private static final int DELETE_INVOCATION_COUNT = 1;

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
   * This method sets up the test environment before each test method. It initializes the mock
   * objects and the service to be tested.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    categoryService = new CategoryService(categoryRepository, categoryResponse);
    when(category.getId()).thenReturn(UUID.randomUUID());
  }

  /**
   * This test method checks if the post method of the service creates a new category correctly.
   */
  @DisplayName("post creates a new category")
  @Test
  @Disabled
  void shouldCreateNewCategory() {
    when(categoryRequest.getName()).thenReturn("New Category");
    when(categoryRepository.save(any(Category.class))).thenReturn(category);

    CategoryResponse createdCategory = categoryService.post(categoryRequest);

    verify(categoryRepository).save(any(Category.class));
    assertEquals("New Category", createdCategory.getName());
  }

  /**
   * This test method checks if the getAll method of the service returns all categories correctly.
   */
  @DisplayName("getAll returns all categories")
  @Disabled
  @Test
  void shouldReturnAllCategories() {
    List<Category> categories = Arrays.asList(new Category(), new Category());
    when(categoryRepository.findAll()).thenReturn(categories);

    Pageable pageable = PageRequest.ofSize(PAGE_SIZE);
    Page<CategoryResponse> returnedCategories = categoryService.getAll(pageable);

    assertEquals(categories.size(), returnedCategories.getTotalElements());
  }

  /**
   * This test method checks if the get method of the service returns a category by id correctly.
   */
  @DisplayName("get returns a category by id")
  @Test
  void shouldReturnCategoryById() {
    UUID id = UUID.randomUUID();
    when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

    CategoryResponse returnedCategory = categoryService.get(id);

    assertEquals(categoryResponse.map(category), returnedCategory);
  }

  /**
   * This test method checks if the put method of the service updates a category correctly.
   */
  @DisplayName("put updates a category")
  @Test
  @Disabled
  void shouldUpdateCategory() {
    UUID id = UUID.randomUUID();
    categoryRequest.setName("Updated Category");

    when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
    when(categoryRepository.save(any(Category.class))).thenReturn(category);

    CategoryResponse updatedCategory = categoryService.put(id, categoryRequest);

    assertEquals("Updated Category", updatedCategory.getName());
  }

  /**
   * This test method checks if the delete method of the service removes a category by id
   * correctly.
   */
  @DisplayName("delete removes a category by id")
  @Test
  @Disabled
  void shouldRemoveCategoryById() {
    UUID id = UUID.randomUUID();
    doNothing().when(categoryRepository).deleteById(id);

    categoryService.delete(id);

    verify(categoryRepository, times(DELETE_INVOCATION_COUNT)).deleteById(id);
  }

  /**
   * This test method checks if the getRepository method of the service returns the category
   * repository correctly.
   */
  @DisplayName("getRepository returns the category repository")
  @Test
  void shouldReturnCategoryRepository() {
    CategoryRepository returnedRepository = categoryService.getRepository();

    assertEquals(categoryRepository, returnedRepository);
  }

  /**
   * This test method checks if the getResponseDto method of the service returns the category
   * response dto correctly.
   */
  @DisplayName("getResponseDto returns the category response dto")
  @Test
  void shouldReturnCategoryResponseDto() {
    CategoryResponse returnedResponse = categoryService.getResponseDto();

    assertEquals(categoryResponse, returnedResponse);
  }

  /**
   * This test method checks if the patch method of the service updates category name when name is
   * provided.
   */
  @DisplayName("patch updates category name when name is provided")
  @Test
  void shouldUpdateCategoryNameWhenNameIsProvided() {
    when(categoryRequest.getName()).thenReturn("New Category Name");
    when(category.getName()).thenReturn("Old Category Name");

    categoryService.patch(category, categoryRequest);

    verify(category).setName("New Category Name");
  }

  /**
   * This test method checks if the patch method of the service does not update category name when
   * name is not provided.
   */
  @DisplayName("patch does not update category name when name is not provided")
  @Test
  void shouldNotUpdateCategoryNameWhenNameIsNotProvided() {
    when(categoryRequest.getName()).thenReturn(null);
    when(category.getName()).thenReturn("Old Category Name");

    categoryService.patch(category, categoryRequest);

    verify(category).setName("Old Category Name");
  }
}
