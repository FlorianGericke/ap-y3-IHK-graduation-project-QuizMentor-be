package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.QuizMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.repository.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuizService class. It tests the functionality of updating
 * an existing Quiz entity with new data provided in a QuizRequest.
 */
class QuizServiceTest {

  // Mock of QuizRepository
  @Mock
  private QuizRepository quizRepository;

  // Mock of QuizMapper
  @Mock
  private QuizMapper quizMapper;

  // The service under test
  @InjectMocks
  private QuizService quizService;

  /**
   * This method sets up the test environment before each test. It initializes the mocks.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the functionality of updating an existing Quiz entity with new values provided
   * in a QuizRequest. It verifies that the updated Quiz entity has the new values.
   */
  @DisplayName("Should update Quiz entity fields when provided in QuizRequest")
  @Test
  void patchShouldUpdateQuizFieldsWhenNewValuesAreProvided() {
    Quiz existingQuiz = new Quiz();
    existingQuiz.setTitle("Old Title");
    existingQuiz.setDescription("Old Description");
    existingQuiz.setVisibility(Visibility.DRAFT);

    QuizRequest quizRequest = new QuizRequest();
    quizRequest.setTitle("New Title");
    quizRequest.setDescription("New Description");
    quizRequest.setVisibility(Visibility.PUBLISHED);

    Quiz updatedQuiz = quizService.patch(existingQuiz, quizRequest);

    assertEquals("New Title", updatedQuiz.getTitle());
    assertEquals("New Description", updatedQuiz.getDescription());
    assertEquals(Visibility.PUBLISHED, updatedQuiz.getVisibility());
  }

  /**
   * This test checks the functionality of updating an existing Quiz entity when no new values are
   * provided in a QuizRequest. It verifies that the existing values in the Quiz entity remain
   * unchanged.
   */
  @DisplayName("Should keep existing Quiz entity fields when not provided in QuizRequest")
  @Test
  void patchShouldKeepExistingQuizFieldsWhenNoNewValuesAreProvided() {
    Quiz existingQuiz = new Quiz();
    existingQuiz.setTitle("Existing Title");
    existingQuiz.setDescription("Existing Description");
    existingQuiz.setVisibility(Visibility.DRAFT);

    QuizRequest quizRequest = new QuizRequest();

    Quiz updatedQuiz = quizService.patch(existingQuiz, quizRequest);

    assertEquals("Existing Title", updatedQuiz.getTitle());
    assertEquals("Existing Description", updatedQuiz.getDescription());
    assertEquals(Visibility.DRAFT, updatedQuiz.getVisibility());
  }
}
