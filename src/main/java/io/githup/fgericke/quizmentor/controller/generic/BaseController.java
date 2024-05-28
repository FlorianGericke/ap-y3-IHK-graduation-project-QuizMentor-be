package io.githup.fgericke.quizmentor.controller.generic;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import io.githup.fgericke.quizmentor.service.generic.BaseService;
import java.util.UUID;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * BaseController is an abstract class that provides a template for all controllers.
 * It provides basic CRUD operations for a given entity type.
 *
 * @param <Type> The type of the entity.
 * @param <Repository> The repository associated with the entity type.
 * @param <RequestDto> The DTO used for request data.
 * @param <Response> The type used for response data.
 * @param <Mapper> The mapper used to convert between entity and DTO.
 * @param <Service> The service used to handle business logic.
 */
public abstract class BaseController<
    Type extends BaseEntity,
    Repository extends JpaRepository<Type, UUID>,
    RequestDto,
    Response,
    Mapper extends RequestMapper<RequestDto, Type> & ResponseMapper<Type, Response>,
    Service extends BaseService<Type, Repository, RequestDto, Mapper>
    > {

  private final Service enittService;
  private final Mapper mapper;

  /**
   * Constructs a BaseController with the provided service and mapper.
   *
   * @param mapper The mapper to be used.
   * @param service The service to be used.
   */
  public BaseController(final Mapper mapper, final Service service) {
    this.enittService = service;
    this.mapper = mapper;
  }

  /**
   * Handles the POST request to create a new entity.
   *
   * @param request The request body containing the entity data.
   * @return The created entity.
   */
  @PostMapping(produces = "application/json")
  public @ResponseBody Response postEntity(@ParameterObject final RequestDto request) {
    return mapper.toDto(enittService.post(request));
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
    return enittService.getAll(pageable).map(mapper::toDto);
  }

  /**
   * Handles the GET request to retrieve a specific entity by its ID.
   *
   * @param id The ID of the entity.
   * @return The requested entity.
   */
  @GetMapping(path = "/{id}", produces = "application/json")
  public @ResponseBody Response getEntity(@PathVariable final UUID id) {
    return mapper.toDto(enittService.get(id));
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
      @ParameterObject @RequestBody final RequestDto request) {
    return mapper.toDto(enittService.put(id, request));
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
      @ParameterObject @RequestBody final RequestDto request) {
    return mapper.toDto(enittService.patch(id, request));
  }

  /**
   * Handles the DELETE request to delete a specific entity by its ID.
   *
   * @param id The ID of the entity.
   * @return The deleted entity.
   */
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public @ResponseBody Response deleteEntity(@PathVariable final UUID id) {
    return mapper.toDto(enittService.delete(id));
  }
}
