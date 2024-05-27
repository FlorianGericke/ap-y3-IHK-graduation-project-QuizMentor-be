package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.SolutionMapper;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the SolutionService class.
 */
class SolutionServiceTest {

  private static final int EXISTING_SCORE = 10;
  private static final int NEW_SCORE = 20;

  @Mock
  private SolutionRepository solutionRepository; // Mock of SolutionRepository

  @Mock
  private SolutionMapper solutionMapper; // Mock of SolutionMapper

  @InjectMocks
  private SolutionService solutionService; // The service under test

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize the mocks
  }

  /**
   * This test verifies that the patch method of the SolutionService correctly updates the solution
   * fields when new values are provided in the request.
   */
  @Test
  void patchShouldUpdateSolutionFieldsWhenNewValuesAreProvided() {
    Solution existingSolution = new Solution();
    existingSolution.setSolution("Old Solution");
    existingSolution.setScore(EXISTING_SCORE);

    SolutionRequest solutionRequest = new SolutionRequest();
    solutionRequest.setSolution("New Solution");
    solutionRequest.setScore(NEW_SCORE);

    Solution updatedSolution = solutionService.patch(existingSolution, solutionRequest);

    assertEquals("New Solution",
        updatedSolution.getSolution()); // Assert that the solution has been updated
    assertEquals(NEW_SCORE, updatedSolution.getScore()); // Assert that the score has been updated
  }

  /**
   * This test verifies that the patch method of the SolutionService keeps the existing solution
   * fields when no new values are provided in the request.
   */
  @Test
  void patchShouldKeepExistingSolutionFieldsWhenNoNewValuesAreProvided() {
    Solution existingSolution = new Solution();
    existingSolution.setSolution("Existing Solution");
    existingSolution.setScore(EXISTING_SCORE);

    SolutionRequest solutionRequest = new SolutionRequest();

    Solution updatedSolution = solutionService.patch(existingSolution, solutionRequest);

    assertEquals("Existing Solution",
        updatedSolution.getSolution()); // Assert that the solution has not been updated
    assertEquals(EXISTING_SCORE,
        updatedSolution.getScore()); // Assert that the score has not been updated
  }
}
