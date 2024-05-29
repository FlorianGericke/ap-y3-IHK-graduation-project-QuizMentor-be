package io.githup.fgericke.quizmentor.entity;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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
 * Category entity class. This class is a JPA entity class that represents the 'category' table in
 * the database. It extends the BaseEntity class which contains common fields for all entities. It
 * uses Lombok annotations for boilerplate code reduction.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "category")
@SQLDelete(sql = "UPDATE category SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {

  /**
   * The name of the category. It is a unique field and cannot be null.
   */
  @Column(name = "name", nullable = false, unique = true)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String name;

  /**
   * The quizzes that belong to this category. It is a many-to-many relationship, meaning that each
   * category can have multiple quizzes, and each quiz can belong to multiple categories. The
   * 'quizze' in mappedBy indicates that the 'quizze' field in the Quiz entity owns the relationship
   * (contains the foreign key). The CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH
   * indicates that if a Category entity is persisted, merged, or refreshed, the same operation will
   * be applied to the Quiz entity. The @Builder.Default annotation is used to initialize the
   * 'quizze' field with an empty set of Quiz.
   */
  @Builder.Default
  @ManyToMany()
  @JoinTable(name = "category_quizzes",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "quizzes_id"))
  private List<Quiz> quizze = new ArrayList<>();

  /**
   * The questions that belong to this category. It is a many-to-many relationship, meaning that
   * each category can have multiple questions, and each question can belong to multiple categories.
   * The 'questions' in mappedBy indicates that the 'questions' field in the Question entity owns
   * the relationship (contains the foreign key). The CascadeType.PERSIST, CascadeType.MERGE,
   * CascadeType.REFRESH indicates that if a Category entity is persisted, merged, or refreshed, the
   * same operation will be applied to the Question entity. The
   *
   * @Builder.Default annotation is used
   */
  @Exclude
  @Builder.Default
  @ManyToMany()
  @JoinTable(name = "category_questions",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "questions_id"))
  private List<Question> questions = new ArrayList<>();
}
