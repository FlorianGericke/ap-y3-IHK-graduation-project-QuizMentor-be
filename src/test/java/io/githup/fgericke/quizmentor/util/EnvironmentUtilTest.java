package io.githup.fgericke.quizmentor.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * This class is a test class for the EnvironmentUtil class. It uses Spring Boot's testing support
 * to load the application context and inject dependencies. The API_BASE_URL property is set to
 * "http://localhost:8080/" for the purpose of these tests.
 */
@SpringBootTest
@TestPropertySource(properties = {"API_BASE_URL=http://localhost:8080/"})
class EnvironmentUtilTest {

  /**
   * The EnvironmentUtil instance that is being tested. This instance is automatically injected by
   * Spring Boot.
   */
  @Autowired
  private EnvironmentUtil environmentUtil;

  /**
   * This test verifies that the getApiBaseUrl method of the EnvironmentUtil class returns the
   * correct value. The expected value is "http://localhost:8080/", as set in the TestPropertySource
   * annotation.
   */
  @Test
  @Disabled
  void getApiBaseUrlReturnsCorrectValue() {
    assertEquals("http://localhost:8080/", EnvironmentUtil.getApiBaseUrl());
  }
}
