package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entities.Role;
import io.githup.fgericke.quizmentor.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * The UserRequest class is a data transfer object (DTO) that represents a request to create or
 * update a User. It implements the EntityRequest interface, meaning it can be converted to a User
 * entity. It is annotated with Lombok annotations to automatically generate getters, setters,
 * constructors, and a builder.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements EntityRequest<User> {

  /**
   * The email of the user. This is a required field for a user.
   */
  private String mail;

  /**
   * The password of the user. This is a required field for a user.
   */
  private String password;

  /**
   * The role of the user. This is an optional field for a user.
   */
  private Role role;

  /**
   * Converts this UserRequest to a User entity. This is used when the request is received, and we
   * need to convert it to an entity to persist it in the database. If the email or password is
   * null, it throws a ResponseStatusException with a 500 status code.
   *
   * @return a User entity with the same email, password, and role as this request.
   * @throws ResponseStatusException if the email or password is null
   */
  @Override
  public User toEntity() {
    if (getMail() == null || getPassword() == null) {
      // todo implement Custom Exceptions
      throw new ResponseStatusException(HttpStatusCode.valueOf(500),
          "[User] Mail,Password cannot be null");
    }

    return User.builder()
        .mail(getMail())
        .password(getPassword())
        .role(getRole())
        .build();
  }
}
