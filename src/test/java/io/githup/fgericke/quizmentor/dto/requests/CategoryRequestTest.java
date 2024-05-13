import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The CategoryRequestTest class contains unit tests for the CategoryRequest class. It tests the
 * conversion of a CategoryRequest to a Category entity.
 */
class CategoryRequestTest {

  public static final int INTERNAL_SERVER_ERROR = 500;

  /**
   * The CategoryRequest object that will be used in the tests.
   */
  private CategoryRequest categoryRequest;

  /**
   * This method is executed before each test. It initializes the CategoryRequest object.
   */
  @BeforeEach
  void setUp() {
    categoryRequest = new CategoryRequest();
  }

  /**
   * This test checks the conversion of a CategoryRequest to a Category entity when the name is not
   * null. It sets the name of the CategoryRequest, converts it to a Category entity, and asserts
   * that the name of the Category entity is the same as the name set in the CategoryRequest.
   */
  @Test
  @DisplayName("Should convert to entity when name is not null")
  void shouldConvertToEntityWhenNameIsNotNull() {
    categoryRequest.setName("Test Category");

    Category category = categoryRequest.toEntity();

    assertEquals("Test Category", category.getName());
  }

  /**
   * This test checks the conversion of a CategoryRequest to a Category entity when the name is
   * null. It sets the name of the CategoryRequest to null, tries to convert it to a Category
   * entity, and asserts that a ResponseStatusException is thrown with a 500 status code and a
   * specific error message.
   */
  @Test
  @DisplayName("Should throw exception when name is null")
  void shouldThrowExceptionWhenNameIsNull() {
    categoryRequest.setName(null);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        categoryRequest::toEntity);

    assertEquals(HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR), exception.getStatusCode());
    assertEquals("[Category] Name cannot be null", exception.getReason());
  }
}
