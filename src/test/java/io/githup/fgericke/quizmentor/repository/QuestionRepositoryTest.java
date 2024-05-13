package io.githup.fgericke.quizmentor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import io.githup.fgericke.quizmentor.entity.Question;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * This class contains unit tests for the QuestionRepository class. It tests the basic CRUD
 * operations: find by ID and delete by ID. The tests are currently disabled and need a test
 * environment to run against a test database.
 */
@DataJpaTest
public class QuestionRepositoryTest {

  @Autowired
  private QuestionRepository questionRepository;

  private Question question;

  /**
   * This method sets up the test environment before each test. It initializes a new Question, saves
   * it in the repository.
   */
  @BeforeEach
  public void setUp() {
    question = new Question();
    question.setId(UUID.randomUUID());
    question.setTitle("What is the capital of France?");
    questionRepository.save(question);
  }

  /**
   * This test checks the find by ID operation of the QuestionRepository. It verifies that a
   * Question can be found by its ID.
   */
  @Test
  @Disabled
  public void shouldFindQuestionById() {
    Optional<Question> foundQuestion = questionRepository.findById(question.getId());

    assertThat(foundQuestion).isPresent();
    assertThat(foundQuestion.get().getTitle()).isEqualTo(question.getTitle());
  }

  /**
   * This test checks the find by ID operation of the QuestionRepository when the ID does not exist.
   * It verifies that a Question cannot be found by a non-existing ID.
   */
  @Test
  @Disabled
  public void shouldNotFindQuestionByNonExistingId() {
    Optional<Question> foundQuestion = questionRepository.findById(UUID.randomUUID());

    assertThat(foundQuestion).isNotPresent();
  }

  /**
   * This test checks the delete by ID operation of the QuestionRepository. It verifies that a
   * Question can be deleted by its ID.
   */
  @Test
  @Disabled
  public void shouldDeleteQuestionById() {
    questionRepository.deleteById(question.getId());

    Optional<Question> foundQuestion = questionRepository.findById(question.getId());
    assertThat(foundQuestion).isNotPresent();
  }
}
