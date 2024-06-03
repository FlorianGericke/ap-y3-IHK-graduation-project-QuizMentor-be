package io.githup.fgericke.quizmentor.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the response object for a Category. It is a DTO (Data Transfer Object) that
 * is used to send data over the network. It implements the ResponseMapper interface, which means it
 * can toDto a Category entity to a CategoryResponse. The class is annotated with Lombok annotations
 * to automatically generate getters, builders, and constructors. It is also marked as a Spring
 * component.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

  /**
   * The name of the category. This is a unique identifier for the category.
   */
  private String name;

  /**
   * The IRI (Internationalized Resource Identifier) of the category. This is a unique identifier
   * for the category in the form of an IRI.
   */
  private String iri;

  /**
   * The ID of the category. This is a unique identifier for the category.
   */
  private UUID id;

}
