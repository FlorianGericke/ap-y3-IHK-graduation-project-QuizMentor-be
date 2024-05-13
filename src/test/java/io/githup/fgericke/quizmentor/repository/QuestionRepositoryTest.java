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

//ToDo : Create a Test Environment to Test against a test database

@DataJpaTest
public class QuestionRepositoryTest {

  @Autowired
  private QuestionRepository questionRepository;

  private Question question;

  @BeforeEach
  public void setUp() {
    question = new Question();
    question.setId(UUID.randomUUID());
    question.setTitle("What is the capital of France?");
    questionRepository.save(question);
  }

  @Test
  @Disabled
  public void shouldFindQuestionById() {
    Optional<Question> foundQuestion = questionRepository.findById(question.getId());

    assertThat(foundQuestion).isPresent();
    assertThat(foundQuestion.get().getTitle()).isEqualTo(question.getTitle());
  }

  @Test
  @Disabled
  public void shouldNotFindQuestionByNonExistingId() {
    Optional<Question> foundQuestion = questionRepository.findById(UUID.randomUUID());

    assertThat(foundQuestion).isNotPresent();
  }

  @Test
  @Disabled
  public void shouldDeleteQuestionById() {
    questionRepository.deleteById(question.getId());

    Optional<Question> foundQuestion = questionRepository.findById(question.getId());
    assertThat(foundQuestion).isNotPresent();
  }
}
