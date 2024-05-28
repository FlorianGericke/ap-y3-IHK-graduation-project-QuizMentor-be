package io.githup.fgericke.quizmentor.dto.mapper;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.dto.requests.QuestionRequest;
import io.githup.fgericke.quizmentor.dto.response.QuestionResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.CategoryService;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.githup.fgericke.quizmentor.service.SolutionService;
import io.githup.fgericke.quizmentor.service.UserService;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping between QuestionRequest and Question entity and vice versa.
 * It implements RequestMapper and ResponseMapper interfaces.
 */
@Component
public class QuestionMapper implements
    RequestMapper<
        QuestionRequest,
        Question
        >,
    ResponseMapper<
        Question,
        QuestionResponse
        > {

  // Service for handling Category related operations
  private final CategoryService categoryService;

  // Service for handling Solution related operations
  private final SolutionService solutionService;

  // Service for handling Quiz related operations
  private final QuizService quizService;
  private final UserService userService;

  /**
   * Constructor for QuestionMapper.
   *
   * @param categoryService Service for handling Category related operations
   * @param solutionService Service for handling Solution related operations
   * @param quizService     Service for handling Quiz related operations
   * @param userService     Service for handling User related operations
   */
  public QuestionMapper(@Lazy final CategoryService categoryService,
      @Lazy final SolutionService solutionService,
      @Lazy final QuizService quizService,
      @Lazy final UserService userService) {
    this.categoryService = categoryService;
    this.solutionService = solutionService;
    this.quizService = quizService;
    this.userService = userService;
  }

  /**
   * Converts a QuestionRequest to a Question entity.
   *
   * @param input The QuestionRequest to convert
   * @return The converted Question entity
   */
  @Override
  public Question toEntity(final QuestionRequest input) {
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

    List<Solution> solutions =
        input.getSolutions() != null && solutionService != null
            ? input.getSolutions().stream()
            .map(UuidUtil::getUuid).map(solutionService::getReference)
            .toList()
            : null;

    List<Quiz> quizzes =
        input.getQuizzes() != null && quizService != null
            ? input.getQuizzes().stream()
            .map(UuidUtil::getUuid).map(quizService::getReference)
            .toList()
            : null;

    User user = userService.findByMail(input.getCreatedFrom());

    Question re = Question.builder()
        .status(input.getStatus())
        .title(input.getTitle())
        .description(input.getDescription())
        .createdFrom(user)
        .categories(categories)
        .solutions(solutions)
        .quizzes(quizzes)
        .status(input.getStatus())
        .score(input.getScore())
        .build();

    if (categories != null) {
      for (Category category : categories) {
        category.getQuestions().add(re);
      }
    }

    if (quizzes != null) {
      for (Quiz quiz : quizzes) {
        quiz.getQuestions().add(re);
      }
    }

    if (solutions != null) {
      for (Solution solution : solutions) {
        solution.setQuestion(re);
      }
    }
    user.getQuestions().add(re);

    return re;
  }

  /**
   * Converts a Question entity to a QuestionResponse.
   *
   * @param input The Question entity to convert
   * @return The converted QuestionResponse
   */
  @Override
  public QuestionResponse toDto(final Question input) {
    return input == null ? null : QuestionResponse.builder()
        .id(input.getId())
        .iri(UuidUtil.getIri(input))
        .title(input.getTitle())
        .description(input.getDescription())
        .isOpen(input.isOpenQuestion())
        .score(input.getScore())
        .status(input.getStatus())
        .solutions(input.getSolutions() == null
            ? null
            : input.getSolutions().stream().map(UuidUtil::getIri)
                .toList())
        .answers(input.getAnswers() == null
            ? null
            : input.getAnswers().stream().map(UuidUtil::getIri)
            .toList())
        .build();
  }
}
