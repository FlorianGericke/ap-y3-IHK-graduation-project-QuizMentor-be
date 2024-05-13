package io.githup.fgericke.quizmentor.entity.generic;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * This is an abstract class that represents a base entity.
 * It includes common fields and operations that are shared by all entities.
 */
@MappedSuperclass
public abstract class BaseEntity {

  /**
   * The unique identifier for the entity.
   */
  @Id
  @Getter
  @Setter
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(unique = true, nullable = false)
  private UUID id;

  /**
   * The timestamp when the entity was created.
   */
  @Column(name = "created_at", nullable = false)
  @Getter
  @Setter
  private LocalDateTime createdAt;

  /**
   * The timestamp when the entity was last updated.
   */
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  /**
   * The timestamp when the entity was deleted.
   */
  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

  /**
   * This method is called before the entity is persisted.
   * It sets the createdAt timestamp.
   */
  @PrePersist
  private void onPrePersist() {
    this.createdAt = LocalDateTime.now();
  }

  /**
   * This method is called before the entity is updated.
   * It sets the updatedAt timestamp if the entity is not deleted.
   */
  @PreUpdate
  private void onPreUpdate() {
    if (deletedAt != null) {
      return;
    }
    this.updatedAt = LocalDateTime.now();
  }

  /**
   * This method is called before the entity is removed.
   * It sets the deletedAt timestamp.
   */
  @PreRemove
  private void onPostRemove() {
    this.deletedAt = LocalDateTime.now();
  }

  /**
   * This method returns the current state of the entity.
   * The state can be CREATED, UPDATED, or DELETED.
   * @return the current state of the entity.
   */
  protected EntityState getState() {
    if (deletedAt != null) {
      return EntityState.DELETED;
    }
    if (updatedAt != null) {
      return EntityState.UPDATED;
    }
    return EntityState.CREATED;
  }
}
