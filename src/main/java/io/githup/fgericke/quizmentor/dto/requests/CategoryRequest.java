package io.githup.fgericke.quizmentor.dto.requests;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The CategoryRequest class is a data transfer object (DTO) that represents a request to create or
 * update a Category. It implements the EntityRequest interface, meaning it can be converted to a
 * Category entity. It is annotated with Lombok annotations to automatically generate getters,
 * setters, constructors, and a builder.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
  /**
   * The name of the category. This is the only field in the request, as a category only has a
   * name.
   */
  private String name;

  /**
   * The questions in the category. This is an optional field for a category.
   * It is a list of question identifiers.
   */
  private List<String> questions;

  /**
   * The quizzes in the category. This is an optional field for a category. It is a list of quiz
   * identifiers.
   */
  private List<String> quizzes;
}
