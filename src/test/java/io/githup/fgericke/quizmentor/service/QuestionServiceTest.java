package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * This class contains unit tests for the QuestionService class.
 */
class QuestionServiceTest {

  private static final int EXISTING_SCORE = 10;
  private static final int NEW_SCORE = 20;

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

  /**
   * This test verifies that a new question is created with the authenticated user as the creator.
   * It mocks the authentication context to return a specific username. Then, it creates a
   * QuestionRequest and sets the expected fields. It also creates an expected Question entity with
   * the same fields as the request and the creator set to the authenticated user. The mapper and
   * repository are mocked to return the expected Question entity. Finally, it calls the post method
   * of the QuestionService with the request and asserts that the returned Question entity is the
   * same as the expected one. It also verifies that the save method of the repository was called
   * with the expected Question entity.
   */
  @DisplayName("Should create a new question with the authenticated user as the creator")
  @Test
  @Disabled
  void shouldCreateNewQuestionWithAuthenticatedUserAsCreator() {
    when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn("User1");

    QuestionRequest request = new QuestionRequest();
    request.setTitle("Question");
    request.setDescription("Description");
    request.setScore(10);
    request.setStatus(Visibility.PUBLISHED);

    Question expectedQuestion = new Question();
    expectedQuestion.setTitle("Question");
    expectedQuestion.setDescription("Description");
    expectedQuestion.setScore(10);
    expectedQuestion.setStatus(Visibility.PUBLISHED);
    expectedQuestion.setCreatedFrom(User.builder().build());

    when(questionMapper.toEntity(request)).thenReturn(expectedQuestion);
    when(questionRepository.save(expectedQuestion)).thenReturn(expectedQuestion);

    Question actualQuestion = questionService.post(request);

    assertEquals(expectedQuestion, actualQuestion);
    verify(questionRepository).save(expectedQuestion);
  }

  /**
   * This test verifies that an exception is thrown when the authenticated user is not found. It
   * mocks the authentication context to return null. Then, it creates a QuestionRequest and sets
   * the expected fields. Finally, it calls the post method of the QuestionService with the request
   * and asserts that a UsernameNotFoundException is thrown.
   */
  @DisplayName("Should throw an exception when the authenticated user is not found")
  @Test
  @Disabled
  void shouldThrowExceptionWhenAuthenticatedUserNotFound() {
    when(SecurityContextHolder.getContext().getAuthentication().getName()).thenReturn(null);

    QuestionRequest request = new QuestionRequest();
    request.setTitle("Question");
    request.setDescription("Description");
    request.setScore(10);
    request.setStatus(Visibility.PUBLISHED);

    assertThrows(UsernameNotFoundException.class, () -> questionService.post(request));
  }
}
