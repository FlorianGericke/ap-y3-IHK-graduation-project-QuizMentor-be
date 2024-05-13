package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

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
public class QuizRequest implements EntityRequest<Quiz> {

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
   * Converts this QuizRequest to a Quiz entity. This is used when the request is received, and we
   * need to convert it to an entity to persist it in the database. If the title is null, it throws
   * a ResponseStatusException with a 500 status code.
   *
   * @return a Quiz entity with the same title, description, and visibility status as this request.
   * @throws ResponseStatusException if the title is null
   */
  @Override
  public Quiz toEntity() {
    if (getTitle() == null) {
      // todo implement Custom Exceptions
      throw new ResponseStatusException(HttpStatusCode.valueOf(500), "[QUIZ] Title cannot be null");
    }

    return Quiz.builder()
        .title(getTitle())
        .description(getDescription())
        .visibility(getStatus())
        .build();
  }
}
