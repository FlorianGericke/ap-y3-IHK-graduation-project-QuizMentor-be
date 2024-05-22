package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.repository.QuestionRepository;
import io.githup.fgericke.quizmentor.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/question")
public class QuestionController extends BaseController<
    Question,
    QuestionRepository,
    QuestionRequest,
    QuestionResponse,
    QuestionService> {

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service          The service to be used.
   */
  @Autowired
  public QuestionController(final QuestionService service) {
    super(service);
  }
}
