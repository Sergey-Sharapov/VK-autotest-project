package scenarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import utils.User;

public class LoginTest extends AbstractTest {

    private final User user = new User.UserBuilder()
            .withLogin("79681897921")
            .withPassword("test2022")
            .withFullName("Тест Тестов")
            .build();

    @Test
    public void login() {
        Assertions.assertTrue(loginPage.login(user).isUserNameCorrect(user), "Имя user не совпадает с ожидаемым.");
    }
}
