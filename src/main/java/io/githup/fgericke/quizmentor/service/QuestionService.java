package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to Questions. Extends the BaseService class.
 */
@Service
public class QuestionService extends BaseService<
    Question,
    QuestionRepository,
    QuestionRequest,
    QuestionResponse> {

  /**
   * Constructs a new BaseService with the given repository and response DTO.
   *
   * @param repo     The repository to be used by this service.
   * @param response The response DTO to be used by this service.
   */
  @Autowired
  public QuestionService(final QuestionRepository repo, final QuestionResponse response) {
    super(repo, response);
  }

  /**
   * Method to patch (partially update) a Question entity. If a field in the QuestionRequest is not
   * null, it updates the corresponding field in the Question entity. If a field in the
   * QuestionRequest is null, it keeps the existing value in the Question entity.
   *
   * @param entityToUpdate  The Question entity to update.
   * @param questionRequest The QuestionRequest containing the new values.
   * @return The updated Question entity.
   */
  @Override
  public Question patch(final Question entityToUpdate, final QuestionRequest questionRequest) {
    entityToUpdate.setTitle(questionRequest.getTitle() != null
        ? questionRequest.getTitle()
        : entityToUpdate.getTitle());
    entityToUpdate.setDescription(questionRequest.getDescription() != null
        ? questionRequest.getDescription()
        : entityToUpdate.getDescription());
    entityToUpdate.setScore(questionRequest.getScore() != questionRequest.getScore()
        ? questionRequest.getScore()
        : entityToUpdate.getScore());
    entityToUpdate.setStatus(questionRequest.getStatus() != questionRequest.getStatus()
        ? questionRequest.getStatus()
        : entityToUpdate.getStatus()
    );
    return entityToUpdate;
  }
}
