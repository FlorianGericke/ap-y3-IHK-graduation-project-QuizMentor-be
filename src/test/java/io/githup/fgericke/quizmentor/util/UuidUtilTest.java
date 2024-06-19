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
   * Test to verify that getIri method returns null when the provided BaseEntity is null.
   */
  @Test
  void getIriReturnsNullWhenEntityIsNull() {
    assertNull(UuidUtil.getIri(null));
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
