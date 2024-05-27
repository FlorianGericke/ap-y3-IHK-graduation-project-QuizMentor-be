package io.githup.fgericke.quizmentor.bin.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the authentication response that is sent after a successful login. It is a
 * simple data transfer object (DTO) that carries the authentication token.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthResponse {

  /**
   * The authentication token that is returned after a successful login. This token must be included
   * in the Authorization header in subsequent requests to the server.
   */
  private String token;
}
