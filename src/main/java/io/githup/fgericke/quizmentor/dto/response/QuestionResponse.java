package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Visibility;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import java.util.HashMap;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This class represents the response object for a Question. It is annotated with @Component to
 * indicate that it is a Spring Bean. It implements the ResponseMapper interface to map a Question
 * entity to a QuestionResponse.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class QuestionResponse implements ResponseMapper<Question, QuestionResponse> {

  // The unique identifier of the question
  private UUID id;

  // The IRI (Internationalized Resource Identifier) of the question
  private String iri;

  // The title of the question
  private String title;

  // The description of the question
  private String description;

  // The openness status of the question
  private Boolean isOpen;

  // The score of the question
  private Integer score;

  // The visibility status of the question
  private Visibility status;

  // The solutions of the question
  private HashMap<String, String> solutions;

  // The answers of the question
  private HashMap<String, String> answers;

  /**
   * This method maps a Question entity to a QuestionResponse. It uses the builder pattern to create
   * a new QuestionResponse object.
   *
   * @param input The Question entity to be mapped.
   * @return A new QuestionResponse object with the data from the input Question.
   */
  @Override
  public QuestionResponse map(final Question input) {
    return input == null ? null : QuestionResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIriFromBaseEntity(input))
        .title(input.getTitle())
        .description(input.getDescription())
        .isOpen(input.isOpenQuestion())
        .score(input.getScore())
        .status(input.getStatus())
        .solutions(input.getSolutions().stream().map(UuidUtil::getIriFromBaseEntity)
            .collect(HashMap::new, (m, v) -> m.put(v, v), HashMap::putAll))
        .answers(input.getSolutions().stream().map(UuidUtil::getIriFromBaseEntity)
            .collect(HashMap::new, (m, v) -> m.put(v, v), HashMap::putAll))
        .build();
  }
}
