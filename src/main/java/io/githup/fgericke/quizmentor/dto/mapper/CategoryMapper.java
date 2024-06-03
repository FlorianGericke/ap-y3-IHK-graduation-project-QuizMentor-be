package io.githup.fgericke.quizmentor.dto.mapper;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.dto.requests.CategoryRequest;
import io.githup.fgericke.quizmentor.dto.response.CategoryResponse;
import io.githup.fgericke.quizmentor.entity.Category;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping CategoryRequest objects to Category entities and vice
 * versa. It implements the RequestMapper and ResponseMapper interfaces for this purpose. It also
 * validates the input data and throws exceptions if mandatory fields are missing.
 */
@Component
public class CategoryMapper implements
    RequestMapper<
        CategoryRequest,
        Category
        >,
    ResponseMapper<
        Category,
        CategoryResponse
        > {

  private final QuestionService questionService;
  private final QuizService quizService;

  /**
   * Constructor for the CategoryMapper class. It initializes the QuestionService and QuizService.
   *
   * @param questionService the service for question-related operations
   * @param quizService     the service for quiz-related operations
   */
  public CategoryMapper(@Lazy final QuestionService questionService,
      @Lazy final QuizService quizService) {
    this.questionService = questionService;
    this.quizService = quizService;
  }

  /**
   * This method is used to convert a CategoryRequest object into a Category entity. It validates
   * the input data and throws exceptions if mandatory fields are missing.
   *
   * @param input the CategoryRequest object that needs to be converted into a Category entity
   * @return the Category entity that represents the provided CategoryRequest object
   * @throws MissingMandatoryFieldException if a mandatory field is missing in the input data
   */
  @Override
  public Category toEntity(final CategoryRequest input) {
    if (StringUtils.isBlank(input.getName())) {
      throw new MissingMandatoryFieldException("Name");
    }

    List<Question> questions =
        input.getQuestions() != null && questionService != null
            ? input.getQuestions().stream()
            .map(UuidUtil::getUuid).map(questionService::getReference)
            .toList()
            : null;

    List<Quiz> quizzes =
        input.getQuizzes() != null && quizService != null
            ? input.getQuizzes().stream()
            .map(UuidUtil::getUuid).map(quizService::getReference)
            .toList()
            : null;

    Category re = Category.builder()
        .name(input.getName())
        .questions(questions)
        .quizze(quizzes)
        .build();

    if (questions != null) {
      for (Question question : questions) {
        question.getCategories().add(re);
      }
    }

    if (quizzes != null) {
      for (Quiz quiz : quizzes) {
        quiz.getCategories().add(re);
      }
    }

    return re;
  }

  /**
   * This method is used to convert a Category entity into a CategoryResponse object.
   *
   * @param input the Category entity that needs to be converted into a CategoryResponse object
   * @return the CategoryResponse object that represents the provided Category entity, or null if
   * the input is null
   */
  @Override
  public CategoryResponse toDto(final Category input) {
    return input == null ? null : CategoryResponse.builder()
        .name(input.getName())
        .id(input.getId())
        .iri(UuidUtil.getIri(input))
        .build();
  }
}
