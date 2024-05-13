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

//ToDo : Create a Test Environment to Test against a test database

@DataJpaTest
public class AnswerRepositoryTest {

  @Autowired
  private AnswerRepository answerRepository;

  private UUID id;
  private Answer answer;

  @BeforeEach
  public void setUp() {
    answer = new Answer();
    answer.setAnswer("Test Answer");
    answer = answerRepository.save(answer);
    id = answer.getId();
  }

  @Test
  @Disabled
  public void shouldFindAnswerById() {
    Optional<Answer> foundAnswer = answerRepository.findById(id);
    assertThat(foundAnswer).isPresent();
    assertThat(foundAnswer.get().getAnswer()).isEqualTo(answer.getAnswer());
  }

  @Test
  @Disabled
  public void shouldNotFindAnswerByNonExistingId() {
    Optional<Answer> foundAnswer = answerRepository.findById(UUID.randomUUID());
    assertThat(foundAnswer).isNotPresent();
  }

  @Test
  @Disabled
  public void shouldDeleteAnswerById() {
    answerRepository.deleteById(id);
    Optional<Answer> foundAnswer = answerRepository.findById(id);
    assertThat(foundAnswer).isNotPresent();
  }
}
