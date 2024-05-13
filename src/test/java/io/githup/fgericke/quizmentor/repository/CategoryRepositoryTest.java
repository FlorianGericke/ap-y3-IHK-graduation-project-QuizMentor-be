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

//ToDo : Create a Test Environment to Test against a test database

@DataJpaTest
public class CategoryRepositoryTest {

  @Autowired
  private CategoryRepository categoryRepository;

  private UUID id;
  private Category category;

  @BeforeEach
  public void setUp() {
    category = new Category();
    category.setName("Test Category");
    category = categoryRepository.save(category);
    id = category.getId();
  }

  @Test
  public void shouldFindCategoryById() {
    Optional<Category> foundCategory = categoryRepository.findById(id);
    assertThat(foundCategory).isPresent();
    assertThat(foundCategory.get().getName()).isEqualTo(category.getName());
  }

  @Test
  @Disabled
  public void shouldNotFindCategoryByNonExistingId() {
    Optional<Category> foundCategory = categoryRepository.findById(UUID.randomUUID());
    assertThat(foundCategory).isNotPresent();
  }

  @Test
  public void shouldDeleteCategoryById() {
    categoryRepository.deleteById(id);
    Optional<Category> foundCategory = categoryRepository.findById(id);
    assertThat(foundCategory).isNotPresent();
  }
}
