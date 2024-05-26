package io.githup.fgericke.quizmentor.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The AnswerRequest class is a data transfer object (DTO) that represents a request to create or
 * update an Answer. It implements the EntityRequest interface, meaning it can be converted to an
 * Answer entity. It is annotated with Lombok annotations to automatically generate getters,
 * setters, constructors, and a builder.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {

  /**
   * The answer string. This is a required field for an answer.
   */
  private String answer;

  /**
   * The correctness of the answer. This is a required field for an answer.
   */
  private Boolean isCorrect;

  /**
   * The identifier of the user who reviewed the answer. This is an optional field.
   */
  private String reviewedFrom;

  /**
   * The identifier of the question to which this answer belongs. This is a required field.
   */
  private String question;

  /**
   * The identifier of the user who owns the answer. This is a required field.
   */
  private String owner;
}
