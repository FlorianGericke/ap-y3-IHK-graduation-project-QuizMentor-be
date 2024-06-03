package io.githup.fgericke.quizmentor.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the QuizResponse class. It tests the getter and setter methods
 * of the QuizResponse class.
 */
class QuizResponseTest {

  // Instance of QuizResponse to be used in the tests
  private QuizResponse quizResponse;

  /**
   * This method sets up the QuizResponse instance before each test.
   */
  @BeforeEach
  void setUp() {
    quizResponse = new QuizResponse();
  }

  /**
   * This test checks the setter and getter for the id field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get id correctly")
  @Test
  void shouldSetAndGetId() {
    UUID expectedId = UUID.randomUUID();
    quizResponse.setId(expectedId);
    UUID actualId = quizResponse.getId();
    assertEquals(expectedId, actualId);
  }

  /**
   * This test checks the setter and getter for the iri field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get iri correctly")
  @Test
  void shouldSetAndGetIri() {
    String expectedIri = "testIri";
    quizResponse.setIri(expectedIri);
    String actualIri = quizResponse.getIri();
    assertEquals(expectedIri, actualIri);
  }

  /**
   * This test checks the setter and getter for the title field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get title correctly")
  @Test
  void shouldSetAndGetTitle() {
    String expectedTitle = "testTitle";
    quizResponse.setTitle(expectedTitle);
    String actualTitle = quizResponse.getTitle();
    assertEquals(expectedTitle, actualTitle);
  }

  /**
   * This test checks the setter and getter for the description field. It verifies that the set
   * value is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get description correctly")
  @Test
  void shouldSetAndGetDescription() {
    String expectedDescription = "testDescription";
    quizResponse.setDescription(expectedDescription);
    String actualDescription = quizResponse.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  /**
   * This test checks the setter and getter for the categories field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get categories correctly")
  @Test
  void shouldSetAndGetCategories() {
    List<String> expectedCategories = Arrays.asList("category1", "category2");
    quizResponse.setCategories(expectedCategories);
    List<String> actualCategories = quizResponse.getCategories();
    assertEquals(expectedCategories, actualCategories);
  }

  /**
   * This test checks the setter and getter for the questions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get questions correctly")
  @Test
  void shouldSetAndGetQuestions() {
    List<String> expectedQuestions = Arrays.asList("question1", "question2");
    quizResponse.setQuestions(expectedQuestions);
    List<String> actualQuestions = quizResponse.getQuestions();
    assertEquals(expectedQuestions, actualQuestions);
  }

  /**
   * This test checks the setter and getter for the ownerIri field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get ownerIri correctly")
  @Test
  void shouldSetAndGetOwnerIri() {
    String expectedOwnerIri = "testOwnerIri";
    quizResponse.setOwnerIri(expectedOwnerIri);
    String actualOwnerIri = quizResponse.getOwnerIri();
    assertEquals(expectedOwnerIri, actualOwnerIri);
  }

  /**
   * This test checks the setter and getter for the status field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get status correctly")
  @Test
  void shouldSetAndGetStatus() {
    Visibility expectedStatus = Visibility.PUBLISHED;
    quizResponse.setStatus(expectedStatus);
    Visibility actualStatus = quizResponse.getStatus();
    assertEquals(expectedStatus, actualStatus);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    quizResponse.setId(null);
    quizResponse.setIri(null);
    quizResponse.setTitle(null);
    quizResponse.setDescription(null);
    quizResponse.setCategories(null);
    quizResponse.setQuestions(null);
    quizResponse.setOwnerIri(null);
    quizResponse.setStatus(null);

    assertNull(quizResponse.getId());
    assertNull(quizResponse.getIri());
    assertNull(quizResponse.getTitle());
    assertNull(quizResponse.getDescription());
    assertNull(quizResponse.getCategories());
    assertNull(quizResponse.getQuestions());
    assertNull(quizResponse.getOwnerIri());
    assertNull(quizResponse.getStatus());
  }
}
