package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuestionService class. It tests the functionality of
 * updating an existing Question entity with new data provided in a QuestionRequest.
 */
class QuestionServiceTest {

  private static final int EXISTING_SCORE = 10;
  private static final int NEW_SCORE = 20;

  // Mock of QuestionRepository
  @Mock
  private QuestionRepository questionRepository;

  // Mock of QuestionMapper
  @Mock
  private QuestionMapper questionMapper;

  // The service under test
  @InjectMocks
  private QuestionService questionService;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the functionality of updating an existing Question entity when no new values
   * are provided in a QuestionRequest. It verifies that the existing values in the Question entity
   * remain unchanged.
   */
  @DisplayName("Should keep existing Question entity fields when not provided in QuestionRequest")
  @Test
  void patchShouldKeepExistingQuestionFieldsWhenNoNewValuesAreProvided() {
    Question existingQuestion = new Question();
    existingQuestion.setTitle("Existing Title");
    existingQuestion.setDescription("Existing Description");
    existingQuestion.setScore(10);
    existingQuestion.setStatus(Visibility.DRAFT);

    QuestionRequest questionRequest = new QuestionRequest();

    Question updatedQuestion = questionService.patch(existingQuestion, questionRequest);

    assertEquals("Existing Title", updatedQuestion.getTitle());
    assertEquals("Existing Description", updatedQuestion.getDescription());
    assertEquals(10, updatedQuestion.getScore());
    assertEquals(Visibility.DRAFT, updatedQuestion.getStatus());
  }
}
