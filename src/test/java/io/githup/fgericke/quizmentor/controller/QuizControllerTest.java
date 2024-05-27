package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.QuizMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.service.QuizService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class contains unit tests for the QuizController class. It uses Mockito for mocking
 * dependencies and JUnit 5 (Jupiter) for assertions and test management.
 */
public class QuizControllerTest {

  @Mock
  private QuizService service;

  @Mock
  private QuizMapper mapper;

  @Mock
  private QuizRequest requestDto;

  @Mock
  private Pageable pageable;

  private QuizController controller;

  /**
   * This method sets up the test environment before each test. It initializes the mocks and the
   * object under test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new QuizController(mapper, service);
  }

  /**
   * This test checks the postEntity method of the QuizController. It verifies that a new Quiz is
   * created when the method is called.
   */
  @Test
  public void postQuiz_createsNewQuiz() {
    when(service.post(requestDto)).thenReturn(new Quiz());
    when(mapper.toDto(any())).thenReturn(new QuizResponse());

    QuizResponse response = controller.postEntity(requestDto);

    assertNotNull(response);
    verify(service, times(1)).post(requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntities method of the QuizController. It verifies that all Quizzes are
   * retrieved when the method is called.
   */
  @Test
  @Disabled
  public void getQuizzes_retrievesAllQuizzes() {
    when(service.getAll(pageable)).thenReturn(Page.empty());
    when(mapper.toDto(any())).thenReturn(new QuizResponse());

    Page<QuizResponse> responses = controller.getEntities(pageable);

    assertNotNull(responses);
    verify(service, times(1)).getAll(pageable);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntity method of the QuizController. It verifies that a specific Quiz
   * is retrieved when the method is called with an id.
   */
  @Test
  public void getQuiz_retrievesSpecificQuiz() {
    UUID id = UUID.randomUUID();
    when(service.get(id)).thenReturn(new Quiz());
    when(mapper.toDto(any())).thenReturn(new QuizResponse());

    QuizResponse response = controller.getEntity(id);

    assertNotNull(response);
    verify(service, times(1)).get(id);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the putEntity method of the QuizController. It verifies that a specific Quiz
   * is updated when the method is called with an id and a requestDto.
   */
  @Test
  public void putQuiz_updatesSpecificQuiz() {
    UUID id = UUID.randomUUID();
    when(service.put(id, requestDto)).thenReturn(new Quiz());
    when(mapper.toDto(any())).thenReturn(new QuizResponse());

    QuizResponse response = controller.putEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).put(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the patchEntity method of the QuizController. It verifies that a specific Quiz
   * is partially updated when the method is called with an id and a requestDto.
   */
  @Test
  public void patchQuiz_updatesSpecificQuizPartially() {
    UUID id = UUID.randomUUID();
    when(service.patch(id, requestDto)).thenReturn(new Quiz());
    when(mapper.toDto(any())).thenReturn(new QuizResponse());

    QuizResponse response = controller.patchEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).patch(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the deleteEntity method of the QuizController. It verifies that a specific
   * Quiz is deleted when the method is called with an id.
   */
  @Test
  public void deleteQuiz_deletesSpecificQuiz() {
    UUID id = UUID.randomUUID();
    when(service.delete(id)).thenReturn(new Quiz());
    when(mapper.toDto(any())).thenReturn(new QuizResponse());

    QuizResponse response = controller.deleteEntity(id);

    assertNotNull(response);
    verify(service, times(1)).delete(id);
    verify(mapper, times(1)).toDto(any());
  }
}
