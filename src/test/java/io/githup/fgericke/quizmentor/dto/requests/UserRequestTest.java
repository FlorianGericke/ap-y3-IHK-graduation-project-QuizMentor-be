package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.Role;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the UserRequest class. It tests the getter and setter methods
 * of the UserRequest class.
 */
class UserRequestTest {

  // Instance of UserRequest to be used in the tests
  private UserRequest userRequest;

  /**
   * This method sets up the UserRequest instance before each test.
   */
  @BeforeEach
  void setUp() {
    userRequest = new UserRequest();
  }

  /**
   * This test checks the setter and getter for the mail field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get mail correctly")
  @Test
  void shouldSetAndGetMail() {
    String expectedMail = "test@mail.com";
    userRequest.setMail(expectedMail);
    String actualMail = userRequest.getMail();
    assertEquals(expectedMail, actualMail);
  }

  /**
   * This test checks the setter and getter for the password field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get password correctly")
  @Test
  void shouldSetAndGetPassword() {
    String expectedPassword = "password123";
    userRequest.setPassword(expectedPassword);
    String actualPassword = userRequest.getPassword();
    assertEquals(expectedPassword, actualPassword);
  }

  /**
   * This test checks the setter and getter for the role field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get role correctly")
  @Test
  void shouldSetAndGetRole() {
    Role expectedRole = Role.TRAINEE;
    userRequest.setRole(expectedRole);
    Role actualRole = userRequest.getRole();
    assertEquals(expectedRole, actualRole);
  }

  /**
   * This test checks the setter and getter for the answers field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get answers correctly")
  @Test
  void shouldSetAndGetAnswers() {
    List<String> expectedAnswers = Arrays.asList("Answer1", "Answer2");
    userRequest.setAnswers(expectedAnswers);
    List<String> actualAnswers = userRequest.getAnswers();
    assertEquals(expectedAnswers, actualAnswers);
  }

  /**
   * This test checks the setter and getter for the solutions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get solutions correctly")
  @Test
  void shouldSetAndGetSolutions() {
    List<String> expectedSolutions = Arrays.asList("Solution1", "Solution2");
    userRequest.setSolutions(expectedSolutions);
    List<String> actualSolutions = userRequest.getSolutions();
    assertEquals(expectedSolutions, actualSolutions);
  }

  /**
   * This test checks the setter and getter for the quizzes field. It verifies that the set value is
   * correctly retrieved by the getter.
   */
  @DisplayName("Should set and get quizzes correctly")
  @Test
  void shouldSetAndGetQuizzes() {
    List<String> expectedQuizzes = Arrays.asList("Quiz1", "Quiz2");
    userRequest.setQuizzes(expectedQuizzes);
    List<String> actualQuizzes = userRequest.getQuizzes();
    assertEquals(expectedQuizzes, actualQuizzes);
  }

  /**
   * This test checks the setter and getter for the questions field. It verifies that the set value
   * is correctly retrieved by the getter.
   */
  @DisplayName("Should set and get questions correctly")
  @Test
  void shouldSetAndGetQuestions() {
    List<String> expectedQuestions = Arrays.asList("Question1", "Question2");
    userRequest.setQuestions(expectedQuestions);
    List<String> actualQuestions = userRequest.getQuestions();
    assertEquals(expectedQuestions, actualQuestions);
  }

  /**
   * This test checks the handling of null values by the setter and getter methods. It verifies that
   * null is returned when the setter is called with null.
   */
  @DisplayName("Should handle null values correctly")
  @Test
  void shouldHandleNullValues() {
    userRequest.setMail(null);
    userRequest.setPassword(null);
    userRequest.setRole(null);
    userRequest.setAnswers(null);
    userRequest.setSolutions(null);
    userRequest.setQuizzes(null);
    userRequest.setQuestions(null);

    assertNull(userRequest.getMail());
    assertNull(userRequest.getPassword());
    assertNull(userRequest.getRole());
    assertNull(userRequest.getAnswers());
    assertNull(userRequest.getSolutions());
    assertNull(userRequest.getQuizzes());
    assertNull(userRequest.getQuestions());
  }
}
