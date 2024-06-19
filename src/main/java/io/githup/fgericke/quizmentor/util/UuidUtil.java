package io.githup.fgericke.quizmentor.util;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/**
 * Utility class for handling UUIDs. This class provides methods to convert UUIDs and BaseEntity
 * objects to IRIs.
 */
public class UuidUtil {


  /**
   * Converts a BaseEntity object to an IRI. If the provided BaseEntity object is null, the method
   * returns null. Otherwise, it returns the IRI representation of the BaseEntity's ID, which is the
   * API base URL concatenated with the BaseEntity's ID.
   *
   * @param entity the BaseEntity object to be converted to an IRI
   * @param <E>    the type of BaseEntity
   * @return the IRI representation of the BaseEntity's ID, or null if the BaseEntity is null
   */
  public static <E extends BaseEntity> String getIri(final E entity) {
    return entity == null ? null
        : EnvironmentUtil.getApiBaseUrl() + entity.getClass().getSimpleName().toLowerCase() +
            "/" + entity.getId();
  }

  /**
   * Converts an IRI or UUID string to a UUID. If the provided IRI or UUID string is null or blank,
   * the method returns null. Otherwise, it returns the UUID representation of the IRI or UUID
   * string, which is the UUID extracted from the string.
   *
   * @param iriOrUuid the IRI or UUID string to be converted to a UUID
   * @return the UUID representation of the IRI or UUID string, or null if the string is null or
   * blank
   */
  public static UUID getUuid(final String iriOrUuid) {
    if (StringUtils.isBlank(iriOrUuid)) {
      return null;
    }

    final String[] parts = iriOrUuid.split("/");
    final String uuidString = parts[parts.length - 1];
    return UUID.fromString(uuidString);
  }
}
