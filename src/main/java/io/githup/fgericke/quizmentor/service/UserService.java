package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.mapper.UserMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.EntityNotFoundException;
import io.githup.fgericke.quizmentor.repository.UserRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to Users. Extends the BaseService class. It
 * provides specific implementation for User related operations.
 */
@Service
public class UserService extends BaseService<
    User,
    UserRepository,
    UserRequest,
    UserMapper
    > {

  /**
   * Constructor for the UserService. It initializes the BaseService with the provided
   * UserRepository and UserMapper.
   *
   * @param repo   The UserRepository to be used by the BaseService.
   * @param mapper The UserMapper to be used by the BaseService.
   */
  @Autowired
  public UserService(final UserRepository repo, final UserMapper mapper) {
    super(repo, mapper);
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

  /**
   * This method is used to find a user by their email. It calls the findByMail method of the
   * UserRepository to get the user. If the user is not found, it throws an
   * EntityNotFoundException.
   *
   * @param mail the email of the user to find
   * @return the User entity if found
   * @throws EntityNotFoundException if the user is not found
   */
  public User findByMail(final String mail) {
    return getRepository().findByMail(mail)
        .orElseThrow(() -> new EntityNotFoundException("MAIL", mail));
  }
}
