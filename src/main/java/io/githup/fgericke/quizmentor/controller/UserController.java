package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.dto.response.UserResponse;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import io.githup.fgericke.quizmentor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController extends BaseController<
    User,
    UserRepository,
    UserRequest,
    UserResponse,
    UserService> {

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service      The service to be used.
   * @param userResponse The response to be used.
   */
  @Autowired
  public UserController(final UserService service, final UserResponse userResponse) {
    super(service, userResponse);
  }
}
