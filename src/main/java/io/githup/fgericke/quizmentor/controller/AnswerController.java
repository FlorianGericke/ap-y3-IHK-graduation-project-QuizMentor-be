package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.repository.AnswerRepository;
import io.githup.fgericke.quizmentor.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/answer")
public class AnswerController extends
    BaseController<Answer, AnswerRepository, AnswerRequest, AnswerResponse, AnswerService> {

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service        The service to be used.
   */
  @Autowired
  public AnswerController(final AnswerService service) {
    super(service);
  }
}


