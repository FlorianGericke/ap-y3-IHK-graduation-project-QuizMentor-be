package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository is an interface that extends JpaRepository. It provides methods to perform CRUD
 * operations on the 'users' table in the database. It uses User as the entity type and UUID as the
 * ID type.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

}
