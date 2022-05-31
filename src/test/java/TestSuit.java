import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import scenarios.LoginTest;
import scenarios.NoteTest;

@Suite
@SelectClasses({LoginTest.class, NoteTest.class})
public class TestSuit {
}
