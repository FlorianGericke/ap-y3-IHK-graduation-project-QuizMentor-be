package io.githup.fgericke.quizmentor.entities;

import io.githup.fgericke.quizmentor.entities.abstracts.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.type.SqlTypes;

/**
 * This is an entity class that represents a Quiz.
 * It extends the BaseEntity class and includes additional fields specific to a Quiz.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * Lombok annotations are used to automatically generate getters, setters, toString, builder, and constructors.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "quiz")
@SQLDelete(sql = "UPDATE quiz SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@AllArgsConstructor
@NoArgsConstructor
public class Quiz extends BaseEntity {

  /**
   * The title of the quiz.
   * It is a unique field and cannot be null.
   */
  @Column(name = "title", nullable = false, unique = true)
  private String title;

  /**
   * The description of the quiz.
   */
  @Column(name = "description")
  @JdbcTypeCode(SqlTypes.LONGVARCHAR)
  private String description;

  /**
   * The visibility status of the quiz.
   * It cannot be null and is represented as an enumeration.
   */
  @Enumerated
  @Column(name = "visibility", nullable = false)
  private Visibility visibility;

  // todo Add Created From When User is Implemented
}
