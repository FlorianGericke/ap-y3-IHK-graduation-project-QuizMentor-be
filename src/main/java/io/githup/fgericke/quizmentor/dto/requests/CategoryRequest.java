package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

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
public class CategoryRequest implements EntityRequest<Category> {

  /**
   * The name of the category. This is the only field in the request, as a category only has a
   * name.
   */
  private String name;

  /**
   * Converts this CategoryRequest to a Category entity. This is used when the request is received,
   * and we need to convert it to an entity to persist it in the database.
   *
   * @return a Category entity with the same name as this request.
   */
  @Override
  public Category toEntity() {
    if (getName() == null) {
      // todo implement Custom Exceptions
      throw new ResponseStatusException(HttpStatusCode.valueOf(500),
          "[Category] Name cannot be null");
    }
    return Category.builder().name(getName()).build();
  }
}
