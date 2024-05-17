package io.githup.fgericke.quizmentor.dto.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * This class contains unit tests for the QuestionRequest class. It tests the conversion of a
 * QuestionRequest to a Question entity.
 */
class QuestionRequestTest {

  private static final String TEST_QUESTION = "Test Question";
  private static final String TEST_DESCRIPTION = "Test Description";
  private static final Visibility TEST_VISIBILITY = Visibility.PUBLISHED;
  private static final int TEST_SCORE = 10;
  private static final String EXCEPTION_REASON = "[Question] Title,Categories cannot be null";
  private static final HttpStatus EXCEPTION_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;


  private QuestionRequest questionRequest;
  private CategoryRepository categoryRepository;

  /**
   * This method sets up the test environment before each test. It initializes a mock
   * CategoryRepository and a new QuestionRequest.
   */
  @BeforeEach
  void setUp() {
    categoryRepository = mock(CategoryRepository.class);
    questionRequest = new QuestionRequest(categoryRepository);
  }

  /**
   * This test checks the conversion of a QuestionRequest to a Question entity when the title and
   * categories are not null. It verifies that the converted Question has the same properties as the
   * QuestionRequest.
   */
  @Test
  @DisplayName("Should convert to entity when title and categories are not null")
  void shouldConvertToEntityWhenTitleAndCategoriesAreNotNull() {
    questionRequest.setTitle(TEST_QUESTION);
    questionRequest.setDescription(TEST_DESCRIPTION);
    questionRequest.setStatus(TEST_VISIBILITY);
    questionRequest.setScore(TEST_SCORE);
    questionRequest.setCategories(List.of(UUID.randomUUID()));

    when(categoryRepository.findAllById(questionRequest.getCategories())).thenReturn(
        List.of());

    Question question = questionRequest.toEntity();

    assertEquals(TEST_QUESTION, question.getTitle());
    assertEquals(TEST_DESCRIPTION, question.getDescription());
    assertEquals(Visibility.PUBLISHED, question.getStatus());
    assertEquals(TEST_SCORE, question.getScore());
  }

  /**
   * This test checks the conversion of a QuestionRequest to a Question entity when the title is
   * null. It verifies that a ResponseStatusException is thrown with the correct status code and
   * reason.
   */
  @Test
  @DisplayName("Should throw exception when title is null")
  void shouldThrowExceptionWhenTitleIsNull() {
    questionRequest.setTitle(null);
    questionRequest.setDescription(TEST_DESCRIPTION);
    questionRequest.setStatus(TEST_VISIBILITY);
    questionRequest.setScore(TEST_SCORE);
    questionRequest.setCategories(List.of(UUID.randomUUID()));

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        questionRequest::toEntity);

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }

  /**
   * This test checks the conversion of a QuestionRequest to a Question entity when the categories
   * are null. It verifies that a ResponseStatusException is thrown with the correct status code and
   * reason.
   */
  @Test
  @DisplayName("Should throw exception when categories are null")
  void shouldThrowExceptionWhenCategoriesAreNull() {
    questionRequest.setTitle(TEST_QUESTION);
    questionRequest.setDescription(TEST_DESCRIPTION);
    questionRequest.setStatus(TEST_VISIBILITY);
    questionRequest.setScore(TEST_SCORE);
    questionRequest.setCategories(null);

    ResponseStatusException exception = assertThrows(ResponseStatusException.class,
        questionRequest::toEntity);

    assertEquals(EXCEPTION_STATUS, exception.getStatusCode());
    assertEquals(EXCEPTION_REASON, exception.getReason());
  }
}
