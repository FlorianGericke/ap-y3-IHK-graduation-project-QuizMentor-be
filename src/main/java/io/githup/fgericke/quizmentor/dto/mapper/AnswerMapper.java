package io.githup.fgericke.quizmentor.dto.mapper;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.dto.requests.AnswerRequest;
import io.githup.fgericke.quizmentor.dto.response.AnswerResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.UserService;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping AnswerRequest objects to Answer entities and vice versa. It
 * implements the RequestMapper and ResponseMapper interfaces for this purpose. It also validates
 * the input data and throws exceptions if mandatory fields are missing.
 */
@Component
public class AnswerMapper implements
    RequestMapper<
        AnswerRequest,
        Answer
        >,
    ResponseMapper<
        Answer,
        AnswerResponse
        > {

  private final UserService userService;
  private final QuestionService questionService;

  /**
   * Constructor for the AnswerMapper class. It initializes the UserService and QuestionService.
   *
   * @param userService     the service for user-related operations
   * @param questionService the service for question-related operations
   */
  public AnswerMapper(@Lazy final UserService userService,
      @Lazy final QuestionService questionService) {
    this.userService = userService;
    this.questionService = questionService;
  }

  /**
   * Converts an AnswerRequest object to an Answer entity.
   *
   * @param input the AnswerRequest object to be converted to an Answer entity
   * @return the Answer entity that represents the provided AnswerRequest object
   */
  @Override
  public Answer toEntity(final AnswerRequest input) {
    if (StringUtils.isBlank(input.getAnswer())) {
      throw new MissingMandatoryFieldException("Answer");
    }
    if (StringUtils.isBlank(input.getQuestion())) {
      throw new MissingMandatoryFieldException("Question");
    }
    if (StringUtils.isBlank(input.getCreatedFrom())) {
      throw new MissingMandatoryFieldException("User");
    }

    User user = userService.findByMail(input.getCreatedFrom());

    var re = Answer.builder()
        .answer(input.getAnswer())
        .isCorrect(false)
        .question(input.getQuestion() != null && questionService != null
            ? questionService.get(UuidUtil.getUuid(input.getQuestion()))
            : null)
        .reviewedFrom(null)
        .owner(user)
        .build();

    user.getAnswers().add(re);

    return re;
  }

  /**
   * Converts an Answer entity to an AnswerResponse object.
   *
   * @param input the Answer entity to be converted to an AnswerResponse object
   * @return the AnswerResponse object that represents the provided Answer entity, or null if the
   * input is null
   */
  @Override
  public AnswerResponse toDto(final Answer input) {
    return input == null ? null : AnswerResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIri(input))
        .questionIri(UuidUtil.getIri(input.getQuestion()))
        .reviewedFromIri(UuidUtil.getIri(input.getReviewedFrom()))
        .ownerIri(UuidUtil.getIri(input.getOwner()))
        .answer(input.getAnswer())
        .correct(input.getIsCorrect())
        .build();
  }

}
