package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.mapper.AnswerMapper;
import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.repository.AnswerRepository;
import io.githup.fgericke.quizmentor.service.AnswerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnswerController is a concrete implementation of the BaseController. It handles HTTP requests
 * related to the Answer entity.
 * <p>
 * It extends the BaseController with the following type parameters: - Answer as the entity type -
 * AnswerRepository as the repository type - AnswerRequest as the request DTO type - AnswerResponse
 * as the response type - AnswerMapper as the mapper type - AnswerService as the service type
 */
@RestController
@RequestMapping(path = "/api/v1/answer")
@Tag(name = "Answer", description = "The Answer API")
public class AnswerController extends
    BaseController<
        Answer,
        AnswerRepository,
        AnswerRequest,
        AnswerResponse,
        AnswerMapper,
        AnswerService
        > {

  /**
   * Constructs an AnswerController with the provided mapper and service.
   *
   * @param mapper  The mapper to be used.
   * @param service The service to be used.
   */
  @Autowired
  public AnswerController(final AnswerMapper mapper, final AnswerService service) {
    super(mapper, service);
  }
}
