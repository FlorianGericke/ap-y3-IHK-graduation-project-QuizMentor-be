package io.githup.fgericke.quizmentor.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Utility class for accessing environment variables. This class is marked as a Spring component, so
 * it can be autowired where needed. It provides a getter for the API base URL, which is loaded from
 * the environment variable API_BASE_URL.
 */
@Component
public class EnvironmentUtil {

  /**
   * The API base URL. This is a static field, so it can be accessed directly without needing an
   * instance of EnvironmentUtil. It is loaded from the environment variable API_BASE_URL.
   */
  @Getter
  private static String apiBaseUrl;

  /**
   * Constructor for the EnvironmentUtil class. This constructor is marked with the Autowired
   * annotation, so Spring will automatically use it to create an instance of EnvironmentUtil. The
   * API_BASE_URL environment variable is injected into the constructor using the Value annotation.
   *
   * @param apiBaseUrl the API base URL, loaded from the environment variable API_BASE_URL
   */
  @Autowired
  public EnvironmentUtil(@Value("${API_BASE_URL}") final String apiBaseUrl) {
    EnvironmentUtil.apiBaseUrl = apiBaseUrl;
  }
}
