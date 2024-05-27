package io.githup.fgericke.quizmentor.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the response object for an Answer. It is a DTO (Data Transfer Object) that
 * is used to send data over the network. It implements the ResponseMapper interface, which means it
 * can toDto an Answer entity to an AnswerResponse. The class is annotated with Lombok annotations
 * to automatically generate getters, builders, and constructors. It is also marked as a Spring
 * component.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {

  /**
   * The ID of the answer. This is a unique identifier for the answer.
   */
  private UUID id;

  /**
   * The IRI (Internationalized Resource Identifier) of the answer. This is a unique identifier for
   * the answer in the form of an IRI.
   */
  private String iri;

  /**
   * The text of the answer. This is the actual content of the answer.
   */
  private String answer;

  /**
   * The IRI of the question that this answer is associated with. This links the answer to the
   * question it is answering.
   */
  private String questionIri;

  /**
   * The IRI of the user who owns this answer. This links the answer to the user who created it.
   */
  private String ownerIri;

  /**
   * The IRI of the user who reviewed this answer. This links the answer to the user who reviewed
   * it.
   */
  private String reviewedFromIri;

  /**
   * A boolean indicating whether this answer is correct. This is true if the answer is correct, and
   * false otherwise.
   */
  private boolean correct;
}
