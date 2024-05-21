package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.repository.AnswerRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Answer entities. This class extends BaseService and provides specific
 * implementation for Answer entity.
 */
@Service
public class AnswerService extends BaseService<
    Answer,
    AnswerRepository,
    AnswerRequest,
    AnswerResponse> {

  /**
   * Constructs a new BaseService with the given repository and response DTO.
   *
   * @param repo     The repository to be used by this service.
   * @param response The response DTO to be used by this service.
   */
  @Autowired
  public AnswerService(final AnswerRepository repo, final AnswerResponse response) {
    super(repo, response);
  }

  /**
   * Updates the provided Answer entity with the new data from the AnswerRequest. If the
   * AnswerRequest does not provide a new answer, the existing answer in the entity is kept.
   *
   * @param entityToUpdate The Answer entity to update.
   * @param answerRequest  The AnswerRequest containing the new data.
   * @return The updated Answer entity.
   */
  @Override
  public Answer patch(final Answer entityToUpdate, final AnswerRequest answerRequest) {
    entityToUpdate.setAnswer(
        answerRequest.getAnswer() != null
            ? answerRequest.getAnswer()
            : entityToUpdate.getAnswer());
    return entityToUpdate;
  }
}
