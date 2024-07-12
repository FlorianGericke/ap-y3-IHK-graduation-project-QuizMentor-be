package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the response object for a Question. It is a DTO (Data Transfer Object) that
 * is used to send data over the network. It implements the ResponseMapper interface, which means it
 * can toDto a Question entity to a QuestionResponse. The class is annotated with Lombok annotations
 * to automatically generate getters, builders, and constructors. It is also marked as a Spring
 * component.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {

  /**
   * The unique identifier of the question. This is a UUID.
   */
  private UUID id;

  /**
   * The IRI (Internationalized Resource Identifier) of the question. This is a unique identifier
   * for the question in the form of an IRI.
   */
  private String iri;

  /**
   * The title of the question. This is a brief summary of the question.
   */
  private String title;

  /**
   * The description of the question. This provides more detailed information about the question.
   */
  private String description;

  private String creator;

  /**
   * The openness status of the question. This indicates whether the question is open or closed.
   */
  private Boolean isOpen;

  /**
   * The score of the question. This is the number of points that can be earned for correctly
   * answering the question.
   */
  private Integer score;

  /**
   * The visibility status of the question. This indicates whether the question is visible or
   * hidden.
   */
  private Visibility status;

  /**
   * The solutions of the question. This is a list of correct answers for the question.
   */
  private List<String> solutions;

  /**
   * The answers of the question. This is a list of all answers submitted for the question.
   */
  private List<String> answers;

  /**
   * The answers of the question. This is a list of all answers submitted for the question.
   */
  private List<String> categories;
}
