import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.entities.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The SolutionRequestTest class contains unit tests for the SolutionRequest class. It tests the
 * conversion of a SolutionRequest to a Solution entity.
 */
class SolutionRequestTest {

  public static final int INTERNAL_SERVER_ERROR = 500;

  /**
   * The SolutionRequest object that will be used in the tests.
   */
  private SolutionRequest solutionRequest;

  /**
   * This method is executed before each test. It initializes the SolutionRequest object.
   */
  @BeforeEach
  void setUp() {
    solutionRequest = new SolutionRequest();
  }

  /**
   * This test checks the conversion of a SolutionRequest to a Solution entity when the solution is
   * not null. It sets the solution and score of the SolutionRequest, converts it to a Solution
   * entity, and asserts that the solution and score of the Solution entity are the same as those
   * set in the SolutionRequest.
   */
  @Test
  @DisplayName("Should convert to entity when solution is not null")
  void shouldConvertToEntityWhenSolutionIsNotNull() {
    solutionRequest.setSolution("Test Solution");
    solutionRequest.setScore(10);

    Solution solution = solutionRequest.toEntity();

    assertEquals("Test Solution", solution.getSolution());
    assertEquals(10, solution.getScore());
  }

  /**
   * This test checks the conversion of a SolutionRequest to a Solution entity when the solution is
   * null. It sets the solution of the SolutionRequest to null, tries to convert it to a Solution
   * entity, and asserts that a ResponseStatusException is thrown with a 500 status code and a
   * specific error message.
   */
  @Test
  @DisplayName("Should throw exception when solution is null")
  void shouldThrowExceptionWhenSolutionIsNull() {
    solutionRequest.setSolution(null);
    solutionRequest.setScore(10);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        solutionRequest::toEntity);

    assertEquals(HttpStatusCode.valueOf(INTERNAL_SERVER_ERROR), exception.getStatusCode());
    assertEquals("[Solution] Solution cannot be null", exception.getReason());
  }
}
