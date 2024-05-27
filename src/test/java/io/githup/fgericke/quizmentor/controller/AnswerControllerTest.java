package io.githup.fgericke.quizmentor.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.AnswerMapper;
import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.service.AnswerService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class contains unit tests for the AnswerController class. It uses Mockito for mocking
 * dependencies and JUnit 5 (Jupiter) for assertions and test management.
 */
public class AnswerControllerTest {

  @Mock
  private AnswerService service;

  @Mock
  private AnswerMapper mapper;

  @Mock
  private AnswerRequest requestDto;

  @Mock
  private Pageable pageable;

  private AnswerController controller;

  /**
   * This method sets up the test environment before each test. It initializes the mocks and the
   * object under test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new AnswerController(mapper, service);
  }

  /**
   * This test checks the postEntity method of the AnswerController. It verifies that a new Answer
   * is created when the method is called.
   */
  @Test
  public void postAnswer_createsNewAnswer() {
    when(service.post(requestDto)).thenReturn(new Answer());
    when(mapper.toDto(any())).thenReturn(new AnswerResponse());

    AnswerResponse response = controller.postEntity(requestDto);

    assertNotNull(response);
    verify(service, times(1)).post(requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntities method of the AnswerController. It verifies that all Answers
   * are retrieved when the method is called.
   */
  @Test
  @Disabled
  public void getAnswers_retrievesAllAnswers() {
    when(service.getAll(pageable)).thenReturn(Page.empty());
    when(mapper.toDto(any())).thenReturn(new AnswerResponse());

    Page<AnswerResponse> responses = controller.getEntities(pageable);

    assertNotNull(responses);
    verify(service, times(1)).getAll(pageable);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntity method of the AnswerController. It verifies that a specific
   * Answer is retrieved when the method is called with an id.
   */
  @Test
  public void getAnswer_retrievesSpecificAnswer() {
    UUID id = UUID.randomUUID();
    when(service.get(id)).thenReturn(new Answer());
    when(mapper.toDto(any())).thenReturn(new AnswerResponse());

    AnswerResponse response = controller.getEntity(id);

    assertNotNull(response);
    verify(service, times(1)).get(id);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the putEntity method of the AnswerController. It verifies that a specific
   * Answer is updated when the method is called with an id and a requestDto.
   */
  @Test
  public void putAnswer_updatesSpecificAnswer() {
    UUID id = UUID.randomUUID();
    when(service.put(id, requestDto)).thenReturn(new Answer());
    when(mapper.toDto(any())).thenReturn(new AnswerResponse());

    AnswerResponse response = controller.putEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).put(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the patchEntity method of the AnswerController. It verifies that a specific
   * Answer is partially updated when the method is called with an id and a requestDto.
   */
  @Test
  public void patchAnswer_updatesSpecificAnswerPartially() {
    UUID id = UUID.randomUUID();
    when(service.patch(id, requestDto)).thenReturn(new Answer());
    when(mapper.toDto(any())).thenReturn(new AnswerResponse());

    AnswerResponse response = controller.patchEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).patch(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the deleteEntity method of the AnswerController. It verifies that a specific
   * Answer is deleted when the method is called with an id.
   */
  @Test
  public void deleteAnswer_deletesSpecificAnswer() {
    UUID id = UUID.randomUUID();
    when(service.delete(id)).thenReturn(new Answer());
    when(mapper.toDto(any())).thenReturn(new AnswerResponse());

    AnswerResponse response = controller.deleteEntity(id);

    assertNotNull(response);
    verify(service, times(1)).delete(id);
    verify(mapper, times(1)).toDto(any());
  }
}
