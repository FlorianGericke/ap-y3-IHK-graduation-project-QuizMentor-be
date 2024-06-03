package io.githup.fgericke.quizmentor.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the Solution class.
 */
class SolutionTest {

  /**
   * The Solution instance that will be tested.
   */
  private Solution solution;

  /**
   * Mocked Question instance for testing.
   */
  @Mock
  private Question question;

  /**
   * Mocked User instance representing the creator of the solution.
   */
  @Mock
  private User createdFrom;


  /**
   * This method sets up the testing environment before each test. It initializes a new Solution
   * instance with mocked dependencies.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    solution = Solution.builder()
        .solution("Test Solution")
        .question(question)
        .score(0)
        .createdFrom(createdFrom)
        .build();
  }

  /**
   * This test checks if the getSolution method returns the correct solution.
   */
  @Test
  void givenSolution_whenGetSolution_thenReturnSolution() {
    assertEquals("Test Solution", solution.getSolution());
  }

  /**
   * This test checks if the getQuestion method returns the correct question.
   */
  @Test
  void givenSolution_whenGetQuestion_thenReturnQuestion() {
    assertEquals(question, solution.getQuestion());
  }

  /**
   * This test checks if the getScore method returns the correct score.
   */
  @Test
  void givenSolution_whenGetScore_thenReturnScore() {
    assertEquals(0, solution.getScore());
  }

  /**
   * This test checks if the getCreatedFrom method returns the correct User instance.
   */
  @Test
  void givenSolution_whenGetCreatedFrom_thenReturnCreatedFrom() {
    assertEquals(createdFrom, solution.getCreatedFrom());
  }
}
