package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SolutionServiceTest {

  private static final int NEW_SCORE = 10;
  private static final int OLD_SCORE = 5;

  @Mock
  private SolutionRepository solutionRepository;

  @Mock
  private SolutionRequest solutionRequest;

  @InjectMocks
  private SolutionService solutionService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @Disabled
  void patchShouldUpdateNonNullFields() {
    Solution solution = new Solution();
    solutionRequest.setSolution("New Solution");
    solutionRequest.setScore(NEW_SCORE);

    when(solutionRepository.save(any(Solution.class))).thenAnswer(i -> i.getArguments()[0]);

    Solution updatedSolution = solutionService.patch(solution, solutionRequest);

    assertEquals("New Solution", updatedSolution.getSolution());
    assertEquals(NEW_SCORE, updatedSolution.getScore());
  }

  @Test
  void patchShouldNotUpdateNullFields() {
    Solution solution = new Solution();
    solution.setSolution("Old Solution");
    solution.setScore(OLD_SCORE);

    when(solutionRepository.save(any(Solution.class))).thenAnswer(i -> i.getArguments()[0]);

    Solution updatedSolution = solutionService.patch(solution, solutionRequest);

    assertEquals("Old Solution", updatedSolution.getSolution());
    assertEquals(OLD_SCORE, updatedSolution.getScore());
  }
}
