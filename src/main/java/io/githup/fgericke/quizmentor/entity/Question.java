package io.githup.fgericke.quizmentor.entity;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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
   * The user who created the question. It is a many-to-one relationship, meaning that many
   * questions can be created by one user. The 'created_from_id' column in the 'question' table is
   * the foreign key that references the 'id' column in the 'user' table. The 'createdFrom' field in
   * the User entity is the owning side of the relationship.
   */
  @Exclude
  @ManyToOne()
  @JoinColumn(name = "created_from_id")
  private User createdFrom;

  /**
   * The title of the question. It is a unique field and cannot be null.
   */
  @Column(name = "title", nullable = false, unique = true)
  private String title;

  /**
   * The description of the question. It is an optional field.
   */
  @Column(name = "description")
  private String description;

  /**
   * The text of the question. It is a required field and cannot be null.
   */
  @Exclude
  @Default
  @ManyToMany()
  private List<Quiz> quizzes = new ArrayList<>();

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
   * The categories associated with this question. This is a many-to-many relationship, meaning that
   * each question can have multiple categories, and each category can be associated with multiple
   * questions. The 'categories' in mappedBy indicates that the 'categories' field in the Category
   * entity owns the relationship (contains the foreign key). The CascadeType.PERSIST,
   * CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH indicates that if a Question entity is
   * persisted, merged, refreshed, or detached, the same operation will be applied to the Category
   * entity. The @Builder.Default annotation is used to initialize the 'categories' field with an
   * empty set of Category.
   */
  @Builder.Default
  @ManyToMany()
  private List<Category> categories = new ArrayList<>() {
  };


  /**
   * The solutions associated with this question. This is a one-to-many relationship, meaning that
   * each question can have multiple solutions. The 'mappedBy = "question"' attribute indicates that
   * the 'question' field in the Solution entity is the owning side of the relationship. The
   * 'orphanRemoval = true' attribute ensures that when a solution is removed from this set, it will
   * also be removed from the database. The solutions are stored in an ArrayList to avoid duplicate
   * solutions.
   */
  @Builder.Default
  @OneToMany()
  private List<Solution> solutions = new ArrayList<>();

  /**
   * This method checks if the question is an open question. An open question is defined as a
   * question with a non-null score.
   *
   * @return true if the score is not null, false otherwise.
   */
  public boolean isOpenQuestion() {
    return score != null;
  }

  /**
   * This method checks if the question is a multiple-choice question. A multiple-choice question is
   * defined as a question with a null score.
   *
   * @return true if the score is null, false otherwise.
   */
  @Exclude
  @Builder.Default
  @OneToMany(mappedBy = "question")
  private List<Answer> answers = new ArrayList<>() {
  };
}
