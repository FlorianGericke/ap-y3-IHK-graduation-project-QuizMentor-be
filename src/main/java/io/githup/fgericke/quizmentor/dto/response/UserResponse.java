package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the response object for a User. It is a DTO (Data Transfer Object) that
 * is used to send data over the network. It is annotated with Lombok annotations to
 * automatically generate getters, builders, and constructors.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

  /**
   * The email of the user. This is a unique identifier for the user in the form of an email.
   */
  private String mail;

  /**
   * The role of the user. This is an enum representing the user's role in the system.
   * The role can be one of the following: ADMIN, USER.
   */
  private Role role;
}
