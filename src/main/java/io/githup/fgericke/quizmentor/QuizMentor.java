package io.githup.fgericke.quizmentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The QuizMentor application. This is a Spring Boot application. Spring Boot makes it easy to
 * create stand-alone, production-grade applications.
 */
@SpringBootApplication
public class QuizMentor {

  /**
   * The entry point of the QuizMentor application.
   *
   * @param args The arguments of the program.
   */
  public static void main(final String[] args) {
    // Run the Spring Boot application
    SpringApplication.run(QuizMentor.class, args);
  }
}
