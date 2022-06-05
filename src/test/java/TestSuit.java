import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import scenarios.LoginTest;
import scenarios.MessageTest;
import scenarios.NoteTest;

@Suite
@SelectClasses({LoginTest.class, NoteTest.class, MessageTest.class})
public class TestSuit {
}
