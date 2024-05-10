package io.githup.fgericke.quizmentor.entities;

import io.githup.fgericke.quizmentor.entities.abstracts.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
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
 * Question entity class. This class is a JPA entity class that represents the 'question' table in
 * the database. It extends the BaseEntity class which contains common fields for all entities.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "question")
@SQLDelete(sql = "UPDATE question SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@AllArgsConstructor
@NoArgsConstructor
public class Question extends BaseEntity {

  /**
   * The user who created the question. It is a many-to-one relationship, meaning that each question
   * can be created by one user, and each user can create multiple questions.
   */
  @Exclude
  @ManyToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "created_from_id", nullable = false)
  private User createdFrom;

  /**
   * The quizzes that contain this question. It is a many-to-many relationship, meaning that each
   * question can be in multiple quizzes, and each quiz can contain multiple questions.
   */
  @Exclude
  @Default
  @ManyToMany(mappedBy = "questions", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REFRESH, CascadeType.DETACH})
  private Set<Quiz> quizzes = new LinkedHashSet<>();

  /**
   * The score of the question. It is an integer value and can be null.
   */
  @Default
  @Column(name = "score", nullable = false)
  @JdbcTypeCode(SqlTypes.INTEGER)
  private Integer score = null;

  /**
   * The visibility status of the question. It is an enumerated type and can be one of the values
   * defined in the Visibility enum.
   */
  @Enumerated
  @Default
  @Column(name = "status", nullable = false)
  private Visibility status = Visibility.DRAFT;

  /**
   * The categories that this question belongs to. It is a many-to-many relationship, meaning that
   * each question can belong to multiple categories, and each category can contain multiple
   * questions.
   */
  @Builder.Default
  @ManyToMany(mappedBy = "questions", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REFRESH, CascadeType.DETACH})
  private Set<Category> categories = new LinkedHashSet<>();

  /**
   * This method checks if the question is an open question. It returns true if the score is not
   * null, and false otherwise.
   */
  public boolean isOpenQuestion() {
    return score != null;
  }
}
