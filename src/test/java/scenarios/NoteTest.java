package scenarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.User;

public class NoteTest extends AbstractTest{
    private User user = new User.UserBuilder()
            .withLogin("79681897921")
            .withPassword("test2022")
            .withFullName("Тест Тестов")
            .build();

    @Test
    public void makeNote() {
        MainPage mainPage = loginPage.login(user);
        Assertions.assertTrue(mainPage.isUserNameCorrect(user), "Имя user не совпадает с ожидаемым.");

        String text = "text";
        mainPage.openPostingField().sendTextToNewPost(text).clickPostButton();
        Assertions.assertEquals(text, mainPage.textOfPostNumber(1));
    }
}
