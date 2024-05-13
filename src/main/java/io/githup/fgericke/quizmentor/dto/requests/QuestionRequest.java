package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
public class QuestionRequest implements EntityRequest<Question> {

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
   * The score of the question. This is an optional field for a question.
   */
  private int score;

  /**
   * Converts this QuestionRequest to a Question entity. This is used when the request is received,
   * and we need to convert it to an entity to persist it in the database. If the title is null, it
   * throws a ResponseStatusException with a 500 status code.
   *
   * @return a Question entity with the same title, description, visibility status, and score as
   * this request.
   * @throws ResponseStatusException if the title is null
   */
  @Override
  public Question toEntity() {
    if (getTitle() == null) {
      // todo implement Custom Exceptions
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "[Question] Title cannot be "
          + "null");
    }
    return Question.builder()
        .status(getStatus())
        .title(getTitle())
        .description(getDescription())
        .status(getStatus())
        .score(getScore())
        .build();
  }
}
