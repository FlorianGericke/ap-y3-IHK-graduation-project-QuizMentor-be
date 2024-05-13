package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The CategoryRequestTest class contains unit tests for the CategoryRequest class. It tests the
 * conversion of a CategoryRequest to a Category entity.
 */
class CategoryRequestTest {

  private static final String TEST_CATEGORY = "Test Category";
  private static final String EXCEPTION_REASON = "[Category] Name cannot be null";
  private static final HttpStatusCode EXCEPTION_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

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
    categoryRequest.setName(TEST_CATEGORY);

    Category category = categoryRequest.toEntity();

    assertEquals(TEST_CATEGORY, category.getName());
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

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }
}
