package io.githup.fgericke.quizmentor.entity;

import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User extends BaseEntity implements UserDetails {

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
  @OneToMany(mappedBy = "createdFrom")
  private List<Question> questions = new ArrayList<>();

  /**
   * The set of solutions created by the user. It is a one-to-many relationship with the Solution
   * entity.
   */
  @Builder.Default
  @OneToMany(mappedBy = "createdFrom")
  private List<Solution> solutions = new ArrayList<>();

  /**
   * The set of answers reviewed by the user. It is a one-to-many relationship with the Answer
   * entity.
   */
  @Builder.Default
  @OneToMany(mappedBy = "reviewedFrom")
  private List<Answer> answers = new ArrayList<>();


  /**
   * The set of quizzes created by the user. It is a one-to-many relationship with the Quiz entity.
   */
  @Builder.Default
  @OneToMany(mappedBy = "createdFrom")
  private List<Quiz> quizzes = new ArrayList<>();

  /**
   * This method is used to get the authorities of the user. In this case, the role is used as the
   * authority.
   *
   * @return a collection of authorities for the user.
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(role.name()));
    return authorities;
  }

  /**
   * This method is used to get the username of the user. In this case, the email is used as the
   * username.
   *
   * @return a string representing the username of the user.
   */
  @Override
  public String getUsername() {
    return getMail();
  }

  /**
   * This method is used to check if the account is not expired.
   *
   * @return a boolean value indicating whether the account is not expired.
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * This method is used to check if the account is not locked.
   *
   * @return a boolean value indicating whether the account is not locked.
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * This method is used to check if the credentials are not expired.
   *
   * @return a boolean value indicating whether the credentials are not expired.
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * This method is used to check if the account is enabled.
   *
   * @return a boolean value indicating whether the account is enabled.
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
