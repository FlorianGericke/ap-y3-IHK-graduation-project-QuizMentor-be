package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.mapper.SolutionMapper;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to Solutions. Extends the BaseService class. It
 * provides specific implementation for Solution related operations.
 */
@Service
public class SolutionService extends BaseService<
    Solution,
    SolutionRepository,
    SolutionRequest,
    SolutionMapper
    > {

  /**
   * Constructor for the SolutionService. It initializes the BaseService with the provided
   * SolutionRepository and SolutionMapper.
   *
   * @param repo   The SolutionRepository to be used by the BaseService.
   * @param mapper The SolutionMapper to be used by the BaseService.
   */
  public SolutionService(final SolutionRepository repo, final SolutionMapper mapper) {
    super(repo, mapper);
  }

  /**
   * Method to patch (partially update) a Solution entity. If a field in the SolutionRequest is not
   * null, it updates the corresponding field in the Solution entity. If a field in the
   * SolutionRequest is null, it keeps the existing value in the Solution entity.
   *
   * @param entityToUpdate  The Solution entity to update.
   * @param solutionRequest The SolutionRequest containing the new values.
   * @return The updated Solution entity.
   */
  @Override
  public Solution patch(final Solution entityToUpdate, final SolutionRequest solutionRequest) {
    entityToUpdate.setSolution(
        solutionRequest.getSolution() != null
            ? solutionRequest.getSolution()
            : entityToUpdate.getSolution()
    );
    entityToUpdate.setScore(
        solutionRequest.getScore() != 0
            ? solutionRequest.getScore()
            : entityToUpdate.getScore()
    );

    return entityToUpdate;
  }

  /**
   * Method to create a new Solution entity from the provided SolutionRequest.
   *
   * @param solutionRequest The SolutionRequest containing the data for the new Solution entity.
   * @return The newly created Solution entity.
   */
  @Override
  public Solution post(final SolutionRequest solutionRequest) {
    var userName = SecurityContextHolder.getContext().getAuthentication().getName();
    solutionRequest.setCreatedFrom(userName);
    return getRepository().save(getMapper().toEntity(solutionRequest));
  }
}
