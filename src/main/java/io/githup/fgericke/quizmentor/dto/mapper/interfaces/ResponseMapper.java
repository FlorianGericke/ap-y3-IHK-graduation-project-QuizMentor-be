package io.githup.fgericke.quizmentor.dto.mapper.interfaces;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;

/**
 * This is a functional interface that represents a generic mapper. It's designed to convert or map
 * one type of object (I) into another type of object (R). This interface is used throughout the
 * application wherever a conversion between two types is needed.
 *
 * @param <I> the type of input object to be mapped. It extends BaseEntity, which means it is an
 *            entity object.
 * @param <R> the type of result object after mapping. This is the type of the DTO object that the
 *            entity will be converted to.
 */
@FunctionalInterface
public interface ResponseMapper<I extends BaseEntity, R> {

  /**
   * This method is used to convert an entity object into a DTO object.
   *
   * @param input the entity object that needs to be converted into a DTO object
   * @return the DTO object that represents the provided entity object
   */
  R toDto(I input);
}
