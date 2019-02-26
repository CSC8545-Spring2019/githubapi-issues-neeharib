import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class IssueParserTest {

    private static String jsonString;

    // Reading the sample-outputput.txt file
    @BeforeClass
    public static void runBeforeAllTests() throws Exception {
        jsonString = new String(
                Files.readAllBytes(Paths.get("src", "test", "java", "sample-output.txt").toAbsolutePath()));

    }

    // Comparing the number of issues in the sample-output.txt file
    @Test
    public void testNumberOfIssues() {
        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues(jsonString);
        assertEquals(1, issues.size());

    }

    @Test
    public void testInvalidParseText() {
        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues("ABCD");
        assertEquals(0, issues.size());
    }

    @Test
    public void testParams() {
        IssueParser parser = new IssueParser();
        List<Issue> issues = parser.parseIssues(jsonString);
        Issue i = issues.get(0);
        User user1 = new User();
        User user2 = new User();
        user1.setLogin("neeharib");
        user1.setId(43053258);
        user2.setLogin("ms-O");
        user2.setId(6319957);
        assertEquals(1, i.number);
        assertEquals(406184863, i.id);
        assertEquals("Manually created issue - Login page", i.title);
        assertEquals(IssueState.closed, i.state);
        assertEquals(
                "**Found bugs while creating the login page like credentials are not working.**\r\n\r\nThere is some authentication failure while creating the credentials.",
                i.body);

        assertEquals(user2, i.assignee);
        assertEquals(user1, i.user);
    }
}
