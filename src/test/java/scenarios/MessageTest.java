package scenarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.User;

import java.util.Random;

public class MessageTest extends AbstractTest{
    private final User user = new User.UserBuilder()
            .withLogin("79681897921")
            .withPassword("test2022")
            .withFullName("Тест Тестов")
            .build();

    @BeforeEach
    public void login(){
        mainPage = loginPage.login(user);
        Assumptions.assumeTrue(mainPage.isUserNameCorrect(user), "Имя user не совпадает с ожидаемым.");
    }

    @Test
    public void sendTextMessage(){
        final String textMessage = "“[|]’~<!--@ /*$%^&#*/ ()?>,.*/\\[" + new Random().nextInt() + "]";
        final String chatTitle = "Пустой чат";
        final int mesNumber = 1;

        Assertions.assertTrue(textMessage.equals(mainPage.openMessageLayer()
                                                        .selectChat(chatTitle)
                                                        .inputTextMessage(textMessage)
                                                        .sendMessage()
                                                        .textOfMessageNumber(mesNumber))
        );

    }
}
