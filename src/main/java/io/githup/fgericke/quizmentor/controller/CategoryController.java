package io.githup.fgericke.quizmentor.controller;

// Importing necessary libraries and classes

import io.githup.fgericke.quizmentor.controller.generic.BaseController;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.repository.CategoryRepository;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryController is a REST controller that handles HTTP requests related to Category. It
 * extends BaseController, inheriting common CRUD operations. It is annotated with @RestController,
 * meaning it's a controller where every method returns a domain object instead of a view. It's
 * capable of serving JSON, XML and custom responses.
 */
@RestController
@RequestMapping(path = "/api/v1/category")
@Tag(name = "Category", description = "The Category API")
public class CategoryController extends BaseController<
    Category,
    CategoryRepository,
    CategoryRequest,
    CategoryResponse,
    CategoryService> {

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service          The service to be used. This is typically where the business logic
   *                         resides.
   */
  public CategoryController(final CategoryService service) {
    super(service);
  }
}
