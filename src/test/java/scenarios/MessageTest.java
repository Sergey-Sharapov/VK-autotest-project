package scenarios;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.User;

public class MessageTest extends AbstractTest{
    private final User user = new User.UserBuilder()
            .withLogin("79681897921")
            .withPassword("test2022")
            .withFullName("Тест Тестов")
            .build();

    @BeforeEach
    public void init(){
        mainPage = loginPage.login(user);
        Assumptions.assumeTrue(mainPage.isUserNameCorrect(user), "Имя user не совпадает с ожидаемым.");
    }

    @Test
    public void sendMessage(){

    }
}
