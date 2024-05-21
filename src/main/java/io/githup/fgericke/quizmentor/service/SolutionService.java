package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to Solutions. Extends the BaseService class.
 */
@Service
public class SolutionService extends BaseService<
    Solution,
    SolutionRepository,
    SolutionRequest,
    SolutionResponse> {

  /**
   * Constructs a new BaseService with the given repository and response DTO.
   *
   * @param repo     The repository to be used by this service.
   * @param response The response DTO to be used by this service.
   */
  @Autowired
  public SolutionService(final SolutionRepository repo, final SolutionResponse response) {
    super(repo, response);
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
}
