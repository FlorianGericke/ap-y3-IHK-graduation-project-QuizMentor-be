package io.githup.fgericke.quizmentor.dto.mapper;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuizRequest;
import io.githup.fgericke.quizmentor.dto.response.QuizResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.UserService;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping between QuizRequest and Quiz entity and vice versa. It
 * implements RequestMapper and ResponseMapper interfaces.
 */
@Component
public class QuizMapper implements
    RequestMapper<
        QuizRequest,
        Quiz
        >,
    ResponseMapper<
        Quiz,
        QuizResponse
        > {

  // Service for handling Category related operations
  private final CategoryService categoryService;

  // Service for handling User related operations
  private final UserService userService;

  // Service for handling Question related operations
  private final QuestionService questionService;

  /**
   * Constructor for QuizMapper.
   *
   * @param categoryService Service for handling Category related operations
   * @param userService     Service for handling User related operations
   * @param questionService Service for handling Question related operations
   */
  public QuizMapper(@Lazy final CategoryService categoryService,
      @Lazy final UserService userService,
      @Lazy final QuestionService questionService) {
    this.categoryService = categoryService;
    this.userService = userService;
    this.questionService = questionService;
  }

  /**
   * Converts a QuizRequest to a Quiz entity.
   *
   * @param input The QuizRequest to convert
   * @return The converted Quiz entity
   * @throws MissingMandatoryFieldException if any mandatory fields are missing in the input
   */
  @Override
  public Quiz toEntity(final QuizRequest input) {
    if (StringUtils.isEmpty(input.getTitle())) {
      throw new MissingMandatoryFieldException("Title");
    }
    if (input.getCategories() == null || input.getCategories().isEmpty()) {
      throw new MissingMandatoryFieldException("Categories");
    }

    List<Category> categories =
        categoryService != null
            ? input.getCategories().stream()
            .map(UuidUtil::getUuid).map(categoryService::getReference)
            .toList()
            : null;

    List<Question> questions =
        input.getQuestions() != null && questionService != null
            ? input.getQuestions().stream()
            .map(UuidUtil::getUuid).map(questionService::getReference)
            .toList()
            : null;

    User user = userService.findByMail(input.getCreatedFrom());

    Quiz re = Quiz.builder()
        .title(input.getTitle())
        .description(input.getDescription())
        .visibility(input.getStatus())
        .categories(categories)
        .questions(questions)
        .createdFrom(user)
        .build();

    if (categories != null) {
      for (Category category : categories) {
        category.getQuizze().add(re);
      }
    }

    if (questions != null) {
      for (Question question : questions) {
        question.getQuizzes().add(re);
      }
    }

    user.getQuizzes().add(re);

    return re;
  }

  /**
   * Converts a Quiz entity to a QuizResponse.
   *
   * @param input The Quiz entity to convert
   * @return The converted QuizResponse, or null if the input is null
   */
  @Override
  public QuizResponse toDto(final Quiz input) {
    return input == null ? null : QuizResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIri(input))
        .title(input.getTitle())
        .description(input.getDescription())
        .questions(input.getQuestions() == null
            ? null
            : input.getQuestions().stream().map(UuidUtil::getIri)
                .toList())
        .categories(input.getCategories() == null
            ? null
            : input.getCategories().stream().map(UuidUtil::getIri)
                .toList())
        .ownerIri(UuidUtil.getIri(input.getCreatedFrom()))
        .build();
  }
}

