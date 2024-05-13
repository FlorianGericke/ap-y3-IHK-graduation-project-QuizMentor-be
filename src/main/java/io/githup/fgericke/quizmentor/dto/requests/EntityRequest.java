package io.githup.fgericke.quizmentor.dto.requests;

import io.githup.fgericke.quizmentor.entities.abstracts.BaseEntity;

/**
 * The EntityRequest interface represents a request object that can be converted to an entity. It is
 * a generic interface, where T extends BaseEntity. This means that it can be used with any class
 * that extends BaseEntity. It has a single method, toEntity, which should be implemented to convert
 * the request object to an entity.
 *
 * @param <T> the type of entity that this request can be converted to
 */
public interface EntityRequest<T extends BaseEntity> {

  /**
   * Converts this request object to an entity.
   *
   * @return the entity that this request object represents
   */
  T toEntity();
}
