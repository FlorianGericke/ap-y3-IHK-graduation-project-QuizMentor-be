package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.Quiz;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * QuizRepository is an interface that extends JpaRepository. It provides methods to perform CRUD
 * operations on the 'quizzes' table in the database. It uses Quiz as the entity type and UUID as
 * the ID type.
 */
public interface QuizRepository extends JpaRepository<Quiz, UUID> {

}
