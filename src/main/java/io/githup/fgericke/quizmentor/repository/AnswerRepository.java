package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.Answer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AnswerRepository is an interface that extends JpaRepository. It provides methods to perform CRUD
 * operations on the 'answers' table in the database. It uses Answer as the entity type and UUID as
 * the ID type.
 */
public interface AnswerRepository extends JpaRepository<Answer, UUID> {

}
