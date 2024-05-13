package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Solution;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
public class SolutionRequest implements EntityRequest<Solution> {

  /**
   * The solution string. This is a required field for a solution.
   */
  private String solution;

  /**
   * The score of the solution. This is an optional field for a solution.
   */
  private int score;

  /**
   * Converts this SolutionRequest to a Solution entity. This is used when the request is received,
   * and we need to convert it to an entity to persist it in the database. If the solution is null,
   * it throws a ResponseStatusException with a 500 status code.
   *
   * @return a Solution entity with the same solution string and score as this request.
   * @throws ResponseStatusException if the solution is null
   */
  @Override
  public Solution toEntity() {
    if (getSolution() == null) {
      // todo implement Custom Exceptions
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "[Solution] Solution cannot be null");
    }
    return Solution.builder()
        .solution(getSolution())
        .score(getScore())
        .build();
  }
}
