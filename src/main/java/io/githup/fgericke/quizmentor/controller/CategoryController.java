package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.mapper.CategoryMapper;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryController is a concrete implementation of the BaseController. It handles HTTP requests
 * related to the Category entity.
 * <p>
 * It extends the BaseController with the following type parameters: - Category as the entity type -
 * CategoryRepository as the repository type - CategoryRequest as the request DTO type -
 * CategoryResponse as the response type - CategoryMapper as the mapper type - CategoryService as
 * the service type
 */
@RestController
@RequestMapping(path = "/api/v1/category")
@Tag(name = "Category", description = "The Category API")
public class CategoryController extends
    BaseController<
        Category,
        CategoryRepository,
        CategoryRequest,
        CategoryResponse,
        CategoryMapper,
        CategoryService
        > {

  /**
   * Constructs a CategoryController with the provided mapper and service.
   *
   * @param mapper  The mapper to be used.
   * @param service The service to be used.
   */
  @Autowired
  public CategoryController(final CategoryMapper mapper, final CategoryService service) {
    super(mapper, service);
  }
}
