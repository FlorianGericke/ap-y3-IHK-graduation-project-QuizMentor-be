package io.githup.fgericke.quizmentor.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the response object for a Solution. It is a DTO (Data Transfer Object) that
 * is used to send data over the network. It is annotated with Lombok annotations to automatically
 * generate getters, builders, and constructors.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolutionResponse {

  /**
   * The unique identifier of the solution. This is a UUID.
   */
  private UUID id;

  /**
   * The IRI (Internationalized Resource Identifier) of the solution. This is a unique identifier
   * for the solution in the form of an IRI.
   */
  private String iri;

  /**
   * The IRI of the question that this solution is associated with. This is a unique identifier for
   * the question in the form of an IRI.
   */
  private String questionIri;

  /**
   * The IRI of the owner of the solution. This is a unique identifier for the owner in the form of
   * an IRI.
   */
  private String creator;

  /**
   * The score of the solution. This is an integer value representing the score of the solution.
   */
  private Integer score;

  /**
   * The solution text. This is the actual solution provided by the user.
   */
  private String solution;
}
