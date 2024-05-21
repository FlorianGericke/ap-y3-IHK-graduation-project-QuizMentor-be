import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.repository.AnswerRepository;
import io.githup.fgericke.quizmentor.service.AnswerService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

class AnswerServiceTest {

  @Mock
  private AnswerRepository answerRepository;

  @Mock
  private AnswerRequest answerRequest;

  @Mock
  private AnswerResponse answerResponse;

  @InjectMocks
  private AnswerService answerService;

  @Mock
  private Pageable pageable;

  @Mock
  private Page<AnswerResponse> pageAnswerResponse;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void patchShouldUpdateAnswerWhenNewAnswerIsProvided() {
    Answer existingAnswer = new Answer();
    existingAnswer.setAnswer("Existing Answer");

    when(answerRequest.getAnswer()).thenReturn("New Answer");

    Answer updatedAnswer = answerService.patch(existingAnswer, answerRequest);

    assertEquals("New Answer", updatedAnswer.getAnswer());
  }

  @Test
  void patchShouldKeepExistingAnswerWhenNoNewAnswerIsProvided() {
    Answer existingAnswer = new Answer();
    existingAnswer.setAnswer("Existing Answer");

    when(answerRequest.getAnswer()).thenReturn(null);

    Answer updatedAnswer = answerService.patch(existingAnswer, answerRequest);

    assertEquals("Existing Answer", updatedAnswer.getAnswer());
  }

  @Test
  void postShouldReturnAnswerResponse() {
    when(answerService.post(answerRequest)).thenReturn(answerResponse);

    AnswerResponse result = answerService.post(answerRequest);

    assertEquals(answerResponse, result);
  }

  @Test
  @Disabled
  void getAllShouldReturnPageOfAnswerResponse() {
    when(answerService.getAll(pageable)).thenReturn(pageAnswerResponse);

    Page<AnswerResponse> result = answerService.getAll(pageable);

    assertEquals(pageAnswerResponse, result);
  }

  @Test
  @Disabled
  void getShouldReturnAnswerResponseById() {
    UUID id = UUID.randomUUID();
    when(answerService.get(id)).thenReturn(answerResponse);

    AnswerResponse result = answerService.get(id);

    assertEquals(answerResponse, result);
  }

  @Test
  @Disabled
  void putShouldReturnUpdatedAnswerResponse() {
    UUID id = UUID.randomUUID();
    when(answerService.put(id, answerRequest)).thenReturn(answerResponse);

    AnswerResponse result = answerService.put(id, answerRequest);

    assertEquals(answerResponse, result);
  }

  @Test
  @Disabled
  void patchShouldReturnUpdatedAnswerResponse() {
    UUID id = UUID.randomUUID();
    when(answerService.patch(id, answerRequest)).thenReturn(answerResponse);

    AnswerResponse result = answerService.patch(id, answerRequest);

    assertEquals(answerResponse, result);
  }

  @Test
  @Disabled
  void deleteShouldReturnDeletedAnswerResponse() {
    UUID id = UUID.randomUUID();
    when(answerService.delete(id)).thenReturn(answerResponse);

    AnswerResponse result = answerService.delete(id);

    assertEquals(answerResponse, result);
  }

  @Test
  @Disabled
  void getShouldReturnAnswerResponseByIri() {
    String iri = "iri";
    when(answerService.get(iri)).thenReturn(answerResponse);

    AnswerResponse result = answerService.get(iri);

    assertEquals(answerResponse, result);
  }
}
