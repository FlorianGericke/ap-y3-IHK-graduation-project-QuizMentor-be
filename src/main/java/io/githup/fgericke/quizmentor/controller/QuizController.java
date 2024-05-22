package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.repository.QuizRepository;
import io.githup.fgericke.quizmentor.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/quiz")
public class QuizController extends BaseController<
    Quiz,
    QuizRepository,
    QuizRequest,
    QuizResponse,
    QuizService> {

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service      The service to be used.
   */
  @Autowired
  public QuizController(final QuizService service) {
    super(service);
  }
}
