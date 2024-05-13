package io.githup.fgericke.quizmentor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import io.githup.fgericke.quizmentor.entity.Category;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * This class contains unit tests for the CategoryRepository class. It tests the basic CRUD
 * operations: find by ID and delete by ID. The tests are currently disabled and need a test
 * environment to run against a test database.
 */
@DataJpaTest
public class CategoryRepositoryTest {

  @Autowired
  private CategoryRepository categoryRepository;

  private UUID id;
  private Category category;

  /**
   * This method sets up the test environment before each test. It initializes a new Category, saves
   * it in the repository, and stores its ID for later use.
   */
  @BeforeEach
  public void setUp() {
    category = new Category();
    category.setName("Test Category");
    category = categoryRepository.save(category);
    id = category.getId();
  }

  /**
   * This test checks the find by ID operation of the CategoryRepository. It verifies that a
   * Category can be found by its ID.
   */
  @Test
  public void shouldFindCategoryById() {
    Optional<Category> foundCategory = categoryRepository.findById(id);
    assertThat(foundCategory).isPresent();
    assertThat(foundCategory.get().getName()).isEqualTo(category.getName());
  }

  /**
   * This test checks the find by ID operation of the CategoryRepository when the ID does not exist.
   * It verifies that a Category cannot be found by a non-existing ID.
   */
  @Test
  @Disabled
  public void shouldNotFindCategoryByNonExistingId() {
    Optional<Category> foundCategory = categoryRepository.findById(UUID.randomUUID());
    assertThat(foundCategory).isNotPresent();
  }

  /**
   * This test checks the delete by ID operation of the CategoryRepository. It verifies that a
   * Category can be deleted by its ID.
   */
  @Test
  public void shouldDeleteCategoryById() {
    categoryRepository.deleteById(id);
    Optional<Category> foundCategory = categoryRepository.findById(id);
    assertThat(foundCategory).isNotPresent();
  }
}
