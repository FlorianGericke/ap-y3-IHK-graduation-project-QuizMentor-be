package io.githup.fgericke.quizmentor.bin.filter;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.githup.fgericke.quizmentor.bin.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * This class contains unit tests for the JwtAuthenticationFilter. It uses the JUnit 5 and Mockito
 * frameworks for testing and mocking respectively.
 */
public class JwtAuthenticationFilterTest {

  // Mocked JwtService for testing
  @Mock
  private JwtService jwtService;

  // Mocked UserDetailsService for testing
  @Mock
  private UserDetailsService userDetailsService;

  // Mocked HttpServletRequest for testing
  @Mock
  private HttpServletRequest request;

  // Mocked HttpServletResponse for testing
  @Mock
  private HttpServletResponse response;

  // Mocked FilterChain for testing
  @Mock
  private FilterChain filterChain;

  // The JwtAuthenticationFilter that will be tested
  @InjectMocks
  private JwtAuthenticationFilter jwtAuthenticationFilter;

  /**
   * This method is run before each test. It initializes the mocks that will be used in the tests.
   */
  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  /**
   * This test checks the doFilterInternal method of the JwtAuthenticationFilter when there is no
   * authorization header. It asserts that the filter chain continues.
   */
  @DisplayName("Should continue filter chain when no authorization header")
  @Test
  public void shouldContinueFilterChainWhenNoAuthorizationHeader() throws Exception {
    when(request.getHeader("Authorization")).thenReturn(null);

    jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

    verify(filterChain, times(1)).doFilter(request, response);
  }

  /**
   * This test checks the doFilterInternal method of the JwtAuthenticationFilter when the
   * authorization header does not start with "Bearer". It asserts that the filter chain continues.
   */
  @DisplayName("Should continue filter chain when authorization header does not start with Bearer")
  @Test
  public void shouldContinueFilterChainWhenAuthorizationHeaderDoesNotStartWithBearer()
      throws Exception {
    when(request.getHeader("Authorization")).thenReturn("Basic abc123");

    jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

    verify(filterChain, times(1)).doFilter(request, response);
  }

  /**
   * This test checks the doFilterInternal method of the JwtAuthenticationFilter when the JWT is
   * invalid. It asserts that the filter chain continues.
   */
  @DisplayName("Should continue filter chain when JWT is invalid")
  @Test
  public void shouldContinueFilterChainWhenJwtIsInvalid() throws Exception {
    when(request.getHeader("Authorization")).thenReturn("Bearer abc123");
    when(jwtService.extractUserName("abc123")).thenReturn("user");
    when(userDetailsService.loadUserByUsername("user")).thenReturn(null);

    jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

    verify(filterChain, times(1)).doFilter(request, response);
  }

  /**
   * This test checks the doFilterInternal method of the JwtAuthenticationFilter when the JWT is
   * valid. It asserts that the filter chain continues and the authentication is set.
   */
  @DisplayName("Should set authentication when JWT is valid")
  @Test
  public void shouldSetAuthenticationWhenJwtIsValid() throws Exception {
    when(request.getHeader("Authorization")).thenReturn("Bearer abc123");
    when(jwtService.extractUserName("abc123")).thenReturn("user");
    when(userDetailsService.loadUserByUsername("user")).thenReturn(mock(UserDetails.class));
    when(jwtService.isTokenValid(any(), any())).thenReturn(true);

    jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

    verify(filterChain, times(1)).doFilter(request, response);
  }
}
