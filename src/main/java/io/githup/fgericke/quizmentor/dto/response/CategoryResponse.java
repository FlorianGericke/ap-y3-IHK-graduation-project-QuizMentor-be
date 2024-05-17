package io.githup.fgericke.quizmentor.dto.response;

import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This class represents the response object for a Category. It is annotated with @Component to
 * indicate that it is a Spring Bean. It implements the ResponseMapper interface to map a Category
 * entity to a CategoryResponse.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class CategoryResponse implements ResponseMapper<Category, CategoryResponse> {

  // The name of the category
  private String name;

  // The IRI (Internationalized Resource Identifier) of the category
  private String iri;

  // The unique identifier of the category
  private UUID id;

  /**
   * This method maps a Category entity to a CategoryResponse. It uses the builder pattern to create
   * a new CategoryResponse object.
   *
   * @param input The Category entity to be mapped.
   * @return A new CategoryResponse object with the data from the input Category.
   */
  @Override
  public CategoryResponse mapToResponse(final Category input) {
    return CategoryResponse.builder()
        .name(input.getName())
        .id(input.getId())
        .iri(UuidUtil.getIriFromBaseEntity(input))
        .build();
  }
}
