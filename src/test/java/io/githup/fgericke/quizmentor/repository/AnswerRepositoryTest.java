package io.githup.fgericke.quizmentor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import io.githup.fgericke.quizmentor.entity.Answer;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * This class contains unit tests for the AnswerRepository class. It tests the basic CRUD
 * operations: find by ID and delete by ID. The tests are currently disabled and need a test
 * environment to run against a test database.
 */
@Disabled
@DataJpaTest
public class AnswerRepositoryTest {

  @Autowired
  private AnswerRepository answerRepository;

  private UUID id;
  private Answer answer;

  /**
   * This method sets up the test environment before each test. It initializes a new Answer, saves
   * it in the repository, and stores its ID for later use.
   */
  @BeforeEach
  public void setUp() {
    answer = new Answer();
    answer.setAnswer("Test Answer");
    answer = answerRepository.save(answer);
    id = answer.getId();
  }

  /**
   * This test checks the find by ID operation of the AnswerRepository. It verifies that an Answer
   * can be found by its ID.
   */
  @Test
  @Disabled
  public void shouldFindAnswerById() {
    Optional<Answer> foundAnswer = answerRepository.findById(id);
    assertThat(foundAnswer).isPresent();
    assertThat(foundAnswer.get().getAnswer()).isEqualTo(answer.getAnswer());
  }

  /**
   * This test checks the find by ID operation of the AnswerRepository when the ID does not exist.
   * It verifies that an Answer cannot be found by a non-existing ID.
   */
  @Test
  @Disabled
  public void shouldNotFindAnswerByNonExistingId() {
    Optional<Answer> foundAnswer = answerRepository.findById(UUID.randomUUID());
    assertThat(foundAnswer).isNotPresent();
  }

  /**
   * This test checks the delete by ID operation of the AnswerRepository. It verifies that an Answer
   * can be deleted by its ID.
   */
  @Test
  @Disabled
  public void shouldDeleteAnswerById() {
    answerRepository.deleteById(id);
    Optional<Answer> foundAnswer = answerRepository.findById(id);
    assertThat(foundAnswer).isNotPresent();
  }
}
