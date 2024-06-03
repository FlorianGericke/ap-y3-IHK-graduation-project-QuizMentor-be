package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.mapper.QuizMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.repository.QuizRepository;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuizController is a concrete implementation of the BaseController. It handles HTTP requests
 * related to the Quiz entity.
 * <p>
 * It extends the BaseController with the following type parameters: - Quiz as the entity type -
 * QuizRepository as the repository type - QuizRequest as the request DTO type - QuizResponse as the
 * response type - QuizMapper as the mapper type - QuizService as the service type
 */
@RestController
@RequestMapping(path = "/api/v1/quiz")
@Tag(name = "Quiz", description = "The Quiz API")
public class QuizController extends BaseController<
    Quiz,
    QuizRepository,
    QuizRequest,
    QuizResponse,
    QuizMapper,
    QuizService> {

  /**
   * Constructs a QuizController with the provided mapper and service.
   *
   * @param mapper  The mapper to be used.
   * @param service The service to be used.
   */
  @Autowired
  public QuizController(final QuizMapper mapper, final QuizService service) {
    super(mapper, service);
  }
}
