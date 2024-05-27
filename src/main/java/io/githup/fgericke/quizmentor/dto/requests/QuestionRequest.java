package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Visibility;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The QuestionRequest class is a data transfer object (DTO) that represents a request to create or
 * update a Question. It implements the EntityRequest interface, meaning it can be converted to a
 * Question entity. It is annotated with Lombok annotations to automatically generate getters,
 * setters, constructors, and a builder.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {

  /**
   * The title of the question. This is a required field for a question.
   */
  private String title;

  /**
   * The description of the question. This is an optional field for a question.
   */
  private String description;

  /**
   * The visibility status of the question. This is an optional field for a question.
   */
  private Visibility status;

  /**
   * The categories of the question. This is a required field for a question.
   * It is a list of category identifiers.
   */
  private List<String> categories;

  /**
   * The solutions of the question. This is a required field for a question.
   * It is a list of solution identifiers.
   */
  private List<String> solutions;

  /**
   * The quizzes of the question. This is an optional field for a question. It is a list of quiz
   * identifiers.
   */
  private List<String> quizzes;

  /**
   * The score of the question. This is an optional field for a question.
   */
  private int score;
}
