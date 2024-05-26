package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.mapper.UserMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.dto.response.UserResponse;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.service.UserService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This class contains unit tests for the UserController class. It uses Mockito for mocking
 * dependencies and JUnit 5 (Jupiter) for assertions and test management.
 */
public class UserControllerTest {

  @Mock
  private UserService service;

  @Mock
  private UserMapper mapper;

  @Mock
  private UserRequest requestDto;

  @Mock
  private Pageable pageable;

  private UserController controller;

  /**
   * This method sets up the test environment before each test. It initializes the mocks and the
   * object under test.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    controller = new UserController(mapper, service);
  }

  /**
   * This test checks the postEntity method of the UserController. It verifies that a new User is
   * created when the method is called.
   */
  @Test
  public void postUser_createsNewUser() {
    when(service.post(requestDto)).thenReturn(new User());
    when(mapper.toDto(any())).thenReturn(new UserResponse());

    UserResponse response = controller.postEntity(requestDto);

    assertNotNull(response);
    verify(service, times(1)).post(requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntities method of the UserController. It verifies that all Users are
   * retrieved when the method is called.
   */
  @Test
  @Disabled
  public void getUsers_retrievesAllUsers() {
    when(service.getAll(pageable)).thenReturn(Page.empty());
    when(mapper.toDto(any())).thenReturn(new UserResponse());

    Page<UserResponse> responses = controller.getEntities(pageable);

    assertNotNull(responses);
    verify(service, times(1)).getAll(pageable);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the getEntity method of the UserController. It verifies that a specific User
   * is retrieved when the method is called with an id.
   */
  @Test
  public void getUser_retrievesSpecificUser() {
    UUID id = UUID.randomUUID();
    when(service.get(id)).thenReturn(new User());
    when(mapper.toDto(any())).thenReturn(new UserResponse());

    UserResponse response = controller.getEntity(id);

    assertNotNull(response);
    verify(service, times(1)).get(id);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the putEntity method of the UserController. It verifies that a specific User
   * is updated when the method is called with an id and a requestDto.
   */
  @Test
  public void putUser_updatesSpecificUser() {
    UUID id = UUID.randomUUID();
    when(service.put(id, requestDto)).thenReturn(new User());
    when(mapper.toDto(any())).thenReturn(new UserResponse());

    UserResponse response = controller.putEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).put(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the patchEntity method of the UserController. It verifies that a specific User
   * is partially updated when the method is called with an id and a requestDto.
   */
  @Test
  public void patchUser_updatesSpecificUserPartially() {
    UUID id = UUID.randomUUID();
    when(service.patch(id, requestDto)).thenReturn(new User());
    when(mapper.toDto(any())).thenReturn(new UserResponse());

    UserResponse response = controller.patchEntity(id, requestDto);

    assertNotNull(response);
    verify(service, times(1)).patch(id, requestDto);
    verify(mapper, times(1)).toDto(any());
  }

  /**
   * This test checks the deleteEntity method of the UserController. It verifies that a specific
   * User is deleted when the method is called with an id.
   */
  @Test
  public void deleteUser_deletesSpecificUser() {
    UUID id = UUID.randomUUID();
    when(service.delete(id)).thenReturn(new User());
    when(mapper.toDto(any())).thenReturn(new UserResponse());

    UserResponse response = controller.deleteEntity(id);

    assertNotNull(response);
    verify(service, times(1)).delete(id);
    verify(mapper, times(1)).toDto(any());
  }
}
