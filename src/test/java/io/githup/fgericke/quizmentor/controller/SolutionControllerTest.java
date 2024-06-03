package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.SolutionMapper;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.service.SolutionService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

/**
 * This class contains unit tests for the SolutionController class. It uses Mockito for mocking
 * dependencies and JUnit 5 (Jupiter) for assertions and test management.
 */
public class SolutionControllerTest {

  @Mock
  private SolutionService service;

  @Mock
  private SolutionMapper mapper;

  @Mock
  private SolutionRequest requestDto;

  @Mock
  private Pageable pageable;

  private SolutionController controller;

  /**
   * This method sets up the test environment before each test. It initializes the mocks and the
   * object under test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new SolutionController(mapper, service);
  }

  /**
   * This test checks the postEntity method of the SolutionController. It verifies that a new
   * Solution is created when the method is called.
   */
  @Test
  public void postSolution_createsNewSolution() {
    when(service.post(requestDto)).thenReturn(new Solution());
    when(mapper.toDto(any())).thenReturn(new SolutionResponse());

    SolutionResponse response = controller.postEntity(requestDto);

    assertNotNull(response);
    verify(service, times(1)).post(requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntity method of the SolutionController. It verifies that a specific
   * Solution is retrieved when the method is called with an id.
   */
  @Test
  public void getSolution_retrievesSpecificSolution() {
    UUID id = UUID.randomUUID();
    when(service.get(id)).thenReturn(new Solution());
    when(mapper.toDto(any())).thenReturn(new SolutionResponse());

    SolutionResponse response = controller.getEntity(id);

    assertNotNull(response);
    verify(service, times(1)).get(id);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the putEntity method of the SolutionController. It verifies that a specific
   * Solution is updated when the method is called with an id and a requestDto.
   */
  @Test
  public void putSolution_updatesSpecificSolution() {
    UUID id = UUID.randomUUID();
    when(service.put(id, requestDto)).thenReturn(new Solution());
    when(mapper.toDto(any())).thenReturn(new SolutionResponse());

    SolutionResponse response = controller.putEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).put(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the patchEntity method of the SolutionController. It verifies that a specific
   * Solution is partially updated when the method is called with an id and a requestDto.
   */
  @Test
  public void patchSolution_updatesSpecificSolutionPartially() {
    UUID id = UUID.randomUUID();
    when(service.patch(id, requestDto)).thenReturn(new Solution());
    when(mapper.toDto(any())).thenReturn(new SolutionResponse());

    SolutionResponse response = controller.patchEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).patch(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the deleteEntity method of the SolutionController. It verifies that a specific
   * Solution is deleted when the method is called with an id.
   */
  @Test
  public void deleteSolution_deletesSpecificSolution() {
    UUID id = UUID.randomUUID();
    when(service.delete(id)).thenReturn(new Solution());
    when(mapper.toDto(any())).thenReturn(new SolutionResponse());

    SolutionResponse response = controller.deleteEntity(id);

    assertNotNull(response);
    verify(service, times(1)).delete(id);
    verify(mapper, times(1)).toDto(any());
  }
}
