package io.githup.fgericke.quizmentor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.repository.QuizRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Test class for QuizService. It uses JUnit and Mockito for testing.
 */
class QuizServiceTest {

  private static final int PAGE_SIZE = 100;
  private static final int DELETE_INVOCATION_COUNT = 1;

  @Mock
  private QuizRepository quizRepository;

  @Mock
  private QuizResponse quizResponse;

  @Mock
  private Quiz quiz;

  @Mock
  private QuizRequest quizRequest;

  private QuizService quizService;

  /**
   * Sets up the test environment before each test method. Initializes the mock objects and the
   * service to be tested.
   */
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    quizService = new QuizService(quizRepository, quizResponse);
    when(quiz.getId()).thenReturn(UUID.randomUUID());
  }

  /**
   * Test for the post method of the service. Checks if a new quiz is created correctly.
   */
  @Test
  @Disabled
  void post() {
    when(quizRequest.getTitle()).thenReturn("New Quiz");
    when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

    QuizResponse createdQuiz = quizService.post(quizRequest);

    verify(quizRepository).save(any(Quiz.class));
    assertEquals("New Quiz", createdQuiz.getTitle());
  }

  /**
   * Test for the getAll method of the service. Checks if all quizzes are returned correctly.
   */
  @Test
  @Disabled
  void getAll() {
    List<Quiz> quizzes = Arrays.asList(new Quiz(), new Quiz());
    when(quizRepository.findAll()).thenReturn(quizzes);

    Pageable pageable = PageRequest.ofSize(PAGE_SIZE);
    Page<QuizResponse> returnedQuizzes = quizService.getAll(pageable);

    assertEquals(quizzes.size(), returnedQuizzes.getTotalElements());
  }

  /**
   * Test for the get method of the service. Checks if a quiz is returned by id correctly.
   */
  @Test
  void get() {
    UUID id = UUID.randomUUID();
    when(quizRepository.findById(id)).thenReturn(Optional.of(quiz));

    QuizResponse returnedQuiz = quizService.get(id);

    assertEquals(quizResponse.map(quiz), returnedQuiz);
  }

  /**
   * Test for the put method of the service. Checks if a quiz is updated correctly.
   */
  @Test
  @Disabled
  void put() {
    UUID id = UUID.randomUUID();
    quizRequest.setTitle("Updated Quiz");

    when(quizRepository.findById(id)).thenReturn(Optional.of(quiz));
    when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

    QuizResponse updatedQuiz = quizService.put(id, quizRequest);

    assertEquals("Updated Quiz", updatedQuiz.getTitle());
  }

  /**
   * Test for the patch method of the service. Checks if a quiz title is updated when title is
   * provided.
   */
  @Test
  void patch() {
    when(quizRequest.getTitle()).thenReturn("New Quiz Title");
    when(quiz.getTitle()).thenReturn("Old Quiz Title");

    quizService.patch(quiz, quizRequest);

    verify(quiz).setTitle("New Quiz Title");
  }

  /**
   * Test for the delete method of the service. Checks if a quiz is removed by id correctly.
   */
  @Test
  @Disabled
  void delete() {
    UUID id = UUID.randomUUID();
    doNothing().when(quizRepository).deleteById(id);

    quizService.delete(id);

    verify(quizRepository, times(DELETE_INVOCATION_COUNT)).deleteById(id);
  }

  /**
   * Test for the getRepository method of the service. Checks if the quiz repository is returned
   * correctly.
   */
  @Test
  void testGet() {
    QuizRepository returnedRepository = quizService.getRepository();

    assertEquals(quizRepository, returnedRepository);
  }

  /**
   * Test for the getResponseDto method of the service. Checks if the quiz response dto is returned
   * correctly.
   */
  @Test
  void getResponseDto() {
    QuizResponse returnedResponse = quizService.getResponseDto();

    assertEquals(quizResponse, returnedResponse);
  }

  /**
   * Test for the patch method of the service. Checks if a quiz title is not updated when title is
   * not provided.
   */
  @Test
  void testPatch() {
    when(quizRequest.getTitle()).thenReturn(null);
    when(quiz.getTitle()).thenReturn("Old Quiz Title");

    quizService.patch(quiz, quizRequest);

    verify(quiz).setTitle("Old Quiz Title");
  }
}
