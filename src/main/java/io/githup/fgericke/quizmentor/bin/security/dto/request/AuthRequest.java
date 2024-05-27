package io.githup.fgericke.quizmentor.bin.security.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the authentication request that is sent when a user tries to log in. It is
 * a simple data transfer object (DTO) that carries the necessary information for authentication.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

  /**
   * The email of the user trying to log in. This is used as the username for the user.
   */
  private String email;

  /**
   * The password of the user trying to log in. This is used for authentication.
   */
  private String password;
}
