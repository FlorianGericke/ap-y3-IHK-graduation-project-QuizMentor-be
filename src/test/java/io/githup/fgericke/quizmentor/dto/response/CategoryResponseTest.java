package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the CategoryResponse class. It tests the getter and setter
 * methods of the CategoryResponse class.
 */
class CategoryResponseTest {

  // Instance of CategoryResponse to be used in the tests
  private CategoryResponse categoryResponse;

  /**
   * This method sets up the CategoryResponse instance before each test.
   */
  @BeforeEach
  void setUp() {
    categoryResponse = new CategoryResponse();
  }

  /**
   * This test checks the setter and getter for the name field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get name correctly")
  @Test
  void shouldSetAndGetName() {
    String expectedName = "TestCategory";
    categoryResponse.setName(expectedName);
    String actualName = categoryResponse.getName();
    assertEquals(expectedName, actualName);
  }

  /**
   * This test checks the setter and getter for the iri field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get iri correctly")
  @Test
  void shouldSetAndGetIri() {
    String expectedIri = "testIri";
    categoryResponse.setIri(expectedIri);
    String actualIri = categoryResponse.getIri();
    assertEquals(expectedIri, actualIri);
  }

  /**
   * This test checks the setter and getter for the id field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get id correctly")
  @Test
  void shouldSetAndGetId() {
    UUID expectedId = UUID.randomUUID();
    categoryResponse.setId(expectedId);
    UUID actualId = categoryResponse.getId();
    assertEquals(expectedId, actualId);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    categoryResponse.setName(null);
    categoryResponse.setIri(null);
    categoryResponse.setId(null);

    assertNull(categoryResponse.getName());
    assertNull(categoryResponse.getIri());
    assertNull(categoryResponse.getId());
  }
}
