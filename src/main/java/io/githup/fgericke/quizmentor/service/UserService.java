package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.dto.response.UserResponse;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to Users. Extends the BaseService class.
 */
@Service
public class UserService extends BaseService<
    User,
    UserRepository,
    UserRequest,
    UserResponse> {

  /**
   * Constructs a new BaseService with the given repository and response DTO.
   *
   * @param repo     The repository to be used by this service.
   * @param response The response DTO to be used by this service.
   */
  @Autowired
  public UserService(final UserRepository repo, final UserResponse response) {
    super(repo, response);
  }

  /**
   * Method to patch (partially update) a User entity. If a field in the UserRequest is not null, it
   * updates the corresponding field in the User entity. If a field in the UserRequest is null, it
   * keeps the existing value in the User entity.
   *
   * @param entityToUpdate The User entity to update.
   * @param userRequest    The UserRequest containing the new values.
   * @return The updated User entity.
   */
  @Override
  public User patch(final User entityToUpdate, final UserRequest userRequest) {
    entityToUpdate.setMail(
        userRequest.getMail() != null
            ? userRequest.getMail()
            : entityToUpdate.getMail());
    entityToUpdate.setPassword(
        userRequest.getPassword() != null
            ? userRequest.getPassword()
            : entityToUpdate.getPassword());
    entityToUpdate.setRole(
        userRequest.getRole() != null
            ? userRequest.getRole()
            : entityToUpdate.getRole());
    return entityToUpdate;
  }
}
