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

/**
 * This class contains unit tests for the SolutionRepository class. It tests the basic CRUD
 * operations: save, find by ID, and delete by ID. The tests are currently disabled and need a test
 * environment to run against a test database.
 */
@DataJpaTest
public class SolutionRepositoryTest {

  @Autowired
  private SolutionRepository solutionRepository;

  private Solution solution;

  /**
   * This method sets up the test environment before each test. It initializes a new Solution and
   * sets its ID.
   */
  @BeforeEach
  public void setUp() {
    solution = new Solution();
    solution.setId(UUID.randomUUID());
    // Set other properties of the solution as required
  }

  /**
   * This test checks the save operation of the SolutionRepository. It verifies that a Solution can
   * be saved and retrieved with the same ID.
   */
  @Test
  @Disabled
  public void shouldSaveSolution() {
    Solution savedSolution = solutionRepository.save(solution);
    assertThat(savedSolution).isNotNull();
    assertThat(savedSolution.getId()).isEqualTo(solution.getId());
  }

  /**
   * This test checks the find by ID operation of the SolutionRepository. It verifies that a
   * Solution can be found by its ID.
   */
  @Test
  @Disabled
  public void shouldFindSolutionById() {
    solutionRepository.save(solution);
    Optional<Solution> foundSolution = solutionRepository.findById(solution.getId());
    assertThat(foundSolution).isPresent();
    assertThat(foundSolution.get().getId()).isEqualTo(solution.getId());
  }

  /**
   * This test checks the find by ID operation of the SolutionRepository when the ID does not exist.
   * It verifies that a Solution cannot be found by a non-existing ID.
   */
  @Test
  @Disabled
  public void shouldNotFindSolutionByNonExistentId() {
    Optional<Solution> foundSolution = solutionRepository.findById(UUID.randomUUID());
    assertThat(foundSolution).isNotPresent();
  }

  /**
   * This test checks the delete by ID operation of the SolutionRepository. It verifies that a
   * Solution can be deleted by its ID.
   */
  @Test
  @Disabled
  public void shouldDeleteSolutionById() {
    solutionRepository.save(solution);
    solutionRepository.deleteById(solution.getId());
    Optional<Solution> foundSolution = solutionRepository.findById(solution.getId());
    assertThat(foundSolution).isNotPresent();
  }
}
