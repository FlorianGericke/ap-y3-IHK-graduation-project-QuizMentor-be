package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.githup.fgericke.quizmentor.dto.mapper.QuizMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.repository.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the QuizService class.
 */
class QuizServiceTest {

  @Mock
  private QuizRepository quizRepository; // Mock of QuizRepository

  @Mock
  private QuizMapper quizMapper; // Mock of QuizMapper

  @InjectMocks
  private QuizService quizService; // The service under test

  /**
   * This method sets up the test environment before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize the mocks
  }

  /**
   * This test verifies that the patch method of the QuizService correctly updates the quiz fields
   * when new values are provided in the request.
   */
  @Test
  void patchShouldUpdateQuizFieldsWhenNewValuesAreProvided() {
    Quiz existingQuiz = new Quiz();
    existingQuiz.setTitle("Old Title");
    existingQuiz.setDescription("Old Description");
    existingQuiz.setVisibility(Visibility.DRAFT);

    QuizRequest quizRequest = new QuizRequest();
    quizRequest.setTitle("New Title");
    quizRequest.setDescription("New Description");
    quizRequest.setStatus(Visibility.DRAFT);

    Quiz updatedQuiz = quizService.patch(existingQuiz, quizRequest);

    assertEquals("New Title", updatedQuiz.getTitle()); // Assert that the title has been updated
    assertEquals("New Description",
        updatedQuiz.getDescription()); // Assert that the description has been updated
    assertEquals(Visibility.DRAFT,
        updatedQuiz.getVisibility()); // Assert that the visibility has been updated
  }

  /**
   * This test verifies that the patch method of the QuizService keeps the existing quiz fields when
   * no new values are provided in the request.
   */
  @Test
  void patchShouldKeepExistingQuizFieldsWhenNoNewValuesAreProvided() {
    Quiz existingQuiz = new Quiz();
    existingQuiz.setTitle("Existing Title");
    existingQuiz.setDescription("Existing Description");
    existingQuiz.setVisibility(Visibility.DRAFT);

    QuizRequest quizRequest = new QuizRequest();

    Quiz updatedQuiz = quizService.patch(existingQuiz, quizRequest);

    assertEquals("Existing Title",
        updatedQuiz.getTitle()); // Assert that the title has not been updated
    assertEquals("Existing Description",
        updatedQuiz.getDescription()); // Assert that the description has not been updated
    assertEquals(Visibility.DRAFT,
        updatedQuiz.getVisibility()); // Assert that the visibility has not been updated
  }
}
