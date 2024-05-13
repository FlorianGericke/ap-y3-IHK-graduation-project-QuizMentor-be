package io.githup.fgericke.quizmentor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import io.githup.fgericke.quizmentor.entity.Quiz;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * This class contains unit tests for the QuizRepository class. It tests the basic CRUD operations:
 * save, find by ID, and delete by ID. The tests are currently disabled and need a test environment
 * to run against a test database.
 */
@DataJpaTest
public class QuizRepositoryTest {

  @Autowired
  private QuizRepository quizRepository;

  private Quiz quiz;

  /**
   * This method sets up the test environment before each test. It initializes a new Quiz and sets
   * its ID.
   */
  @BeforeEach
  public void setUp() {
    quiz = new Quiz();
    quiz.setId(UUID.randomUUID());
    // Set other necessary fields for the Quiz object
  }

  /**
   * This test checks the save operation of the QuizRepository. It verifies that a Quiz can be saved
   * and retrieved with the same ID.
   */
  @Test
  @Disabled
  public void shouldSaveQuiz() {
    Quiz savedQuiz = quizRepository.save(quiz);
    assertThat(savedQuiz).isNotNull();
    assertThat(savedQuiz.getId()).isEqualTo(quiz.getId());
  }

  /**
   * This test checks the find by ID operation of the QuizRepository. It verifies that a Quiz can be
   * found by its ID.
   */
  @Test
  @Disabled
  public void shouldFindQuizById() {
    quizRepository.save(quiz);
    Quiz foundQuiz = quizRepository.findById(quiz.getId()).orElse(null);
    assertThat(foundQuiz).isNotNull();
    assertThat(foundQuiz.getId()).isEqualTo(quiz.getId());
  }

  /**
   * This test checks the find by ID operation of the QuizRepository when the ID does not exist. It
   * verifies that a Quiz cannot be found by a non-existing ID.
   */
  @Test
  @Disabled
  public void shouldNotFindQuizByNonExistentId() {
    Quiz foundQuiz = quizRepository.findById(UUID.randomUUID()).orElse(null);
    assertThat(foundQuiz).isNull();
  }

  /**
   * This test checks the delete by ID operation of the QuizRepository. It verifies that a Quiz can
   * be deleted by its ID.
   */
  @Test
  @Disabled
  public void shouldDeleteQuizById() {
    quizRepository.save(quiz);
    quizRepository.deleteById(quiz.getId());
    Quiz foundQuiz = quizRepository.findById(quiz.getId()).orElse(null);
    assertThat(foundQuiz).isNull();
  }
}
