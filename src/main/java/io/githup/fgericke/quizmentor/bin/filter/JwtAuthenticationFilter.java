package io.githup.fgericke.quizmentor.bin.filter;

import io.githup.fgericke.quizmentor.bin.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JwtAuthenticationFilter is a filter that handles JWT-based authentication. It extends
 * OncePerRequestFilter to ensure the filter is executed once per request.
 */
@Component(value = "jwt_authentication_filter")
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  // JwtService is used to handle operations related to JWTs
  private final JwtService jwtService;
  // UserDetailsService is used to retrieve user details
  private final UserDetailsService userDetailsService;
  // The index where the token starts in the Authorization header
  private static final int BEARER_TOKEN_START_INDEX = 7;

  /**
   * This method is called once per request and handles the authentication process. It extracts the
   * JWT from the request, validates it, and sets the authentication in the SecurityContext.
   *
   * @param request     the HttpServletRequest
   * @param response    the HttpServletResponse
   * @param filterChain the FilterChain
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @SneakyThrows
  @Override
  protected void doFilterInternal(
      final HttpServletRequest request,
      final HttpServletResponse response,
      final FilterChain filterChain) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwtToken;
    final String userEmail;

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    // token always start at index 7
    jwtToken = authHeader.substring(BEARER_TOKEN_START_INDEX);
    userEmail = jwtService.extractUserName(jwtToken);

    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

      if (jwtService.isTokenValid(jwtToken, userDetails)) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        authenticationToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }

    filterChain.doFilter(request, response);
  }
}
