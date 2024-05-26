package io.githup.fgericke.quizmentor.entity;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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
 * This is an entity class that represents a User. It extends the BaseEntity class and includes
 * additional fields specific to a User. It is annotated with @Entity, indicating that it is a JPA
 * entity. Lombok annotations are used to automatically generate getters, setters, toString,
 * builder, and constructors.
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET deleted_at = current_date WHERE id=?")
@Where(clause = "deleted_at IS NULL")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

  /**
   * The email of the user. It is a unique field and cannot be null.
   */
  @Column(name = "mail", nullable = false, unique = true)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String mail;

  /**
   * The password of the user. It cannot be null.
   */
  @Column(name = "password", nullable = false)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private String password;

  /**
   * The role of the user. It cannot be null and is represented as an enumeration.
   */
  @Enumerated
  @Column(name = "role", nullable = false)
  private Role role;

  /**
   * The set of questions created by the user. It is a one-to-many relationship with the Question
   * entity.
   */
  @Builder.Default
  @OneToMany(mappedBy = "createdFrom", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Question> questions = new ArrayList<>();

  /**
   * A set of solutions created by this user. This is a one-to-many relationship, meaning that each
   * user can create multiple solutions. The 'mappedBy = "createdFrom"' attribute indicates that the
   * 'createdFrom' field in the Solution entity is the owning side of the relationship. The 'cascade
   * = CascadeType.ALL' attribute means that any changes made to the user entity will also be
   * reflected in the associated solutions. The 'orphanRemoval = true' attribute ensures that when a
   * solution is removed from this set, it will also be removed from the database. The solutions are
   * stored in a LinkedHashSet to maintain insertion order and to avoid duplicate solutions.
   */
  @Builder.Default
  @OneToMany(mappedBy = "createdFrom", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Solution> solutions = new ArrayList<>();

  @Builder.Default
  @OneToMany(mappedBy = "reviewedFrom", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Answer> answers = new ArrayList<>();


  /**
   * The set of quizzes owned by the user. It is a one-to-many relationship with the Quiz entity.
   * The 'mappedBy = "owner"' attribute indicates that the 'owner' field in the Quiz entity is the
   * owning side of the relationship. The 'orphanRemoval = true' attribute ensures that when a quiz
   * is removed from this set, it will also be removed from the database. The quizzes are stored in
   * a LinkedHashSet to maintain insertion order and to avoid duplicate quizzes.
   */
  @Builder.Default
  @OneToMany(mappedBy = "owner", orphanRemoval = true)
  private List<Quiz> quizzes = new ArrayList<>();
}
