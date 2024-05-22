package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.repository.SolutionRepository;
import io.githup.fgericke.quizmentor.service.SolutionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/solution")
@Tag(name = "Solution", description = "The Solution API")
public class SolutionController extends BaseController<
    Solution,
    SolutionRepository,
    SolutionRequest,
    SolutionResponse,
    SolutionService> {

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service          The service to be used.
   */
  @Autowired
  public SolutionController(final SolutionService service) {
    super(service);
  }
}
