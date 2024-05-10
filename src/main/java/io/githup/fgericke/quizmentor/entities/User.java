package io.githup.fgericke.quizmentor.entities;

import io.githup.fgericke.quizmentor.entities.abstracts.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
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
import org.springframework.validation.SimpleErrors;

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

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Quiz> quizzes = new LinkedHashSet<>();

  /**
   * This method returns the authorities granted to the user. It returns a collection of
   * GrantedAuthority, each representing a role of the user.
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.stream(Role.values()).map(SimpleGrantedAuthority.class::cast).toList();
  }

  /**
   * This method returns the username of the user. In this case, the email is used as the username.
   */
  @Override
  public String getUsername() {
    return this.mail;
  }

  /**
   * This method checks if the user's account has not expired. It returns true indicating that the
   * account is valid (not expired).
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * This method checks if the user's account is not locked. It returns true indicating that the
   * account is not locked.
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * This method checks if the user's credentials (password) has not expired. It returns true
   * indicating that the credentials are valid (not expired).
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * This method checks if the user's account is enabled. It returns true indicating that the
   * account is enabled.
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
