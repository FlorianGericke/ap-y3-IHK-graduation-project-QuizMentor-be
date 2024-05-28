package io.githup.fgericke.quizmentor.bin.config;

import io.githup.fgericke.quizmentor.bin.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * The SecurityConfiguration class is responsible for configuring the security settings of the
 * application. It is annotated with @Configuration and @EnableWebSecurity to indicate that it is a
 * configuration class and to enable Spring Security's web security support respectively. It is also
 * annotated with @RequiredArgsConstructor to generate a constructor that takes all final fields as
 * parameters.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  /**
   * The JwtAuthenticationFilter is used to authenticate requests with JWTs.
   */
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  /**
   * The AuthenticationProvider is used to authenticate requests.
   */
  private final AuthenticationProvider authenticationProvider;

  /**
   * This method configures the security filter chain. It disables CSRF protection, configures the
   * request matchers, sets the session creation policy to STATELESS, sets the authentication
   * provider, and adds the JwtAuthenticationFilter.
   *
   * @param httpSecurity the HttpSecurity to modify
   * @return a SecurityFilterChain with the specified configuration
   * @throws Exception if an error occurs
   */
  @Bean
  public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        // Disable CSRF protection
        .csrf(AbstractHttpConfigurer::disable)
        // Configure the request matchers
        .authorizeHttpRequests(auth ->
            auth.requestMatchers(
                    AntPathRequestMatcher.antMatcher("/api/v1/auth/login"),
                    AntPathRequestMatcher.antMatcher("/swagger-ui/**"),
                    AntPathRequestMatcher.antMatcher("/swagger-ui.html"),
                    AntPathRequestMatcher.antMatcher("/v3/**")
                ).permitAll()
                .anyRequest().authenticated()
        )
        // Set the session creation policy
        .sessionManagement(httpSecuritySessionManagementConfigurer ->
            httpSecuritySessionManagementConfigurer.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS))
        // Set the authentication provider
        .authenticationProvider(authenticationProvider)
        // Add the JwtAuthenticationFilter
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
  }
}
