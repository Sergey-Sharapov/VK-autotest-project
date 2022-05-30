package scenarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.LoginPage;
import utils.User;

public class LoginTest extends AbstractTest {

    private User user = new User.UserBuilder()
            .withLogin("79681897921")
            .withPassword("test2022")
            .withFullName("Тест Тестов")
            .build();

    @Test
    public void login()
    {
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.login(user).isUserNameCorrect(user), "Имя не совпадает с ожидаемым.");
    }
}
