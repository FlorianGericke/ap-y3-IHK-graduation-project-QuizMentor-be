package io.githup.fgericke.quizmentor.dto.requests;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The SolutionRequest class is a data transfer object (DTO) that represents a request to create or
 * update a Solution. It implements the EntityRequest interface, meaning it can be converted to a
 * Solution entity. It is annotated with Lombok annotations to automatically generate getters,
 * setters, constructors, and a builder.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolutionRequest {

  /**
   * The solution string. This is a required field for a solution.
   */
  private String solution;

  /**
   * The score of the solution. This is an optional field for a solution.
   */
  private int score;

  /**
   * The identifier of the entity that created the solution. This is an optional field for a
   * solution.
   */
  @Hidden
  private String createdFrom;

  /**
   * The identifier of the question that the solution is associated with. This is an optional field
   * for a solution.
   */
  private String question;
}
