package io.githup.fgericke.quizmentor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import io.githup.fgericke.quizmentor.entity.Quiz;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//ToDo : Create a Test Environment to Test against a test database

@DataJpaTest
public class QuizRepositoryTest {

  @Autowired
  private QuizRepository quizRepository;

  private Quiz quiz;

  @BeforeEach
  public void setUp() {
    quiz = new Quiz();
    quiz.setId(UUID.randomUUID());
    // Set other necessary fields for the Quiz object
  }

  @Test
  @Disabled
  public void shouldSaveQuiz() {
    Quiz savedQuiz = quizRepository.save(quiz);
    assertThat(savedQuiz).isNotNull();
    assertThat(savedQuiz.getId()).isEqualTo(quiz.getId());
  }

  @Test
  @Disabled
  public void shouldFindQuizById() {
    quizRepository.save(quiz);
    Quiz foundQuiz = quizRepository.findById(quiz.getId()).orElse(null);
    assertThat(foundQuiz).isNotNull();
    assertThat(foundQuiz.getId()).isEqualTo(quiz.getId());
  }

  @Test
  @Disabled
  public void shouldNotFindQuizByNonExistentId() {
    Quiz foundQuiz = quizRepository.findById(UUID.randomUUID()).orElse(null);
    assertThat(foundQuiz).isNull();
  }

  @Test
  @Disabled
  public void shouldDeleteQuizById() {
    quizRepository.save(quiz);
    quizRepository.deleteById(quiz.getId());
    Quiz foundQuiz = quizRepository.findById(quiz.getId()).orElse(null);
    assertThat(foundQuiz).isNull();
  }
}
