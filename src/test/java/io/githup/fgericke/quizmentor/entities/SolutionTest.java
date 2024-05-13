import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.githup.fgericke.quizmentor.entities.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Solution class.
 */
class SolutionTest {

  /**
   * Constants representing different scores used in the tests.
   */
  private static final int SCORE_ZERO = 0;
  private static final int SCORE_ONE = 1;
  private static final int SCORE_TWO = 2;

  /**
   * The Solution instance that will be tested.
   */
  private Solution solution;

  /**
   * This method sets up the testing environment before each test. It initializes a new Solution
   * instance.
   */
  @BeforeEach
  void setUp() {
    solution = Solution.builder().build();
  }

  /**
   * This test checks if the isCorrect method returns false when the score is not set.
   */
  @Test
  void givenSolution_whenCheckedIsCorrect_thenFalse() {
    assertFalse(solution.isCorrect());
  }

  /**
   * This test checks if the isCorrect method returns false when the score is zero.
   */
  @Test
  void givenSolutionWithScoreZero_whenCheckedIsCorrect_thenFalse() {
    solution.setScore(SCORE_ZERO);
    assertFalse(solution.isCorrect());
  }

  /**
   * This test checks if the isCorrect method returns true when the score is one.
   */
  @Test
  void givenSolutionWithScoreOne_whenCheckedIsCorrect_thenTrue() {
    solution.setScore(SCORE_ONE);
    assertTrue(solution.isCorrect());
  }

  /**
   * This test checks if the isCorrect method returns true when the score is more than one.
   */
  @Test
  void givenSolutionWithScoreMoreThanOne_whenCheckedIsCorrect_thenTrue() {
    solution.setScore(SCORE_TWO);
    assertTrue(solution.isCorrect());
  }
}
