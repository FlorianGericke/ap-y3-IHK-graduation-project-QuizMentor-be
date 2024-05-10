import io.githup.fgericke.quizmentor.entities.User;
import io.githup.fgericke.quizmentor.entities.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the User entity.
 */
class UserTest {

  /**
   * The User instance that will be used in the tests.
   */
  private User user;

  /**
   * This method sets up the User instance before each test.
   */
  @BeforeEach
  void setUp() {
    user = User.builder()
        .mail("test@mail.com")
        .password("password")
        .role(Role.TRAINEE)
        .build();
  }

  /**
   * This test checks if the mail of a new User is correct.
   */
  @Test
  void givenNewUser_whenCheckedMail_thenMailIsCorrect() {
    assertEquals("test@mail.com", user.getMail());
  }

  /**
   * This test checks if the password of a new User is correct.
   */
  @Test
  void givenNewUser_whenCheckedPassword_thenPasswordIsCorrect() {
    assertEquals("password", user.getPassword());
  }

  /**
   * This test checks if the role of a new User is correct.
   */
  @Test
  void givenNewUser_whenCheckedRole_thenRoleIsUser() {
    assertEquals(Role.TRAINEE, user.getRole());
  }

  /**
   * This test checks if the role of a User is updated correctly.
   */
  @Test
  void givenUser_whenRoleChanged_thenRoleIsUpdated() {
    user.setRole(Role.TRAINER);
    assertEquals(Role.TRAINER, user.getRole());
  }

  /**
   * This test checks if the username of a User is correct.
   */
  @Test
  void givenUser_whenUsernameChecked_thenUsernameIsMail() {
    assertEquals("test@mail.com", user.getUsername());
  }

  /**
   * This test checks if the account of a User is not expired.
   */
  @Test
  void givenUser_whenCheckedAccountNonExpired_thenReturnsTrue() {
    assertTrue(user.isAccountNonExpired());
  }

  /**
   * This test checks if the account of a User is not locked.
   */
  @Test
  void givenUser_whenCheckedAccountNonLocked_thenReturnsTrue() {
    assertTrue(user.isAccountNonLocked());
  }

  /**
   * This test checks if the credentials of a User are not expired.
   */
  @Test
  void givenUser_whenCheckedCredentialsNonExpired_thenReturnsTrue() {
    assertTrue(user.isCredentialsNonExpired());
  }

  /**
   * This test checks if the account of a User is enabled.
   */
  @Test
  void givenUser_whenCheckedEnabled_thenReturnsTrue() {
    assertTrue(user.isEnabled());
  }
}
