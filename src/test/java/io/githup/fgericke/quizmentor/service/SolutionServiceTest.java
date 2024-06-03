package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.SolutionMapper;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
   * This method tests the patch method of the SolutionService class.
   */
  @DisplayName("Should update Solution entity fields when provided in SolutionRequest")
  @Test
  void patchShouldUpdateSolutionFieldsWhenNewValuesAreProvided() {
    Solution existingSolution = new Solution();
    existingSolution.setSolution("Old Solution");
    existingSolution.setScore(EXISTING_SCORE);

    SolutionRequest solutionRequest = new SolutionRequest();
    solutionRequest.setSolution("New Solution");
    solutionRequest.setScore(NEW_SCORE);

    Solution updatedSolution = solutionService.patch(existingSolution, solutionRequest);

    assertEquals("New Solution", updatedSolution.getSolution());
    assertEquals(NEW_SCORE, updatedSolution.getScore());
  }

  @DisplayName("Should keep existing Solution entity fields when not "
      + "provided in SolutionRequest")
  @Test
  void patchShouldKeepExistingSolutionFieldsWhenNoNewValuesAreProvided() {
    Solution existingSolution = new Solution();
    existingSolution.setSolution("Existing Solution");
    existingSolution.setScore(EXISTING_SCORE);

    SolutionRequest solutionRequest = new SolutionRequest();

    Solution updatedSolution = solutionService.patch(existingSolution, solutionRequest);

    assertEquals("Existing Solution", updatedSolution.getSolution());
    assertEquals(EXISTING_SCORE, updatedSolution.getScore());
  }
}
