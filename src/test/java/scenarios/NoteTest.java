package scenarios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.User;

import java.util.Random;

public class NoteTest extends AbstractTest{
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
    public void makeNote() {
        final String text = "Hi there[" + new Random().nextInt() + "]";
        final int LAST_MES_NUM = 1;

        mainPage.openNewNoteLayer().sendTextToNewNote(text).clickPostButton();
        Assertions.assertEquals(text, mainPage.textOfNoteNumber(LAST_MES_NUM));
    }
}
