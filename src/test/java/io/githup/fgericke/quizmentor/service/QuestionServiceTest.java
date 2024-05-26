package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuestionService class.
 */
class QuestionServiceTest {

  final int EXISTING_SCORE = 10;
  final int NEW_SCORE = 20;

  @Mock
  private QuestionRepository questionRepository; // Mock of QuestionRepository

  @Mock
  private QuestionMapper questionMapper; // Mock of QuestionMapper

  @InjectMocks
  private QuestionService questionService; // The service under test

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize the mocks
  }

  /**
   * This test verifies that the patch method of the QuestionService correctly updates the question
   * fields when new values are provided in the request.
   */
  @Test
  @Disabled
  void patchShouldUpdateQuestionFieldsWhenNewValuesAreProvided() {
    Question existingQuestion = new Question();
    existingQuestion.setTitle("Old Title");
    existingQuestion.setDescription("Old Description");
    existingQuestion.setScore(EXISTING_SCORE);
    existingQuestion.setStatus(Visibility.DRAFT);

    QuestionRequest questionRequest = new QuestionRequest();
    questionRequest.setTitle("New Title");
    questionRequest.setDescription("New Description");
    questionRequest.setScore(NEW_SCORE);
    questionRequest.setStatus(Visibility.PUBLISHED);

    Question updatedQuestion = questionService.patch(existingQuestion, questionRequest);

    assertEquals("New Title", updatedQuestion.getTitle()); // Assert that the title has been updated
    assertEquals("New Description",
        updatedQuestion.getDescription()); // Assert that the description has been updated
    assertEquals(NEW_SCORE, updatedQuestion.getScore()); // Assert that the score has been updated
    assertEquals("New Status",
        updatedQuestion.getStatus()); // Assert that the status has been updated
  }

  /**
   * This test verifies that the patch method of the QuestionService keeps the existing question
   * fields when no new values are provided in the request.
   */
  @Test
  @Disabled
  void patchShouldKeepExistingQuestionFieldsWhenNoNewValuesAreProvided() {
    Question existingQuestion = new Question();
    existingQuestion.setTitle("Existing Title");
    existingQuestion.setDescription("Existing Description");
    existingQuestion.setScore(EXISTING_SCORE);
    existingQuestion.setStatus(Visibility.DRAFT);

    QuestionRequest questionRequest = new QuestionRequest();

    Question updatedQuestion = questionService.patch(existingQuestion, questionRequest);

    assertEquals("Existing Title",
        updatedQuestion.getTitle()); // Assert that the title has not been updated
    assertEquals("Existing Description",
        updatedQuestion.getDescription()); // Assert that the description has not been updated
    assertEquals(EXISTING_SCORE,
        updatedQuestion.getScore()); // Assert that the score has not been updated
    assertEquals("Existing Status",
        updatedQuestion.getStatus()); // Assert that the status has not been updated
  }
}
