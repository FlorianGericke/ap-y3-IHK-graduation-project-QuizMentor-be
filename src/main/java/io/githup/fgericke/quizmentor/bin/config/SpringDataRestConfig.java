package io.githup.fgericke.quizmentor.bin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * This is the SpringDataRestCustomization class. It customizes the configuration for Spring Data
 * REST. It is annotated with @Configuration, meaning it's a configuration class in the Spring
 * framework. It implements the RepositoryRestConfigurer interface, which allows customization of
 * the Spring Data REST configuration.
 */
@Configuration
public class SpringDataRestConfig implements RepositoryRestConfigurer {

  /**
   * This method configures the RepositoryRestConfiguration and CorsRegistry. It disables the
   * default exposure of all repositories and then calls the super implementation.
   *
   * @param config the RepositoryRestConfiguration object
   * @param cors   the CorsRegistry object
   */
  @Override
  public void configureRepositoryRestConfiguration(
      final RepositoryRestConfiguration config,
      final CorsRegistry cors) {
    // Disable the default exposure of all repositories
    config.disableDefaultExposure();

    // Call the super implementation
    RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
  }
}
