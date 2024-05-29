package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Visibility;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The QuizRequest class is a data transfer object (DTO) that represents a request to create or
 * update a Quiz. It implements the EntityRequest interface, meaning it can be converted to a Quiz
 * entity. It is annotated with Lombok annotations to automatically generate getters, setters,
 * constructors, and a builder.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequest {

  /**
   * The title of the quiz. This is a required field for a quiz.
   */
  private String title;

  /**
   * The description of the quiz. This is an optional field for a quiz.
   */
  private String description;

  /**
   * The visibility status of the quiz. This is an optional field for a quiz.
   */
  private Visibility status;

  /**
   * The categories of the quiz. This is an optional field for a quiz.
   * It is a list of category identifiers.
   */
  private List<String> categories;

  /**
   * The questions of the quiz. This is an optional field for a quiz.
   * It is a list of question identifiers.
   */
  private List<String> questions;

  /**
   * The owner of the quiz. This is an optional field for a quiz.
   */
  @Hidden
  private String createdFrom;
}
