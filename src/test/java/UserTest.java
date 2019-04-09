//import static org.junit.Assert.*;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

//import org.junit.Test;

public class UserTest {

    @Test
    public void testEquals() {
        User a = new User();
        User b = new User();
        a.setId(100);
        b.setId(100);
        assertTrue(a.equals(b));

        User i3 = new User();
        a.setId(10);
        assertFalse(i3.equals(b));
    }

    @Test
    public void testHashCode() {
        User a = new User();
        User b = new User();
        a.setId(100);
        b.setId(100);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testToString() {
        User user1 = new User();
        user1.setLogin("Neeharika");
        user1.setId(1101);
        assertEquals("Neeharika", user1.toString());

    }

}
