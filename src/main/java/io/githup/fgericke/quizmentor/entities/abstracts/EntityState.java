package io.githup.fgericke.quizmentor.entities.abstracts;

/**
 * This is an enumeration that represents the possible states of an entity. An entity can be in one
 * of the following states: CREATED, UPDATED, or DELETED.
 */
public enum EntityState {
  /**
   * This state represents a newly created entity.
   */
  CREATED,

  /**
   * This state represents an entity that has been deleted.
   */
  DELETED,

  /**
   * This state represents an entity that has been updated.
   */
  UPDATED
}
