package io.githup.fgericke.quizmentor.entities.abstracts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the BaseEntity class.
 * It tests the state transitions and the timestamps set during these transitions.
 */
public class BaseEntityTest {
  /**
   * The entity under test.
   */
  private BaseEntity baseEntity;

  /**
   * This method sets up the test environment before each test.
   * It creates a new instance of BaseEntity.
   */
  @BeforeEach
  void setUp() {
    baseEntity = new BaseEntity() {};
  }

  /**
   * This test checks if the state of a new entity is CREATED.
   */
  @Test
  void givenNewEntity_whenCheckedState_thenStateIsCreated() {
    assertEquals(EntityState.CREATED, baseEntity.getState());
  }

}
