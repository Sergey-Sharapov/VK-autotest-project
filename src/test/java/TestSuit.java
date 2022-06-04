import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import pages.MessageLayer;
import scenarios.LoginTest;
import scenarios.NoteTest;

@Suite
@SelectClasses({LoginTest.class, NoteTest.class, MessageLayer.class})
public class TestSuit {
}
