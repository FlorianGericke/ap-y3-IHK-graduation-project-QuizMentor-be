/**
 * CategoryRepository is an interface that extends JpaRepository. It provides methods to perform
 * CRUD operations on the Category entity. It is annotated with @Repository, indicating that it's a
 * Spring Data Repository.
 *
 * @author Florian Gericke
 */
package io.githup.fgericke.quizmentor.repository;

import io.githup.fgericke.quizmentor.entity.Category;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
  // JpaRepository provides JPA related methods to perform CRUD operations
  // and it will be auto-implemented by Spring into a bean called categoryRepository.
}
