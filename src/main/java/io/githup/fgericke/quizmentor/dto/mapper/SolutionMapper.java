package io.githup.fgericke.quizmentor.dto.mapper;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.dto.requests.SolutionRequest;
import io.githup.fgericke.quizmentor.dto.response.SolutionResponse;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.UserService;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping between SolutionRequest and Solution entity and vice versa.
 * It implements RequestMapper and ResponseMapper interfaces.
 */
@Component
public class SolutionMapper implements
    RequestMapper<
        SolutionRequest,
        Solution
        >,
    ResponseMapper<
        Solution,
        SolutionResponse
        > {


  // Service for handling User related operations
  private final UserService userService;

  // Service for handling Question related operations
  private final QuestionService questionService;

  /**
   * Constructor for SolutionMapper.
   *
   * @param userService     Service for handling User related operations
   * @param questionService Service for handling Question related operations
   */
  @Autowired
  public SolutionMapper(@Lazy final UserService userService,
      @Lazy final QuestionService questionService) {
    this.userService = userService;
    this.questionService = questionService;
  }

  /**
   * Converts a SolutionRequest to a Solution entity.
   *
   * @param input The SolutionRequest to convert
   * @return The converted Solution entity
   */
  @Override
  public Solution toEntity(final SolutionRequest input) {
    if (StringUtils.isBlank(input.getSolution())) {
      throw new MissingMandatoryFieldException("solution");
    }
    if (StringUtils.isBlank(input.getCreatedFrom())) {
      throw new MissingMandatoryFieldException("createdFrom");
    }
    if (StringUtils.isBlank(input.getQuestion())) {
      throw new MissingMandatoryFieldException("question");
    }

    User user = userService.findByMail(input.getCreatedFrom());

    var re = Solution.builder()
        .solution(input.getSolution())
        .score(input.getScore())
        .createdFrom(user)
        .question(
            input.getQuestion() != null && questionService != null
                ? questionService.get(UuidUtil.getUuid(input.getQuestion()))
                : null)
        .build();

    user.getSolutions().add(re);

    return re;
  }

  /**
   * Converts a Solution entity to a SolutionResponse.
   *
   * @param input The Solution entity to convert
   * @return The converted SolutionResponse, or null if the input is null
   */
  @Override
  public SolutionResponse toDto(final Solution input) {
    return input == null ? null : SolutionResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIri(input))
        .questionIri(UuidUtil.getIri(input.getQuestion()))
        .ownerIri(UuidUtil.getIri(input.getCreatedFrom()))
        .score(input.getScore())
        .solution(input.getSolution())
        .build();
  }
}
