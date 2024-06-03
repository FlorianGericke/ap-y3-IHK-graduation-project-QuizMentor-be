package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.mapper.QuestionMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuestionController is a concrete implementation of the BaseController. It handles HTTP requests
 * related to the Question entity.
 * <p>
 * It extends the BaseController with the following type parameters: - Question as the entity type -
 * QuestionRepository as the repository type - QuestionRequest as the request DTO type -
 * QuestionResponse as the response type - QuestionMapper as the mapper type - QuestionService as
 * the service type
 */
@RestController
@RequestMapping(path = "/api/v1/question")
@Tag(name = "Question", description = "The Question API")
public class QuestionController extends BaseController<
    Question,
    QuestionRepository,
    QuestionRequest,
    QuestionResponse,
    QuestionMapper,
    QuestionService> {

  /**
   * Constructs a QuestionController with the provided mapper and service.
   *
   * @param mapper  The mapper to be used.
   * @param service The service to be used.
   */
  @Autowired
  public QuestionController(final QuestionMapper mapper, final QuestionService service) {
    super(mapper, service);
  }
}
