import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

public class IssueTest {

    private static Issue issue1 = new Issue();
    private static Issue issue2 = new Issue();
    private static Issue issue3 = new Issue();
    private static User user1 = new User();
    private static User user2 = new User();

    @BeforeClass
    public static void runBeforeAllTests() {

        user1.setLogin("Neeharika");
        user1.setId(1101);

        user2.setLogin("Neeha");
        user2.setId(1121);

        // Issue 1
        issue1.setNumber(7474);
        issue1.setId(112);
        issue1.setState(IssueState.open);
        issue1.setTitle("Authentication Failure");
        issue1.setBody("There has been failure to login");
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        issue1.setCreatedAt(date);
        Date date1 = new GregorianCalendar(2014, Calendar.MARCH, 21).getTime();
        issue1.setClosedAt(date1);
        issue1.setUser(user1);
        issue1.setAssignee(user2);

        // Issue 2
        issue2.setNumber(7798);
        issue2.setId(113);
        issue2.setState(IssueState.closed);
        issue2.setTitle("Low Performance");
        issue2.setBody("The perforamnce levels are low");
        Date date3 = new GregorianCalendar(2012, Calendar.JANUARY, 1).getTime();
        issue2.setCreatedAt(date3);
        Date date4 = new GregorianCalendar(2013, Calendar.JUNE, 2).getTime();
        issue2.setClosedAt(date4);
        issue2.setUser(user1);
        issue2.setAssignee(user2);

        // Issue 3
        issue3.setNumber(7798);
        issue3.setId(112);
        issue3.setState(IssueState.closed);
        issue3.setTitle("Page is not loading");
        issue3.setBody("There is some error while loading the page");
        Date date5 = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
        issue3.setCreatedAt(date5);
        Date date6 = new GregorianCalendar(2010, Calendar.JANUARY, 21).getTime();
        issue3.setClosedAt(date6);
        issue3.setUser(user1);
        issue3.setAssignee(user2);
    }

    @Test
    public void testToString() {
        String expected = "------- Issue Details----------------\r\n" + "number: 7474\r\n" + "id : 112\r\n"
                + "state : open\r\n" + "title : Authentication Failure\r\n"
                + "body : There has been failure to login\r\n" + "createdAt : Tue Feb 11 00:00:00 EST 2014\r\n"
                + "closedAt : Fri Mar 21 00:00:00 EDT 2014\r\n" + "User : Neeharika\r\n" + "Assignee : Neeha\r\n"
                + "------------------------------\r\n\r\n";
        assertEquals(expected, issue1.toString());
    }

    @Test
    public void testEquals() {
        Issue i1 = new Issue();
        Issue i2 = new Issue();
        i1.setId(100);
        i2.setId(100);
        assertTrue(i1.equals(i2));

        Issue i3 = new Issue();
        i1.setId(10);
        assertFalse(i3.equals(i2));
    }

    @Test
    public void testHashCode() {
        Issue i1 = new Issue();
        Issue i2 = new Issue();
        i1.setId(100);
        i2.setId(100);
        assertEquals(i1.hashCode(), i2.hashCode());
    }

    @Test
    public void testcompareTo() {
        // issue 1 id =112
        // issue 2 id =113
        // compare issue 1 with 2 output result =-1
        int negativeOneResult = issue1.compareTo(issue2);
        assertEquals(-1, negativeOneResult);
        // issue 1 id =112
        // issue 2 id =113
        // compare issue 1 with 2 output result =-1
        int possitiveOneResult = issue2.compareTo(issue1);
        assertEquals(1, possitiveOneResult);
        // issue 1 id =112
        // issue 3 id =112
        // compare issue 1 with 3 output result =0
        int zeroResult = issue1.compareTo(issue3);
        assertEquals(0, zeroResult);
    }

}
