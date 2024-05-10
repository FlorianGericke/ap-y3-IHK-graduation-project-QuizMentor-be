package io.githup.fgericke.quizmentor.entities;

/**
 * This is an enumeration that represents the visibility status of a quiz. A quiz can be in one of
 * the following states: DRAFT, PUBLISHED.
 */
public enum Visibility {
  /**
   * This state represents a quiz that is still being created and is not visible to others.
   */
  DRAFT,

  /**
   * This state represents a quiz that has been completed and is visible to others.
   */
  PUBLISHED,
}
