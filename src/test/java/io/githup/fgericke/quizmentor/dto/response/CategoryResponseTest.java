import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the CategoryResponse class. It tests the mapToResponse method
 * with different scenarios.
 */
class CategoryResponseTest {

  // The CategoryResponse object to be tested
  private CategoryResponse categoryResponse;

  // The Category object used as input for the mapToResponse method
  private Category category;

  /**
   * This method sets up the test environment before each test. It initializes the CategoryResponse
   * and Category objects.
   */
  @BeforeEach
  void setUp() {
    categoryResponse = new CategoryResponse();
    category = new Category();
  }

  /**
   * This test checks if the mapToResponse method returns null when the input is null.
   */
  @DisplayName("Mapping null Category results in null")
  @Test
  void mapNullCategoryResultsInNull() {
    assertNull(categoryResponse.map(null));
  }

  /**
   * This test checks if the mapToResponse method correctly maps a Category object with null fields
   * to a CategoryResponse object.
   */
  @DisplayName("Mapping Category with null fields results in corresponding CategoryResponse")
  @Test
  void mapCategoryWithNullFieldsResultsInCorrespondingCategoryResponse() {
    CategoryResponse result = categoryResponse.map(category);
    assertNull(result.getId());
    assertNull(result.getIri());
    assertNull(result.getName());
  }

  /**
   * This test checks if the mapToResponse method correctly maps a Category object with non-null
   * fields to a CategoryResponse object.
   */
  @DisplayName("Mapping Category with non-null fields results in corresponding CategoryResponse")
  @Test
  void mapCategoryWithNonNullFieldsResultsInCorrespondingCategoryResponse() {
    UUID id = UUID.randomUUID();
    category.setId(id);
    category.setName("Category Name");

    CategoryResponse result = categoryResponse.map(category);
    assertEquals(id, result.getId());
    assertEquals("Category Name", result.getName());
    assertNotNull(result.getIri());
  }
}
