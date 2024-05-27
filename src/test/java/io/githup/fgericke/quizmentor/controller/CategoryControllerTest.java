package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.CategoryMapper;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.service.CategoryService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class contains unit tests for the CategoryController class. It uses Mockito for mocking
 * dependencies and JUnit 5 (Jupiter) for assertions and test management.
 */
public class CategoryControllerTest {

  @Mock
  private CategoryService service;

  @Mock
  private CategoryMapper mapper;

  @Mock
  private CategoryRequest requestDto;

  @Mock
  private Pageable pageable;

  private CategoryController controller;

  /**
   * This method sets up the test environment before each test. It initializes the mocks and the
   * object under test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new CategoryController(mapper, service);
  }

  /**
   * This test checks the postEntity method of the CategoryController. It verifies that a new
   * Category is created when the method is called.
   */
  @Test
  public void postCategory_createsNewCategory() {
    when(service.post(requestDto)).thenReturn(new Category());
    when(mapper.toDto(any())).thenReturn(new CategoryResponse());

    CategoryResponse response = controller.postEntity(requestDto);

    assertNotNull(response);
    verify(service, times(1)).post(requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntities method of the CategoryController. It verifies that all
   * Categories are retrieved when the method is called.
   */
  @Test
  @Disabled
  public void getCategories_retrievesAllCategories() {
    when(service.getAll(pageable)).thenReturn(Page.empty());
    when(mapper.toDto(any())).thenReturn(new CategoryResponse());

    Page<CategoryResponse> responses = controller.getEntities(pageable);

    assertNotNull(responses);
    verify(service, times(1)).getAll(pageable);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntity method of the CategoryController. It verifies that a specific
   * Category is retrieved when the method is called with an id.
   */
  @Test
  public void getCategory_retrievesSpecificCategory() {
    UUID id = UUID.randomUUID();
    when(service.get(id)).thenReturn(new Category());
    when(mapper.toDto(any())).thenReturn(new CategoryResponse());

    CategoryResponse response = controller.getEntity(id);

    assertNotNull(response);
    verify(service, times(1)).get(id);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the putEntity method of the CategoryController. It verifies that a specific
   * Category is updated when the method is called with an id and a requestDto.
   */
  @Test
  public void putCategory_updatesSpecificCategory() {
    UUID id = UUID.randomUUID();
    when(service.put(id, requestDto)).thenReturn(new Category());
    when(mapper.toDto(any())).thenReturn(new CategoryResponse());

    CategoryResponse response = controller.putEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).put(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the patchEntity method of the CategoryController. It verifies that a specific
   * Category is partially updated when the method is called with an id and a requestDto.
   */
  @Test
  public void patchCategory_updatesSpecificCategoryPartially() {
    UUID id = UUID.randomUUID();
    when(service.patch(id, requestDto)).thenReturn(new Category());
    when(mapper.toDto(any())).thenReturn(new CategoryResponse());

    CategoryResponse response = controller.patchEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).patch(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the deleteEntity method of the CategoryController. It verifies that a specific
   * Category is deleted when the method is called with an id.
   */
  @Test
  public void deleteCategory_deletesSpecificCategory() {
    UUID id = UUID.randomUUID();
    when(service.delete(id)).thenReturn(new Category());
    when(mapper.toDto(any())).thenReturn(new CategoryResponse());

    CategoryResponse response = controller.deleteEntity(id);

    assertNotNull(response);
    verify(service, times(1)).delete(id);
    verify(mapper, times(1)).toDto(any());
  }
}
