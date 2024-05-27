package io.githup.fgericke.quizmentor.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import java.util.UUID;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the UuidUtil class.
 */
class UuidUtilTest {

  /**
   * Test to verify that getIri method returns null when the provided UUID is null.
   */
  @Test
  void getIriReturnsNullWhenUuidIsNull() {
    assertNull(UuidUtil.getIri((UUID) null));
  }

  /**
   * Test to verify that getIri method returns the correct IRI when the provided UUID is not null.
   */
  @Test
  void getIriReturnsIriWhenUuidIsNotNull() {
    UUID uuid = UUID.randomUUID();
    String expectedIri = EnvironmentUtil.getApiBaseUrl() + uuid;
    assertEquals(expectedIri, UuidUtil.getIri(uuid));
  }

  /**
   * Test to verify that getIri method returns null when the provided BaseEntity is null.
   */
  @Test
  void getIriReturnsNullWhenEntityIsNull() {
    assertNull(UuidUtil.getIri((BaseEntity) null));
  }

  /**
   * Test to verify that getIri method returns the correct IRI when the provided BaseEntity is not
   * null.
   */
  @Test
  void getIriReturnsIriWhenEntityIsNotNull() {
    UUID id = UUID.randomUUID();
    BaseEntity entity = new BaseEntity() {
      @Override
      public UUID getId() {
        return id;
      }
    };
    String expectedIri = EnvironmentUtil.getApiBaseUrl() + entity.getId();
    assertEquals(expectedIri, UuidUtil.getIri(entity));
  }

  /**
   * Test to verify that getUuid method returns null when the provided IRI or UUID string is null.
   */
  @Test
  void getUuidReturnsNullWhenIriOrUuidIsNull() {
    assertNull(UuidUtil.getUuid(null));
  }

  /**
   * Test to verify that getUuid method returns null when the provided IRI or UUID string is blank.
   */
  @Test
  void getUuidReturnsNullWhenIriOrUuidIsBlank() {
    assertNull(UuidUtil.getUuid(""));
  }

  /**
   * Test to verify that getUuid method returns the correct UUID when the provided IRI is valid.
   */
  @Test
  void getUuidReturnsUuidWhenIriIsValid() {
    UUID uuid = UUID.randomUUID();
    String iri = EnvironmentUtil.getApiBaseUrl() + uuid;
    assertEquals(uuid, UuidUtil.getUuid(iri));
  }

  /**
   * Test to verify that getUuid method returns the correct UUID when the provided UUID string is
   * valid.
   */
  @Test
  void getUuidReturnsUuidWhenUuidStringIsValid() {
    UUID uuid = UUID.randomUUID();
    String uuidString = uuid.toString();
    assertEquals(uuid, UuidUtil.getUuid(uuidString));
  }
}
