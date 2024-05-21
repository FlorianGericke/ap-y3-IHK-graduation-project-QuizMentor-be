package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This class represents the response object for a Solution. It is annotated with @Component to
 * indicate that it is a Spring component. It implements the ResponseMapper interface, which
 * requires a mapToResponse method.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class SolutionResponse implements ResponseMapper<Solution, SolutionResponse> {

  private UUID id;
  private String iri;
  private String questionIri;
  private String ownerIri;
  private Integer score;
  private String solution;

  /**
   * This method maps a Solution entity to a SolutionResponse object. It uses the builder pattern to
   * create a new SolutionResponse object. It uses the UuidUtil class to convert the UUIDs of the
   * Solution, its question, and its owner to IRIs. It returns the created SolutionResponse object.
   *
   * @param input The Solution entity to map to a SolutionResponse object.
   * @return The created SolutionResponse object.
   */
  @Override
  public SolutionResponse map(final Solution input) {
    return input == null ? null : SolutionResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIriFromBaseEntity(input))
        .questionIri(UuidUtil.getIriFromBaseEntity(input.getQuestion()))
        .ownerIri(UuidUtil.getIriFromBaseEntity(input.getCreatedFrom()))
        .score(input.getScore())
        .solution(input.getSolution())
        .build();
  }
}
