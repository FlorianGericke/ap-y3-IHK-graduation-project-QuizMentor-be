package io.githup.fgericke.quizmentor.entity;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.type.SqlTypes;

/**
 * The Answer entity represents an answer given by a user in the QuizMentor application. It extends
 * the BaseEntity class which provides common fields like id, created_at, and updated_at. It is
 * annotated as a JPA Entity, so it maps to a "answer" table in the database.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "answer")
@SQLDelete(sql = "UPDATE answer SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends BaseEntity {

  /**
   * The answer field represents the content of the answer. It is a Lob, which means it can contain
   * a large amount of text.
   */
  @Lob
  @Column(name = "answer", nullable = false)
  @JdbcTypeCode(SqlTypes.LONGVARCHAR)
  private String answer;

  /**
   * The isCorrect field represents whether the answer is correct or not.
   */
  @Column(name = "is_correct")
  @JdbcTypeCode(SqlTypes.BOOLEAN)
  private Boolean isCorrect;

  /**
   * The reviewedFrom field represents the user who reviewed the answer. It is a many-to-one
   * relationship with the User entity.
   */
  @Exclude
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "reviewed_from_id")
  private User reviewedFrom;

  /**
   * The answeredFrom field represents the user who gave the answer. It is a many-to-one
   * relationship with the User entity. This field is mandatory, as indicated by the nullable =
   * false attribute.
   */
  @Exclude
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "answered_from_id", nullable = false)
  private User answeredFrom;
}
