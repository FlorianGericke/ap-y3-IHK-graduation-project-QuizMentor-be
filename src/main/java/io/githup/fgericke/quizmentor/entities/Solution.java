package io.githup.fgericke.quizmentor.entities;

import io.githup.fgericke.quizmentor.entities.abstracts.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
 * Solution entity represents a solution to a question in the quiz. It extends the BaseEntity class
 * which provides common fields like id, created_at, and updated_at. It is marked as a JPA Entity
 * and mapped to the 'solution' table in the database. It uses the Lombok library to generate
 * getters, setters, toString, builder, and other utility methods. It uses the Hibernate library to
 * define SQL operations and constraints.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "solution")
@SQLDelete(sql = "UPDATE solution SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@AllArgsConstructor
@NoArgsConstructor
public class Solution extends BaseEntity {

  /**
   * The solution text. It is a required field in the database.
   */
  @Column(name = "solution", nullable = false)
  @JdbcTypeCode(SqlTypes.LONGVARCHAR)
  private String solution;

  /**
   * The question to which this solution belongs. It is a many-to-one relationship, meaning that
   * each solution belongs to one question.
   */
  @Exclude
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "question_id")
  private Question question;

  /**
   * The score of the solution. It is an optional field in the database.
   */
  @Column(name = "score")
  @Builder.Default
  private Integer score = 0;

  /**
   * The user who created this solution. It is a many-to-one relationship, meaning that each
   * solution is created by one user.
   */
  @Exclude
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "created_from_id")
  private User createdFrom;

  /**
   * The user who reviewed this solution. It is a one-to-one relationship, meaning that each
   * solution is reviewed by one user.
   */
  @Exclude
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "reviewed_from")
  private User reviewedFrom;

  /**
   * Checks if the solution is correct based on its score. A solution is considered correct if its
   * score is greater than or equal to 1.
   *
   * @return true if the solution is correct, false otherwise.
   */
  public boolean isCorrect() {
    return score >= 1;
  }
}
