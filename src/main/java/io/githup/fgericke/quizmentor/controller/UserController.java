package io.githup.fgericke.quizmentor.controller;

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.mapper.UserMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.dto.response.UserResponse;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import io.githup.fgericke.quizmentor.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController is a concrete implementation of the BaseController. It handles HTTP requests
 * related to the User entity.
 * <p>
 * It extends the BaseController with the following type parameters: - User as the entity type -
 * UserRepository as the repository type - UserRequest as the request DTO type - UserResponse as the
 * response type - UserMapper as the mapper type - UserService as the service type
 */
@RestController
@RequestMapping(path = "/api/v1/user")
@Tag(name = "User", description = "The User API")
public class UserController extends BaseController<
    User,
    UserRepository,
    UserRequest,
    UserResponse,
    UserMapper,
    UserService> {

  /**
   * Constructs a UserController with the provided mapper and service.
   *
   * @param mapper  The mapper to be used.
   * @param service The service to be used.
   */
  @Autowired
  public UserController(final UserMapper mapper, final UserService service) {
    super(mapper, service);
  }
}
