package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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


  private final UserRepository userRepository;

  /**
   * Constructor for the QuestionService. It initializes the BaseService with the provided
   * QuestionRepository and QuestionMapper.
   *
   * @param repo   The QuestionRepository to be used by the BaseService.
   * @param mapper The QuestionMapper to be used by the BaseService.
   * @param userRepository The UserRepository to be used by the BaseService.
   */
  @Autowired
  public QuestionService(final QuestionRepository repo, final QuestionMapper mapper,
      final UserRepository userRepository) {
    super(repo, mapper);
    this.userRepository = userRepository;
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

  /**
   * This method is used to create a new Question entity from the provided QuestionRequest. It first
   * retrieves the username of the currently authenticated user from the SecurityContext. Then, it
   * sets this username as the creator of the question in the QuestionRequest. Finally, it converts
   * the QuestionRequest to a Question entity using the mapper and saves it in the repository.
   *
   * @param questionRequest The QuestionRequest containing the data for the new Question entity.
   * @return The newly created Question entity.
   */
  @Override
  public Question post(final QuestionRequest questionRequest) {
    var userName = SecurityContextHolder.getContext().getAuthentication().getName();
    questionRequest.setCreatedFrom(userName);
    return getRepository().save(getMapper().toEntity(questionRequest));
  }
}
