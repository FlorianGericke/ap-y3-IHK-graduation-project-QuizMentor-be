package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.Solution;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SolutionRepository is an interface that extends JpaRepository. It provides methods to perform
 * CRUD operations on the 'solutions' table in the database. It uses Solution as the entity type and
 * UUID as the ID type.
 */
public interface SolutionRepository extends JpaRepository<Solution, UUID> {

}
