package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository is an interface that extends JpaRepository. It provides methods to perform CRUD
 * operations on the 'users' table in the database. It uses User as the entity type and UUID as the
 * ID type.
 * <p>
 * JpaRepository is a JPA specific extension of Repository. It contains the full API of
 * CrudRepository and PagingAndSortingRepository. So it contains API for basic CRUD operations and
 * also API for pagination and sorting.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

  /**
   * This method is used to find a user by their email. It returns an Optional that contains the
   * User if found, or empty if not found.
   *
   * @param mail the email of the user to find
   * @return an Optional containing the User if found, or empty if not found
   */
  Optional<User> findByMail(String mail);
}
