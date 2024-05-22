package io.githup.fgericke.quizmentor.exception;

import java.util.UUID;
import org.springframework.http.HttpStatus;

/**
 * EntityNotFoundException is a custom exception class that extends the QuizMentorException. It is
 * used to throw exceptions when an entity is not found in the database. The exception includes the
 * HTTP status code 404 and a custom reason that includes the identifier and value of the missing
 * entity.
 */
public class EntityNotFoundException extends QuizMentorException {

  /**
   * Constructs a new EntityNotFoundException with the specified identifier and value. The HTTP
   * status code is set to 404 and the reason includes the identifier and value.
   *
   * @param identifier The identifier of the missing entity.
   * @param value      The value of the missing entity.
   */
  public EntityNotFoundException(
      final String identifier,
      final String value) {
    super(HttpStatus.NOT_FOUND,
        "Entity Not Found Exception: No Entity " + identifier + " \"" + value + "\" found");
  }

  /**
   * Constructs a new EntityNotFoundException with the specified identifier and UUID value. This
   * constructor calls the above constructor with the UUID value converted to a string.
   *
   * @param identifier The identifier of the missing entity.
   * @param value      The UUID value of the missing entity.
   */
  public EntityNotFoundException(
      final String identifier,
      final UUID value) {
    this(identifier, value.toString());
  }

  /**
   * Constructs a new EntityNotFoundException with the specified UUID id. This constructor calls the
   * above constructor with the identifier set to "id" and the UUID id converted to a string.
   *
   * @param id The UUID id of the missing entity.
   */
  public EntityNotFoundException(final UUID id) {
    this("id", id.toString());
  }
}
