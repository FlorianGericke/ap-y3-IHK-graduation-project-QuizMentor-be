package io.githup.fgericke.quizmentor;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ServletInitializer class. This class extends SpringBootServletInitializer to
 * support running the application as a traditional WAR file deployed in a web
 * container.
 */
public class ServletInitializer extends SpringBootServletInitializer {

  /**
   * Configure the application. This method is called by Spring Boot to
   * initialize the application when it's run as a standalone servlet
   * container.
   *
   * @param application The SpringApplicationBuilder that is used to create the
   *                    application context.
   * @return The SpringApplicationBuilder with the sources set.
   */
  @Override
  protected SpringApplicationBuilder configure(
      final SpringApplicationBuilder application) {
    return application.sources(QuizMentor.class);
  }
}
