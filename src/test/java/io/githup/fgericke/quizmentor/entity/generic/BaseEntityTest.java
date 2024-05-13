package io.githup.fgericke.quizmentor.entity.generic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the BaseEntity class. It tests the state transitions and the
 * timestamps set during these transitions.
 */
public class BaseEntityTest {

  /**
   * The entity under test.
   */
  private BaseEntity baseEntity;

  /**
   * This method sets up the test environment before each test. It creates a new instance of
   * BaseEntity.
   */
  @BeforeEach
  void setUp() {
    baseEntity = new BaseEntity() {
    };
  }

  /**
   * This test checks if the state of a new entity is CREATED.
   */
  @Test
  void givenNewEntityWhenCheckedStateThenStateIsCreated() {
    assertEquals(EntityState.CREATED, baseEntity.getState());
  }

}
