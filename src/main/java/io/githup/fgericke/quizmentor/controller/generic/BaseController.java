package io.githup.fgericke.quizmentor.controller.generic;

import io.githup.fgericke.quizmentor.dto.requests.EntityRequest;
import io.githup.fgericke.quizmentor.dto.response.ResponseMapper;
import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import java.util.UUID;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Abstract base controller providing CRUD operations for a generic entity.
 *
 * @param <Type>       The type of the entity.
 * @param <Repository> The repository for the entity.
 * @param <Request>    The request DTO for the entity.
 * @param <Response>   The response DTO for the entity.
 * @param <Service>    The service for the entity.
 */
public abstract class BaseController<
    Type extends BaseEntity,
    Repository extends JpaRepository<Type, UUID>,
    Request extends EntityRequest<Type>,
    Response extends ResponseMapper<Type, Response>,
    Service extends BaseService<Type, Repository, Request, Response>
    > {

  private final Service enittService;

  /**
   * Constructs a BaseController with the provided service and response.
   *
   * @param service The service to be used.
   */
  public BaseController(final Service service) {
    this.enittService = service;
  }

  /**
   * Handles the POST request to create a new entity.
   *
   * @param request The request body containing the entity data.
   * @return The created entity.
   */
  @PostMapping(produces = "application/json")
  public @ResponseBody Response postEntity(@ParameterObject final Request request) {
    return enittService.post(request);
  }

  /**
   * Handles the GET request to retrieve all entities.
   *
   * @param pageable The pagination information.
   * @return A page of entities.
   */
  @GetMapping(produces = "application/json")
  public @ResponseBody Page<Response> getEntities(
      @ParameterObject @RequestBody final Pageable pageable
  ) {
    return enittService.getAll(pageable);
  }

  /**
   * Handles the GET request to retrieve a specific entity by its ID.
   *
   * @param id The ID of the entity.
   * @return The requested entity.
   */
  @GetMapping(path = "/{id}", produces = "application/json")
  public @ResponseBody Response getEntity(@PathVariable final UUID id) {
    return enittService.get(id);
  }

  /**
   * Handles the PUT request to update a specific entity by its ID.
   *
   * @param id      The ID of the entity.
   * @param request The request body containing the updated entity data.
   * @return The updated entity.
   */
  @PutMapping(path = "/{id}", produces = "application/json")
  public @ResponseBody Response putEntity(
      @PathVariable final UUID id,
      @ParameterObject @RequestBody final Request request) {
    return enittService.put(id, request);
  }

  /**
   * Handles the PATCH request to partially update a specific entity by its ID.
   *
   * @param id      The ID of the entity.
   * @param request The request body containing the updated entity data.
   * @return The updated entity.
   */
  @PatchMapping(path = "/{id}", produces = "application/json")
  public @ResponseBody Response patchEntity(
      @PathVariable final UUID id,
      @ParameterObject @RequestBody final Request request) {
    return enittService.patch(id, request);
  }

  /**
   * Handles the DELETE request to delete a specific entity by its ID.
   *
   * @param id The ID of the entity.
   * @return The deleted entity.
   */
  public @ResponseBody Response deleteEntity(@PathVariable final UUID id) {
    return enittService.delete(id);
  }
}
