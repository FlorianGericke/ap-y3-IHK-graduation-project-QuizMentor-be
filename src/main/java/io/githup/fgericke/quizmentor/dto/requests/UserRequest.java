package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Role;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserRequest {

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
   * The list of answers provided by the user. This is an optional field for a user.
   */
  @Hidden
  private List<String> answers;

  /**
   * The list of solutions provided by the user. This is an optional field for a user.
   */
  @Hidden
  private List<String> solutions;

  /**
   * The list of quizzes created by the user. This is an optional field for a user.
   */
  @Hidden
  private List<String> quizzes;

  /**
   * The list of questions created by the user. This is an optional field for a user.
   */
  @Hidden
  private List<String> questions;

}
