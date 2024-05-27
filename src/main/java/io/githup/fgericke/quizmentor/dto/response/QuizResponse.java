package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the response object for a Quiz. It is a DTO (Data Transfer Object) that is
 * used to send data over the network. It implements the ResponseMapper interface, which means it
 * can map a Quiz entity to a QuizResponse. The class is annotated with Lombok annotations to
 * automatically generate getters, builders, and constructors. It is also marked as a Spring
 * component.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {

  /**
   * The unique identifier of the quiz. This is a UUID.
   */
  private UUID id;

  /**
   * The IRI (Internationalized Resource Identifier) of the quiz. This is a unique identifier for
   * the quiz in the form of an IRI.
   */
  private String iri;

  /**
   * The title of the quiz. This is a brief summary of the quiz.
   */
  private String title;

  /**
   * The description of the quiz. This provides more detailed information about the quiz.
   */
  private String description;

  /**
   * The categories of the quiz. This is a list of categories that the quiz falls under.
   */
  private List<String> categories;

  /**
   * The questions of the quiz. This is a list of questions that are part of the quiz.
   */
  private List<String> questions;

  /**
   * The IRI of the owner of the quiz. This is a unique identifier for the owner in the form of an
   * IRI.
   */
  private String ownerIri;

  /**
   * The visibility status of the quiz. This indicates whether the quiz is visible or hidden.
   */
  private Visibility status;

}
