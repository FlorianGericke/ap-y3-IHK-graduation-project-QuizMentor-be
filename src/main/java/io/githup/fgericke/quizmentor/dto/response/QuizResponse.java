package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Quiz;
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
 * This class represents the response object for a Quiz. It is annotated with @Component to indicate
 * that it is a Spring component. It implements the ResponseMapper interface, which requires a
 * mapToResponse method.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class QuizResponse implements ResponseMapper<Quiz, QuizResponse> {

  private UUID id;
  private String iri;
  private String title;
  private String description;
  private HashMap<String, String> categories;
  private HashMap<String, String> questions;
  private String ownerIri;
  private Visibility status;

  /**
   * This method maps a Quiz entity to a QuizResponse object. It uses the builder pattern to create
   * a new QuizResponse object. It uses the UuidUtil class to convert the UUIDs of the Quiz, its
   * categories, and its questions to IRIs. It returns the created QuizResponse object.
   *
   * @param input The Quiz entity to map to a QuizResponse object.
   * @return The created QuizResponse object.
   */
  @Override
  public QuizResponse mapToResponse(final Quiz input) {
    return QuizResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIriFromBaseEntity(input))
        .title(input.getTitle())
        .description(input.getDescription())
        .questions(input.getQuestions().stream().map(UuidUtil::getIriFromBaseEntity)
            .collect(HashMap::new, (m, v) -> m.put(v, v), HashMap::putAll))
        .categories(input.getCategories().stream().map(UuidUtil::getIriFromBaseEntity)
            .collect(HashMap::new, (m, v) -> m.put(v, v), HashMap::putAll))
        .ownerIri(UuidUtil.getIriFromBaseEntity(input.getOwner()))
        .build();
  }
}
