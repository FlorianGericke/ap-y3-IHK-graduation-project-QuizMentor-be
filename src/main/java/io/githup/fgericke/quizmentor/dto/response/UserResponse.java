package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Role;
import io.githup.fgericke.quizmentor.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This class represents the response object for User. It is used to map the User entity to a
 * response object that can be sent to the client. It includes the user's mail and role.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class UserResponse implements ResponseMapper<User, UserResponse> {

  /**
   * The mail of the user.
   */
  private String mail;

  /**
   * The role of the user.
   */
  private Role role;

  /**
   * This method maps a User entity to a UserResponse object. If the input User entity is null, it
   * returns null. Otherwise, it builds a new UserResponse object with the mail and role from the
   * User entity.
   *
   * @param input The User entity to map.
   * @return The mapped UserResponse object, or null if the input User entity is null.
   */
  @Override
  public UserResponse map(final User input) {
    return input == null ? null : UserResponse.builder()
        .mail(input.getMail())
        .role(input.getRole())
        .build();
  }
}
