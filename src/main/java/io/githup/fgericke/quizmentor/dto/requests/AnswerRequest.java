package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
public class AnswerRequest implements EntityRequest<Answer> {

  /**
   * The answer string. This is a required field for an answer.
   */
  private String answer;

  /**
   * The correctness of the answer. This is a required field for an answer.
   */
  private Boolean isCorrect;

  /**
   * Converts this AnswerRequest to an Answer entity. This is used when the request is received, and
   * we need to convert it to an entity to persist it in the database. If the answer is null, it
   * throws a ResponseStatusException with a 500 status code.
   *
   * @return an Answer entity with the same answer string and correctness as this request.
   * @throws ResponseStatusException if the answer is null
   */
  @Override
  public Answer toEntity() {
    if (getAnswer() == null) {
      // todo implement Custom Exceptions
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
          "[Answer] Title cannot be null");
    }
    return Answer.builder()
        .answer(getAnswer())
        .isCorrect(getIsCorrect())
        .build();
  }
}
