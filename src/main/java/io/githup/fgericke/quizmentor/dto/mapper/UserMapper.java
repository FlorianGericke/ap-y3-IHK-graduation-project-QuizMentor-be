package io.githup.fgericke.quizmentor.dto.mapper;

import io.githup.fgericke.quizmentor.dto.mapper.interfaces.RequestMapper;
import io.githup.fgericke.quizmentor.dto.mapper.interfaces.ResponseMapper;
import io.githup.fgericke.quizmentor.dto.requests.UserRequest;
import io.githup.fgericke.quizmentor.dto.response.UserResponse;
import io.githup.fgericke.quizmentor.entity.Answer;
import io.githup.fgericke.quizmentor.entity.Question;
import io.githup.fgericke.quizmentor.entity.Quiz;
import io.githup.fgericke.quizmentor.entity.Solution;
import io.githup.fgericke.quizmentor.entity.User;
import io.githup.fgericke.quizmentor.exception.MissingMandatoryFieldException;
import io.githup.fgericke.quizmentor.service.AnswerService;
import io.githup.fgericke.quizmentor.service.QuestionService;
import io.githup.fgericke.quizmentor.service.QuizService;
import io.githup.fgericke.quizmentor.service.SolutionService;
import io.githup.fgericke.quizmentor.util.UuidUtil;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for mapping between UserRequest and User entity and vice versa. It
 * implements RequestMapper and ResponseMapper interfaces.
 */
@Component
public class UserMapper implements
    RequestMapper<
        UserRequest,
        User
        >,
    ResponseMapper<
        User,
        UserResponse
        > {

  // Service for handling Solution related operations
  private final SolutionService solutionService;

  // Service for handling Quiz related operations
  private final QuizService quizService;

  // Service for handling Question related operations
  private final QuestionService questionService;

  // Service for handling Answer related operations
  private final AnswerService answerService;

  private final PasswordEncoder passwordEncoder;

  /**
   * Constructor for UserMapper.
   *
   * @param solutionService Service for handling Solution related operations
   * @param quizService     Service for handling Quiz related operations
   * @param questionService Service for handling Question related operations
   * @param answerService   Service for handling Answer related operations
   * @param passwordEncoder Service for handling password encoding
   */
  @Autowired
  public UserMapper(@Lazy final SolutionService solutionService,
      @Lazy final QuizService quizService,
      @Lazy final QuestionService questionService,
      @Lazy final AnswerService answerService,
      @Lazy final PasswordEncoder passwordEncoder) {
    this.solutionService = solutionService;
    this.quizService = quizService;
    this.questionService = questionService;
    this.answerService = answerService;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * Converts a UserRequest to a User entity.
   *
   * @param input The UserRequest to convert
   * @return The converted User entity
   * @throws MissingMandatoryFieldException if any mandatory fields are missing in the input
   */
  @Override
  public User toEntity(final UserRequest input) {
    if (StringUtils.isBlank(input.getMail())) {
      throw new MissingMandatoryFieldException("mail");
    }
    if (StringUtils.isBlank(input.getPassword())) {
      throw new MissingMandatoryFieldException("password");
    }

    List<Answer> answers =
        input.getAnswers() != null && answerService != null
            ? input.getAnswers().stream()
            .map(UuidUtil::getUuid).map(answerService::getReference)
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

    List<Question> questions =
        input.getQuestions() != null && questionService != null
            ? input.getQuestions().stream()
            .map(UuidUtil::getUuid).map(questionService::getReference)
            .toList()
            : null;

    User re = User.builder()
        .mail(input.getMail())
        .password(passwordEncoder.encode(input.getPassword()))
        .role(input.getRole())
        .answers(answers)
        .solutions(solutions)
        .quizzes(quizzes)
        .questions(questions)
        .build();

    if (questions != null) {
      for (Question question : questions) {
        question.setCreatedFrom(re);
      }
    }

    if (quizzes != null) {
      for (Quiz quiz : quizzes) {
        quiz.setOwner(re);
      }
    }

    if (solutions != null) {
      for (Solution solution : solutions) {
        solution.setCreatedFrom(re);
      }
    }

    if (answers != null) {
      for (Answer answer : answers) {
        answer.setOwner(re);
      }
    }

    return re;
  }

  /**
   * Converts a User entity to a UserResponse.
   *
   * @param input The User entity to convert
   * @return The converted UserResponse, or null if the input is null
   */
  @Override
  public UserResponse toDto(final User input) {
    return input == null ? null : UserResponse.builder()
        .mail(input.getMail())
        .role(input.getRole())
        .build();
  }
}
