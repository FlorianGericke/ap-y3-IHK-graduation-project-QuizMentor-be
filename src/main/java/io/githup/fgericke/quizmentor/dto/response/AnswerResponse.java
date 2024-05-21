package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This class represents the response object for an Answer. It is a DTO (Data Transfer Object) that
 * is used to send data over the network. It implements the ResponseMapper interface, which means it
 * can map an Answer entity to an AnswerResponse. The class is annotated with Lombok annotations to
 * automatically generate getters, builders, and constructors. It is also marked as a Spring
 * component.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class AnswerResponse implements ResponseMapper<Answer, AnswerResponse> {

  /**
   * The ID of the answer.
   */
  private UUID id;

  /**
   * The IRI (Internationalized Resource Identifier) of the answer.
   */
  private String iri;

  /**
   * The text of the answer.
   */
  private String answer;

  /**
   * The IRI of the question that this answer is associated with.
   */
  private String questionIri;

  /**
   * The IRI of the user who owns this answer.
   */
  private String ownerIri;

  /**
   * The IRI of the user who reviewed this answer.
   */
  private String reviewedFromIri;

  /**
   * A boolean indicating whether this answer is correct.
   */
  private boolean correct;

  /**
   * This method maps an Answer entity to an AnswerResponse. It uses the builder pattern to create a
   * new AnswerResponse. The IRI fields are generated using the UuidUtil.getIriFromBaseEntity
   * method.
   *
   * @param input the Answer entity to map
   * @return the mapped AnswerResponse
   */
  @Override
  public AnswerResponse map(final Answer input) {
    return input == null ? null : AnswerResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIriFromBaseEntity(input))
        .questionIri(UuidUtil.getIriFromBaseEntity(input.getQuestion()))
        .reviewedFromIri(UuidUtil.getIriFromBaseEntity(input.getReviewedFrom()))
        .ownerIri(UuidUtil.getIriFromBaseEntity(input.getOwner()))
        .answer(input.getAnswer())
        .correct(input.getIsCorrect())
        .build();
  }
}
