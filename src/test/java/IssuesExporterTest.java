import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.BeforeClass;
import org.junit.Rule;


public class IssuesExporterTest {

    private static List<Issue> issues = new ArrayList<Issue>();
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void runBeforeAllTests() throws Exception {
        IssuesExporter iExporter = new IssuesExporter();
        issues = iExporter.creatingIssues();
    }

    @Test
    public void writeIssuesFileTest() throws IOException {
        IssuesExporter iExporter = new IssuesExporter();
        iExporter.writeIssuesFile(issues);

    }

    @Test
    public void startApplicationTest() throws IOException {
        IssuesExporter iExporter = new IssuesExporter();
        String input = "neeharib\nbuddu@06";
        InputStream firstInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(firstInput);
        iExporter.startApplication();
    }

    @Test
    public void startApplicationTestInvalidCred() throws IOException {
        IssuesExporter iExporter = new IssuesExporter();
        String input = "neehaib\nuddu@06";
        InputStream firstInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(firstInput);
        iExporter.startApplication();
    }
}
