package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.mapper.QuizMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.repository.QuizRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * QuizService is a service class that extends BaseService. It provides specific implementation for
 * Quiz related operations.
 */
@Service
public class QuizService extends BaseService<
    Quiz,
    QuizRepository,
    QuizRequest,
    QuizMapper> {

  /**
   * Constructor for the QuizService. It initializes the BaseService with the provided
   * QuizRepository and QuizMapper.
   *
   * @param repo   The QuizRepository to be used by the BaseService.
   * @param mapper The QuizMapper to be used by the BaseService.
   */
  @Autowired
  public QuizService(final QuizRepository repo, final QuizMapper mapper) {
    super(repo, mapper);
  }

  /**
   * Patches the given Quiz entity using the given QuizRequest. If the title, description or status
   * in the QuizRequest is not null, it updates the corresponding fields of the Quiz entity.
   *
   * @param entityToUpdate The Quiz entity to be patched.
   * @param quizRequest    The QuizRequest with the patch information.
   * @return The patched Quiz entity.
   */
  @Override
  public Quiz patch(final Quiz entityToUpdate, final QuizRequest quizRequest) {
    entityToUpdate.setTitle(quizRequest.getTitle() != null
        ? quizRequest.getTitle()
        : entityToUpdate.getTitle());
    entityToUpdate.setDescription(quizRequest.getDescription() != null
        ? quizRequest.getDescription()
        : entityToUpdate.getDescription());
    entityToUpdate.setVisibility(quizRequest.getVisibility() != null
        ? quizRequest.getVisibility()
        : entityToUpdate.getVisibility());
    return entityToUpdate;
  }

  /**
   * Posts a new Quiz entity using the given QuizRequest. It sets the createdFrom field of the
   * QuizRequest to the username of the currently logged in user.
   *
   * @param quizRequest The QuizRequest with the information for the new Quiz entity.
   * @return The newly created Quiz entity.
   */
  @Override
  public Quiz post(final QuizRequest quizRequest) {
    var userName = SecurityContextHolder.getContext().getAuthentication().getName();
    quizRequest.setCreatedFrom(userName);
    return getRepository().save(getMapper().toEntity(quizRequest));
  }
}
