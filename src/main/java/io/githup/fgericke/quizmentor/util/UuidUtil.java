package io.githup.fgericke.quizmentor.util;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import java.util.UUID;

/**
 * Utility class for handling UUIDs. This class provides methods to convert UUIDs and BaseEntity
 * objects to IRIs.
 */
public class UuidUtil {

  /**
   * Converts a UUID to an IRI. If the provided UUID is null, the method returns null. Otherwise, it
   * returns the IRI representation of the UUID, which is the API base URL concatenated with the
   * UUID's string representation.
   *
   * @param id the UUID to be converted to an IRI
   * @return the IRI representation of the UUID, or null if the UUID is null
   */
  public static String getIriFromUuid(final UUID id) {
    return id == null ? null : EnvironmentUtil.getApiBaseUrl() + id;
  }

  /**
   * Converts a BaseEntity object to an IRI. If the provided BaseEntity object is null, the method
   * returns null. Otherwise, it returns the IRI representation of the BaseEntity's ID, which is the
   * API base URL concatenated with the BaseEntity's ID.
   *
   * @param entity the BaseEntity object to be converted to an IRI
   * @param <E> the type of BaseEntity
   * @return the IRI representation of the BaseEntity's ID, or null if the BaseEntity is null
   */
  public static <E extends BaseEntity> String getIriFromBaseEntity(final E entity) {
    return entity == null ? null : getIriFromUuid(entity.getId());
  }


  /**
   * Converts an IRI to a UUID. The IRI should be in the format of an API base URL concatenated with
   * the UUID's string representation. The method extracts the UUID from the IRI and returns it.
   *
   * @param iri the IRI to be converted to a UUID
   * @return the UUID extracted from the IRI
   */
  public static UUID getUuidFromIri(final String iri) {
    return UUID.fromString(iri.substring(iri.lastIndexOf("/") + 1));
  }
}
