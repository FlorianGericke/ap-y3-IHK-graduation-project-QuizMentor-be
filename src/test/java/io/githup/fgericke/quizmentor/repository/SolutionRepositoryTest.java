package io.githup.fgericke.quizmentor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import io.githup.fgericke.quizmentor.entity.Solution;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//ToDo : Create a Test Environment to Test against a test database

@DataJpaTest
public class SolutionRepositoryTest {

  @Autowired
  private SolutionRepository solutionRepository;

  private Solution solution;

  @BeforeEach
  public void setUp() {
    solution = new Solution();
    solution.setId(UUID.randomUUID());
    // Set other properties of the solution as required
  }

  @Test
  @Disabled
  public void shouldSaveSolution() {
    Solution savedSolution = solutionRepository.save(solution);
    assertThat(savedSolution).isNotNull();
    assertThat(savedSolution.getId()).isEqualTo(solution.getId());
  }

  @Test
  @Disabled
  public void shouldFindSolutionById() {
    solutionRepository.save(solution);
    Optional<Solution> foundSolution = solutionRepository.findById(solution.getId());
    assertThat(foundSolution).isPresent();
    assertThat(foundSolution.get().getId()).isEqualTo(solution.getId());
  }

  @Test
  @Disabled
  public void shouldNotFindSolutionByNonExistentId() {
    Optional<Solution> foundSolution = solutionRepository.findById(UUID.randomUUID());
    assertThat(foundSolution).isNotPresent();
  }

  @Test
  @Disabled
  public void shouldDeleteSolutionById() {
    solutionRepository.save(solution);
    solutionRepository.deleteById(solution.getId());
    Optional<Solution> foundSolution = solutionRepository.findById(solution.getId());
    assertThat(foundSolution).isNotPresent();
  }
}
