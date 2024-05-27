package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to Questions. Extends the BaseService class. It
 * provides specific implementation for Question related operations.
 */
@Service
public class QuestionService extends BaseService<
    Question,
    QuestionRepository,
    QuestionRequest,
    QuestionMapper
    > {

  /**
   * Constructor for the QuestionService. It initializes the BaseService with the provided
   * QuestionRepository and QuestionMapper.
   *
   * @param repo   The QuestionRepository to be used by the BaseService.
   * @param mapper The QuestionMapper to be used by the BaseService.
   */
  @Autowired
  public QuestionService(final QuestionRepository repo, final QuestionMapper mapper) {
    super(repo, mapper);
  }

  /**
   * Patches the given Question entity using the given QuestionRequest. If the title, description,
   * score or status in the QuestionRequest is not null, it updates the corresponding field of the
   * Question entity.
   *
   * @param entityToUpdate  The Question entity to be patched.
   * @param questionRequest The QuestionRequest with the patch information.
   * @return The patched Question entity.
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
