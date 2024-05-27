package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.mapper.SolutionMapper;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import io.githup.fgericke.quizmentor.service.SolutionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SolutionController is a concrete implementation of the BaseController. It handles HTTP requests
 * related to the Solution entity.
 * <p>
 * It extends the BaseController with the following type parameters: - Solution as the entity type -
 * SolutionRepository as the repository type - SolutionRequest as the request DTO type -
 * SolutionResponse as the response type - SolutionMapper as the mapper type - SolutionService as
 * the service type
 */
@RestController
@RequestMapping(path = "/api/v1/solution")
@Tag(name = "Solution", description = "The Solution API")
public class SolutionController extends BaseController<
    Solution,
    SolutionRepository,
    SolutionRequest,
    SolutionResponse,
    SolutionMapper,
    SolutionService> {

  /**
   * Constructs a SolutionController with the provided mapper and service.
   *
   * @param mapper  The mapper to be used.
   * @param service The service to be used.
   */
  @Autowired
  public SolutionController(final SolutionMapper mapper, final SolutionService service) {
    super(mapper, service);
  }
}
