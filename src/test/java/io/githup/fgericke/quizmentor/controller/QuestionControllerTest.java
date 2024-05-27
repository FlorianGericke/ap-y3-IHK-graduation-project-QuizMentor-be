package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.service.QuestionService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class contains unit tests for the QuestionController class. It uses Mockito for mocking
 * dependencies and JUnit 5 (Jupiter) for assertions and test management.
 */
public class QuestionControllerTest {

  @Mock
  private QuestionService service;

  @Mock
  private QuestionMapper mapper;

  @Mock
  private QuestionRequest requestDto;

  @Mock
  private Pageable pageable;

  private QuestionController controller;

  /**
   * This method sets up the test environment before each test. It initializes the mocks and the
   * object under test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new QuestionController(mapper, service);
  }

  /**
   * This test checks the postEntity method of the QuestionController. It verifies that a new
   * Question is created when the method is called.
   */
  @Test
  public void postQuestion_createsNewQuestion() {
    when(service.post(requestDto)).thenReturn(new Question());
    when(mapper.toDto(any())).thenReturn(new QuestionResponse());

    QuestionResponse response = controller.postEntity(requestDto);

    assertNotNull(response);
    verify(service, times(1)).post(requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntities method of the QuestionController. It verifies that all
   * Questions are retrieved when the method is called.
   */
  @Test
  @Disabled
  public void getQuestions_retrievesAllQuestions() {
    when(service.getAll(pageable)).thenReturn(Page.empty());
    when(mapper.toDto(any())).thenReturn(new QuestionResponse());

    Page<QuestionResponse> responses = controller.getEntities(pageable);

    assertNotNull(responses);
    verify(service, times(1)).getAll(pageable);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntity method of the QuestionController. It verifies that a specific
   * Question is retrieved when the method is called with an id.
   */
  @Test
  public void getQuestion_retrievesSpecificQuestion() {
    UUID id = UUID.randomUUID();
    when(service.get(id)).thenReturn(new Question());
    when(mapper.toDto(any())).thenReturn(new QuestionResponse());

    QuestionResponse response = controller.getEntity(id);

    assertNotNull(response);
    verify(service, times(1)).get(id);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the putEntity method of the QuestionController. It verifies that a specific
   * Question is updated when the method is called with an id and a requestDto.
   */
  @Test
  public void putQuestion_updatesSpecificQuestion() {
    UUID id = UUID.randomUUID();
    when(service.put(id, requestDto)).thenReturn(new Question());
    when(mapper.toDto(any())).thenReturn(new QuestionResponse());

    QuestionResponse response = controller.putEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).put(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the patchEntity method of the QuestionController. It verifies that a specific
   * Question is partially updated when the method is called with an id and a requestDto.
   */
  @Test
  public void patchQuestion_updatesSpecificQuestionPartially() {
    UUID id = UUID.randomUUID();
    when(service.patch(id, requestDto)).thenReturn(new Question());
    when(mapper.toDto(any())).thenReturn(new QuestionResponse());

    QuestionResponse response = controller.patchEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).patch(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the deleteEntity method of the QuestionController. It verifies that a specific
   * Question is deleted when the method is called with an id.
   */
  @Test
  public void deleteQuestion_deletesSpecificQuestion() {
    UUID id = UUID.randomUUID();
    when(service.delete(id)).thenReturn(new Question());
    when(mapper.toDto(any())).thenReturn(new QuestionResponse());

    QuestionResponse response = controller.deleteEntity(id);

    assertNotNull(response);
    verify(service, times(1)).delete(id);
    verify(mapper, times(1)).toDto(any());
  }
}
