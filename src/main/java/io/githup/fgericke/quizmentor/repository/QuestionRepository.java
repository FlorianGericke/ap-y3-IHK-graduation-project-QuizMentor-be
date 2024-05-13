package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.Question;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * QuestionRepository is an interface that extends JpaRepository. It provides methods to perform
 * CRUD operations on the 'questions' table in the database. It uses Question as the entity type and
 * UUID as the ID type.
 */
public interface QuestionRepository extends JpaRepository<Question, UUID> {

}
