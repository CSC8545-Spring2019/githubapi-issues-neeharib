import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IssuesExporter {

    public static void main(String[] args) throws IOException{
        //Taking username and password from console
        IssuesExporter iExporter = new IssuesExporter();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the GitHub Username: ");
        String gitUserName = s.nextLine();
        System.out.println("Enter the GitHub Password: ");
        String gitPassword = s.nextLine();

        //Creating three users
        User user1 = new User();
        user1.setLogin("Neeharika");
        user1.setId(101);

        User user2 = new User();
        user2.setLogin("Devi Priya");
        user2.setId(102);

        User user3 = new User();
        user3.setLogin("Vamsi");
        user3.setId(103);

        Issue issue1 = new Issue();
        issue1.setNumber(7474);
        issue1.setId(1);
        issue1.setState(IssueState.open);
        issue1.setTitle("Authentication Failure");
        issue1.setBody("There has been failure to login");
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        issue1.setCreatedAt(date);
        Date date1 = new GregorianCalendar(2014, Calendar.MARCH, 21).getTime();
        issue1.setClosedAt(date1);
        issue1.setUser(user1);
        issue1.setAssignee(user2);

        Issue issue2 = new Issue();
        issue2.setNumber(7798);
        issue2.setId(1);
        issue2.setState(IssueState.closed);
        issue2.setTitle("Low Performance");
        issue2.setBody("The perforamnce levels are low");
        Date date3 = new GregorianCalendar(2012, Calendar.JANUARY, 1).getTime();
        issue2.setCreatedAt(date3);
        Date date4 = new GregorianCalendar(2013, Calendar.JUNE, 2).getTime();
        issue2.setClosedAt(date4);
        issue2.setUser(user1);
        issue2.setAssignee(user3);

        Issue issue3 = new Issue();
        issue3.setNumber(7798);
        issue3.setId(1);
        issue3.setState(IssueState.closed);
        issue3.setTitle("Page is not loading");
        issue3.setBody("There is some error while loading the page");
        Date date5 = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
        issue3.setCreatedAt(date5);
        Date date6 = new GregorianCalendar(2010, Calendar.JANUARY, 21).getTime();
        issue3.setClosedAt(date6);
        issue3.setUser(user1);
        issue3.setAssignee(user3);

        //Creating list and storing the issues
        List<Issue> issueList = new ArrayList<Issue>();
        issueList.add(issue1);
        issueList.add(issue2);
        issueList.add(issue3);

        //Printing the issues to output 
        System.out.println("Number of Issues : "+ issueList.size());

        //Implementing issue export to file called issues.txt locally
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "issues.txt");
        File file = new File(filePath.toString());
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            for (Issue issue: issueList) {
                fw.write(issue.toString());
            }
        }catch (IOException e) {
            // TODO: handle exception
            System.out.println(e);
        }finally {
            bw.close();
            fw.close();
        }
    }

}
