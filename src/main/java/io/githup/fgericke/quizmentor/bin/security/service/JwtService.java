package io.githup.fgericke.quizmentor.bin.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * This class provides services related to JWT (JSON Web Token). It includes methods for generating,
 * validating, and extracting information from JWT.
 */
@Service(value = "jwt_service")
public class JwtService {

    // todo: This API key is just for development and testing, not for production
    private static final String API_SECRET_KEY = "MHcCAQEEIOz5LI8807OyfRfM5XjqfA9hq/9aeABbPYIBe31sl3"
            + "eZoAoGCCqGSM49AwEHoUQDQgAE09I+JA9i4G0K0AuqT9MuGimZ7Od/n273rEIf/l2HqUCgUPXQvd2Uu45q+ikOB"
            + "GJsbw9rNDBeOKdnSsm7nazeFg==";
    private static final SecretKey SECRET_KEY = new SecretKeySpec(API_SECRET_KEY.getBytes(),
            "HmacSHA256");
    private static final long ONE_MINUTE_IN_MILLISECONDS = 1000 * 60;
    private static final long EXPIRATION_TIME_IN_MINUTES = 24 * 60; // 24 hours

    /**
     * Extracts the username from the given JWT token.
     *
     * @param jwtToken the JWT token
     * @return the username extracted from the JWT token
     * @throws Exception if any error occurs during the extraction
     */
    public String extractUserName(final String jwtToken) throws Exception {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    /**
     * Extracts a claim from the given JWT token.
     *
     * @param token          the JWT token
     * @param claimsResolver a function to resolve the claim
     * @param <T>            the type of the claim
     * @return the claim extracted from the JWT token
     * @throws Exception if any error occurs during the extraction
     */
    public <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver)
            throws Exception {
        final Claims jwtClaim = extractAllClaims(token);
        return claimsResolver.apply(jwtClaim);
    }

    /**
     * Generates a JWT token for the given user details.
     *
     * @param userDetails the user details
     * @return the generated JWT token
     */
    public String generateToken(final UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("authority", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return generateToken(claims, userDetails);
    }

    /**
     * Generates a JWT token for the given user details and extra claims.
     *
     * @param extraClaims the extra claims
     * @param userDetails the user details
     * @return the generated JWT token
     */
    public String generateToken(
            final Map<String, Object> extraClaims,
            final UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .signWith(SECRET_KEY)
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(
                        System.currentTimeMillis() + ONE_MINUTE_IN_MILLISECONDS * EXPIRATION_TIME_IN_MINUTES))
                .compact();
    }

    /**
     * Checks if the given JWT token is valid for the given user details.
     *
     * @param token       the JWT token
     * @param userDetails the user details
     * @return true if the JWT token is valid, false otherwise
     * @throws Exception if any error occurs during the validation
     */
    public boolean isTokenValid(
            final String token,
            final UserDetails userDetails) throws Exception {
        final String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Checks if the given JWT token is expired.
     *
     * @param token the JWT token
     * @return true if the JWT token is expired, false otherwise
     * @throws Exception if any error occurs during the check
     */
    private boolean isTokenExpired(final String token) throws Exception {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extracts the expiration date from the given JWT token.
     *
     * @param token the JWT token
     * @return the expiration date extracted from the JWT token
     * @throws Exception if any error occurs during the extraction
     */
    private Date extractExpiration(final String token) throws Exception {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts all claims from the given JWT token.
     *
     * @param jwtToken the JWT token
     * @return the claims extracted from the JWT token
     * @throws Exception if any error occurs during the extraction
     */
    private Claims extractAllClaims(final String jwtToken) throws Exception {
        return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(jwtToken).getPayload();
    }
}
