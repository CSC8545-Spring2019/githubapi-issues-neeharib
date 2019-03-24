
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

//This is a JUnit 4 test - change imports if using JUnit 5
//*IT naming convention means "Integration Test"
public class IssuesExporterIT {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss'Z'");

    private IssuesExporter issuesExporter = new IssuesExporter();

    @Test
    public void testExportIssuesToFileWithNoIssuesYieldsEmptyFile()
            throws IOException {
        List<Issue> issues = getSampleDataEmpty();
        issuesExporter.writeIssuesFile(issues);

        List<String> fileLines = readActualOutputFile();
        assertNotNull(fileLines);
        assertTrue(fileLines.isEmpty());
    }


    @Test
    public void testExportIssuesToFileWithTwoIssuesYieldsTwoLineFile()
            throws IOException, ParseException {
        List<Issue> issues = getSampleData();
        issuesExporter.writeIssuesFile(issues);

        List<String> fileLines = readActualOutputFile();
        assertNotNull(fileLines);
        assertEquals(2, fileLines.size());        
        assertEquals(issues.get(0).toString(), fileLines.get(0));
        assertEquals(issues.get(1).toString(), fileLines.get(1));
    }

    private List<String> readActualOutputFile() throws IOException {
        List<String> issues = new ArrayList<String>();
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        List<String> alllines = Files.readAllLines(Paths.get(currentPath.toString(), "issues.txt"));
        //Wrote extra code to Get expected output with newLine after every attribute of issue.
        int issuescount = alllines.size() / 12;
        int linecount = alllines.size();
        String temptext = "";
        for (int i = 0, j = 0; i < linecount && j < issuescount; i++) {
            temptext = temptext + alllines.get(i)+System.lineSeparator();;
            if ((i + 1) % 12 == 0) {
                issues.add(temptext);
                temptext = "";
                j++;
                continue;
            }
        }
        return issues;
    }

    private List<Issue> getSampleDataEmpty() {
        List<Issue> issues = new ArrayList<Issue>();
        return issues;
    }

    private List<Issue> getSampleData() throws ParseException {
        List<Issue> issues = new ArrayList<Issue>();

        Issue issue1 = new Issue();
        issue1.setAssignee(getTestUser());
        issue1.setBody("body text: the quick brown fox blah blah blah");
        issue1.setCreatedAt(dateFormat.parse("2012-10-24T15:29:23Z"));
        issue1.setClosedAt(null);
        issue1.setId(77000);
        issue1.setNumber(77);
        issue1.setState(IssueState.open);
        issue1.setTitle("this is issue 77 title");
        issue1.setUser(new User());

        Issue issue2 = new Issue();
        issue2.setId(8675309);
        issue2.setNumber(99);
        issue2.setTitle("Life The Universe and Everything");
        issue2.setState(IssueState.open);
        issue2.setUser(new User());
        issue2.setBody("body text: the quick brown fox blah blah blah");
        issue2.setCreatedAt(dateFormat.parse("2012-10-24T15:29:23Z"));
        issue2.setClosedAt(null);
        issue2.setAssignee(getTestUser());

        issues.add(issue1);
        issues.add(issue2);

        return issues;
    }

    private User getTestUser() {
        User userBilbo = new User();
        userBilbo.setId(9999);
        userBilbo.setLogin("bilbo");
        return userBilbo;
    }

}