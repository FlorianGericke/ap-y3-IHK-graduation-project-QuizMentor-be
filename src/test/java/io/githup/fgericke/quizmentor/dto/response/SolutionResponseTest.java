import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.entity.User;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the SolutionResponse class.
 */
class SolutionResponseTest {

  private static final int TEST_SCORE = 10;

  private SolutionResponse solutionResponse;
  private Solution solution;

  @Mock
  private Question question;

  @Mock
  private User owner;

  /**
   * This method sets up the test environment before each test. It initializes a new Solution and
   * SolutionResponse object.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    solution = new Solution();
    solutionResponse = new SolutionResponse();
  }

  /**
   * This test checks if a null Solution is correctly mapped to a null SolutionResponse. It maps a
   * null Solution to a SolutionResponse and then asserts that the SolutionResponse is null.
   */
  @DisplayName("Mapping null Solution results in null")
  @Test
  void mapNullSolutionResultsInNull() {
    assertNull(solutionResponse.map(null));
  }

  /**
   * This test checks if a Solution with null fields is correctly mapped to a SolutionResponse with
   * null fields. It maps a Solution with null fields to a SolutionResponse and then asserts that
   * all fields of the SolutionResponse are null.
   */
  @DisplayName("Mapping Solution with null fields results in corresponding SolutionResponse")
  @Test
  void mapSolutionWithNullFieldsResultsInCorrespondingSolutionResponse() {
    SolutionResponse result = solutionResponse.map(solution);
    assertNull(result.getId());
    assertNull(result.getIri());
    assertNull(result.getQuestionIri());
    assertNull(result.getOwnerIri());
    assertNull(result.getSolution());
  }

  /**
   * This test checks if a Solution with non-null fields is correctly mapped to a corresponding
   * SolutionResponse. It sets the fields of the Solution, maps the Solution to a SolutionResponse,
   * and then asserts that the fields of the SolutionResponse are the same as the fields of the
   * Solution.
   */
  @DisplayName("Mapping Solution with non-null fields results in corresponding SolutionResponse")
  @Test
  void mapSolutionWithNonNullFieldsResultsInCorrespondingSolutionResponse() {
    UUID id = UUID.randomUUID();
    solution.setId(id);
    solution.setQuestion(question);
    solution.setCreatedFrom(owner);
    solution.setScore(TEST_SCORE);
    solution.setSolution("Solution");

    SolutionResponse result = solutionResponse.map(solution);
    assertEquals(id, result.getId());
    assertEquals(TEST_SCORE, result.getScore());
    assertEquals("Solution", result.getSolution());
  }
}
