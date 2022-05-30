import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import scenarios.LoginTest;

@Suite
@SelectClasses({LoginTest.class})
public class TestSuit {
}
