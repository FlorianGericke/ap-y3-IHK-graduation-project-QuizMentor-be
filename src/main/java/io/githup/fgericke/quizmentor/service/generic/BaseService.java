package io.githup.fgericke.quizmentor.service.generic;

import io.githup.fgericke.quizmentor.dto.requests.EntityRequest;
import io.githup.fgericke.quizmentor.dto.response.ResponseMapper;
import io.githup.fgericke.quizmentor.entity.generic.BaseEntity;
import io.githup.fgericke.quizmentor.util.UuidUtil;
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
 * @param <Type>        The type of the entity.
 * @param <Repository>  The type of the repository.
 * @param <RequestDto>  The type of the request DTO.
 * @param <ResponseDto> The type of the response DTO.
 */
@Getter
public abstract class BaseService<
    Type extends BaseEntity,
    Repository extends JpaRepository<Type, UUID>,
    RequestDto extends EntityRequest<Type>,
    ResponseDto extends ResponseMapper<Type, ResponseDto>> {

  @Getter
  private final Repository repository;
  @Getter
  private final ResponseDto responseDto;

  /**
   * Constructs a new BaseService with the given repository and response DTO.
   *
   * @param repo  The repository to be used by this service.
   * @param response The response DTO to be used by this service.
   */
  public BaseService(final Repository repo, final ResponseDto response) {
    this.repository = repo;
    this.responseDto = response;
  }

  /**
   * Saves the given request DTO to the repository and returns the saved entity as a response DTO.
   *
   * @param requestDto The request DTO to be saved.
   * @return The saved entity as a response DTO.
   */
  @Transactional
  public ResponseDto post(final RequestDto requestDto) {
    return responseDto.map(repository.save(requestDto.toEntity()));
  }

  /**
   * Returns all entities in the repository as a page of response DTOs.
   *
   * @param pageable The pagination information.
   * @return A page of response DTOs.
   */
  public Page<ResponseDto> getAll(final Pageable pageable) {
    return repository.findAll(pageable).map(responseDto::map);
  }

  /**
   * Returns the entity with the given ID as a response DTO.
   *
   * @param id The ID of the entity.
   * @return The entity as a response DTO.
   */
  public ResponseDto get(final UUID id) {
    return responseDto.map(repository.findById(id).get());
  }

  /**
   * Updates the entity with the given ID using the given request DTO and returns the updated entity
   * as a response DTO.
   *
   * @param id         The ID of the entity.
   * @param requestDto The request DTO with the updated information.
   * @return The updated entity as a response DTO.
   */
  @Transactional
  public ResponseDto put(final UUID id, final RequestDto requestDto) {
    var old = repository.findById(id).get();
    Type next = requestDto.toEntity();
    next.setId(id);
    next.setCreatedAt(old.getCreatedAt());
    return responseDto.map(repository.save(next));
  }

  /**
   * Patches the entity with the given ID using the given request DTO and returns the patched entity
   * as a response DTO.
   *
   * @param id         The ID of the entity.
   * @param requestDto The request DTO with the patch information.
   * @return The patched entity as a response DTO.
   */
  @Transactional
  public ResponseDto patch(final UUID id, final RequestDto requestDto) {
    repository.findById(id).get();
    var entity = repository.getReferenceById(id);
    return responseDto.map(repository.save(patch(entity, requestDto)));
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
   * Deletes the entity with the given ID and returns the deleted entity as a response DTO.
   *
   * @param id The ID of the entity.
   * @return The deleted entity as a response DTO.
   */
  @Transactional
  public ResponseDto delete(final UUID id) {
    Type entity = repository.findById(id).get();
    repository.deleteById(id);
    return responseDto.map(entity);
  }

  /**
   * Returns the entity with the given IRI as a response DTO.
   *
   * @param iri The IRI of the entity.
   * @return The entity as a response DTO.
   */
  public ResponseDto get(final String iri) {
    return get(UuidUtil.getUuidFromIri(iri));
  }
}
