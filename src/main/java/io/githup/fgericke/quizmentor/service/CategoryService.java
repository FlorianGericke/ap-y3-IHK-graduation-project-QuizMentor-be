package io.githup.fgericke.quizmentor.service;

import io.githup.fgericke.quizmentor.dto.mapper.CategoryMapper;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoryService is a service class that extends BaseService. It provides specific implementation
 * for Category related operations.
 */
@Service
public class CategoryService extends BaseService<
    Category,
    CategoryRepository,
    CategoryRequest,
    CategoryMapper
    > {

  /**
   * Constructor for the CategoryService. It initializes the BaseService with the provided
   * CategoryRepository and CategoryMapper.
   *
   * @param repo   The CategoryRepository to be used by the BaseService.
   * @param mapper The CategoryMapper to be used by the BaseService.
   */
  @Autowired
  public CategoryService(final CategoryRepository repo, final CategoryMapper mapper) {
    super(repo, mapper);
  }

  /**
   * Patches the given Category entity using the given CategoryRequest. If the name in the
   * CategoryRequest is not null, it updates the name of the Category entity.
   *
   * @param entityToUpdate  The Category entity to be patched.
   * @param categoryRequest The CategoryRequest with the patch information.
   * @return The patched Category entity.
   */
  @Override
  public Category patch(final Category entityToUpdate, final CategoryRequest categoryRequest) {
    entityToUpdate.setName(
        categoryRequest.getName() != null
            ? categoryRequest.getName()
            : entityToUpdate.getName());
    return entityToUpdate;
  }
}
