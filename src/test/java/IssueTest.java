
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


class IssueTest {
    private static String jsonString;

    //Reading the sample-outputput.txt file
    @BeforeAll
    static void runBeforeAllTests() throws Exception {
        jsonString = new String(Files.readAllBytes(Paths.get("src", "test", "java", "sample-output.txt").toAbsolutePath()));

    }

    //Comparing the number of issues in the sample-output.txt file
    @Test
    void testNumberOfIssues() {
        IssueParser parser = new IssueParser(); 
        List<Issue> issues = parser.parseIssues(jsonString);
        Assertions.assertEquals(1, issues.size());
    }

}
