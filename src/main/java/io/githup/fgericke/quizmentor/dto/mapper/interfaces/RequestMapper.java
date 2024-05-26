package io.githup.fgericke.quizmentor.dto.mapper.interfaces;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;

/**
 * This is a functional interface that represents a generic mapper. It's designed to convert or map
 * one type of object (I) into another type of object (R). This interface is used throughout the
 * application wherever a conversion between two types is needed.
 *
 * @param <I> the type of input object to be mapped. This is the type of the DTO object that will be
 *            converted to an entity.
 * @param <R> the type of result object after mapping. It extends BaseEntity, which means it is an
 *            entity object.
 */
@FunctionalInterface
public interface RequestMapper<I, R extends BaseEntity> {

  /**
   * This method is used to convert a DTO object into an entity object.
   *
   * @param input the DTO object that needs to be converted into an entity object
   * @return the entity object that represents the provided DTO object
   */
  R toEntity(I input);
}
