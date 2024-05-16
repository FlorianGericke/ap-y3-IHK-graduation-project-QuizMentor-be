package io.githup.fgericke.quizmentor.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import java.util.UUID;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the UuidUtil class. It tests the methods getIriFromUuid and
 * getIriFromBaseEntity. The tests cover both the happy path and edge cases.
 */
class UuidUtilTest {

  /**
   * This test checks the behavior of the getIriFromUuid method when the input is null. The expected
   * behavior is that the method should return null.
   */
  @Test
  void getIriFromUuidReturnsNullWhenUuidIsNull() {
    assertNull(UuidUtil.getIriFromUuid(null));
  }

  /**
   * This test checks the behavior of the getIriFromUuid method when the input is a valid UUID. The
   * expected behavior is that the method should return the IRI representation of the UUID.
   */
  @Test
  void getIriFromUuidReturnsIriWhenUuidIsNotNull() {
    UUID uuid = UUID.randomUUID();
    String expectedIri = EnvironmentUtil.getApiBaseUrl() + uuid;
    assertEquals(expectedIri, UuidUtil.getIriFromUuid(uuid));
  }

  /**
   * This test checks the behavior of the getIriFromBaseEntity method when the input is null. The
   * expected behavior is that the method should return null.
   */
  @Test
  void getIriFromBaseEntityReturnsNullWhenEntityIsNull() {
    assertNull(UuidUtil.getIriFromBaseEntity(null));
  }

  /**
   * This test checks the behavior of the getIriFromBaseEntity method when the input is a valid
   * BaseEntity. The expected behavior is that the method should return the IRI representation of
   * the BaseEntity's ID.
   */
  @Test
  void getIriFromBaseEntityReturnsIriWhenEntityIsNotNull() {
    UUID id = UUID.randomUUID();
    BaseEntity entity = new BaseEntity() {
      @Override
      public UUID getId() {
        return id;
      }
    };
    String expectedIri = EnvironmentUtil.getApiBaseUrl() + entity.getId();
    assertEquals(expectedIri, UuidUtil.getIriFromBaseEntity(entity));
  }
}
