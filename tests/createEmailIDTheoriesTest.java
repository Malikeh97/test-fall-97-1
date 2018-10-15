import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class createEmailIDTheoriesTest {
    @DataPoints
    public static String[] parts = {"mm", "malikeh", "ali", "b", "MohammadReza", null};

    @Theory
    public void createEmailIDTest(String firstpart, String secondpart) throws Exception {
        assumeNotNull(firstpart, secondpart);

        String temp = firstpart.substring(0, 1);
        String expectedEmail = temp + '.' + secondpart + "@test.ut.ac.ir";

        Class mClass = User.class;
        Method createEmailID = mClass.getDeclaredMethod("createEmailID", String.class, String.class);
        createEmailID.setAccessible(true);
        String email = (String) createEmailID.invoke(null, firstpart, secondpart);

        System.out.println("expectedEmail: " + expectedEmail);
        System.out.println("email: " + email);
        assertEquals(expectedEmail, email);
    }

}
