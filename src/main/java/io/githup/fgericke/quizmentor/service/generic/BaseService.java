package io.githup.fgericke.quizmentor.service.generic;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import io.githup.fgericke.quizmentor.exception.EntityNotFoundException;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * BaseService is an abstract class that provides a generic implementation for common service
 * operations. It is parameterized by the type of the entity, repository, request DTO, and response
 * DTO.
 *
 * @param <Type>       The type of the entity.
 * @param <Repository> The type of the repository.
 * @param <RequestDto> The type of the request DTO.
 * @param <Mapper>     The type of the mapper.
 */
@Getter
public abstract class BaseService<
    Type extends BaseEntity,
    Repository extends JpaRepository<Type, UUID>,
    RequestDto,
    Mapper extends RequestMapper<RequestDto, Type>
    > {

  // The repository to be used by this service
  @Getter
  private final Repository repository;

  // The mapper to be used by this service
  @Getter
  private final Mapper mapper;

  /**
   * Constructs a new BaseService with the given repository and mapper.
   *
   * @param repo   The repository to be used by this service.
   * @param dtoMapper The mapper to be used by this service.
   */
  public BaseService(final Repository repo, final Mapper dtoMapper) {
    this.repository = repo;
    this.mapper = dtoMapper;
  }

  /**
   * Saves the given request DTO to the repository and returns the saved entity.
   *
   * @param requestDto The request DTO to be saved.
   * @return The saved entity.
   */
  @Transactional
  public Type post(final RequestDto requestDto) {
    return repository.save(mapper.toEntity(requestDto));
  }

  /**
   * Returns all entities in the repository as a page.
   *
   * @param pageable The pagination information.
   * @return A page of entities.
   */
  public Page<Type> getAll(final Pageable pageable) {
    return repository.findAll(pageable);
  }

  /**
   * Returns all entities in the repository as a list.
   *
   * @return A list of entities.
   */
  public List<Type> getAll() {
    return repository.findAll();
  }

  /**
   * Returns the entity with the given ID.
   *
   * @param id The ID of the entity.
   * @return The entity.
   * @throws EntityNotFoundException if the entity is not found.
   */
  public Type get(final UUID id) {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id));
  }

  /**
   * Returns a reference to the entity with the given ID.
   *
   * @param id The ID of the entity.
   * @return A reference to the entity.
   */
  public Type getReference(final UUID id) {
    return repository.getReferenceById(id);
  }

  /**
   * Updates the entity with the given ID using the given request DTO and returns the updated
   * entity.
   *
   * @param id         The ID of the entity.
   * @param requestDto The request DTO with the updated information.
   * @return The updated entity.
   * @throws EntityNotFoundException if the entity is not found.
   */
  @Transactional
  public Type put(final UUID id, final RequestDto requestDto) {
    var old = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    Type next = mapper.toEntity(requestDto);
    next.setId(id);
    next.setCreatedAt(old.getCreatedAt());
    return repository.save(next);
  }

  /**
   * Patches the entity with the given ID using the given request DTO and returns the patched
   * entity.
   *
   * @param id         The ID of the entity.
   * @param requestDto The request DTO with the patch information.
   * @return The patched entity.
   * @throws EntityNotFoundException if the entity is not found.
   */
  @Transactional
  public Type patch(final UUID id, final RequestDto requestDto) {
    repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    var entity = repository.getReferenceById(id);
    return repository.save(patch(entity, requestDto));
  }

  /**
   * Patches the given entity using the given request DTO. This method is abstract and should be
   * implemented by subclasses.
   *
   * @param entityToUpdate The entity to be patched.
   * @param requestDto     The request DTO with the patch information.
   * @return The patched entity.
   */
  @Transactional
  public abstract Type patch(Type entityToUpdate, RequestDto requestDto);

  /**
   * Deletes the entity with the given ID and returns the deleted entity.
   *
   * @param id The ID of the entity.
   * @return The deleted entity.
   * @throws EntityNotFoundException if the entity is not found.
   */
  @Transactional
  public Type delete(final UUID id) {
    Type entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    repository.deleteById(id);
    return entity;
  }

  /**
   * Returns all entities with the given IDs.
   *
   * @param ids The IDs of the entities.
   * @return A list of entities.
   */
  public List<Type> getAllByIds(final List<UUID> ids) {
    return repository.findAllById(ids);
  }

  /**
   * Saves the given entity to the repository.
   *
   * @param entity The entity to be saved.
   */
  public void save(final Type entity) {
    repository.save(entity);
  }

  /**
   * Returns the entity with the given IRI.
   *
   * @param iri The IRI of the entity.
   * @return The entity.
   * @throws EntityNotFoundException if the entity is not found.
   */
  public Type get(final String iri) {
    return get(UuidUtil.getUuid(iri));
  }
}
