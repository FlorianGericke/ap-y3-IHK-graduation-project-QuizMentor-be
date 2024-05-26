package io.githup.fgericke.quizmentor.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.dto.response.UserResponse;
import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.AnswerService;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.githup.fgericke.quizmentor.service.SolutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * This class contains unit tests for the UserMapper class. It tests the conversion of UserRequest
 * to User entity and vice versa.
 */
class UserMapperTest {

  // Mocked SolutionService instance
  @Mock
  private SolutionService solutionService;

  // Mocked QuizService instance
  @Mock
  private QuizService quizService;

  // Mocked QuestionService instance
  @Mock
  private QuestionService questionService;

  // Mocked AnswerService instance
  @Mock
  private AnswerService answerService;

  // Injected UserMapper instance
  @InjectMocks
  private UserMapper userMapper;

  /**
   * This method sets up the mocks before each test.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the conversion of UserRequest to User entity. It verifies that the conversion
   * is successful when all required fields are present.
   */
  @DisplayName("Should convert UserRequest to User entity successfully")
  @Test
  void toEntityHappyPath() {
    UserRequest request = new UserRequest();
    request.setMail("mail@example.com");
    request.setPassword("password");
    request.setRole(Role.TRAINER);

    User result = userMapper.toEntity(request);

    assertNotNull(result);
    assertEquals("mail@example.com", result.getMail());
    assertEquals("password", result.getPassword());
    assertEquals(Role.TRAINER, result.getRole());
  }

  /**
   * This test checks the conversion of UserRequest to User entity. It verifies that a
   * MissingMandatoryFieldException is thrown when required fields are missing.
   */
  @DisplayName("Should throw MissingMandatoryFieldException when UserRequest has missing fields")
  @Test
  void toEntityMissingFields() {
    UserRequest request = new UserRequest();

    assertThrows(MissingMandatoryFieldException.class, () -> userMapper.toEntity(request));
  }

  /**
   * This test checks the conversion of User entity to UserResponse. It verifies that the conversion
   * is successful.
   */
  @DisplayName("Should convert User entity to UserResponse successfully")
  @Test
  void toDtoHappyPath() {
    User user = new User();
    user.setMail("mail@example.com");
    user.setRole(Role.TRAINER);

    UserResponse result = userMapper.toDto(user);

    assertNotNull(result);
    assertEquals("mail@example.com", result.getMail());
    assertEquals(Role.TRAINER, result.getRole());
  }

  /**
   * This test checks the conversion of User entity to UserResponse. It verifies that null is
   * returned when the input is null.
   */
  @DisplayName("Should return null when input to toDto is null")
  @Test
  void toDtoNullInput() {
    UserResponse result = userMapper.toDto(null);

    assertNull(result);
  }
}
