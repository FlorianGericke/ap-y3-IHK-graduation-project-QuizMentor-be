package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class QuestionServiceTest {

  @Mock
  private QuestionRepository questionRepository;

  @Mock
  private QuestionRequest questionRequest;

  @InjectMocks
  private QuestionService questionService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @Disabled
  void patchShouldUpdateNonNullFields() {
    Question question = new Question();
    questionRequest.setTitle("New Title");
    questionRequest.setDescription("New Description");

    when(questionRepository.save(any(Question.class))).thenAnswer(i -> i.getArguments()[0]);

    Question updatedQuestion = questionService.patch(question, questionRequest);

    assertEquals("New Title", updatedQuestion.getTitle());
    assertEquals("New Description", updatedQuestion.getDescription());
  }

  @Test
  @Disabled
  void patchShouldNotUpdateNullFields() {
    Question question = new Question();
    question.setTitle("Old Title");
    question.setDescription("Old Description");

    when(questionRepository.save(any(Question.class))).thenAnswer(i -> i.getArguments()[0]);

    Question updatedQuestion = questionService.patch(question, questionRequest);

    assertEquals("Old Title", updatedQuestion.getTitle());
    assertEquals("Old Description", updatedQuestion.getDescription());
  }
}
