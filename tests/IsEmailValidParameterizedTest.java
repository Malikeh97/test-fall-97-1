import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class IsEmailValidParameterizedTest {
    public String email;
    public boolean isMatched;

    public IsEmailValidParameterizedTest(String email, boolean isMatched) {
        this.email = email;
        this.isMatched = isMatched;
    }

    @Parameters(name= "{index}: isValid({0})={1}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"malikehehghaghi@gmail.com", true},
                {"a.tabatabaei@gmail.com", true},
                {"ali_tabatabaei@gmail.com", true},
                {"a.tabatabaei@test.ut.ac.ir", true},
                {"ali_tabatabaei@gmailcom", false},
                {".tabatabaei@gmail.com", false},
                {"a.tabatabaei@gmail.c", false},
                {"a.tabatabaeigmail.com", false},
                {"a@tabatabaei@gmail.com", false},
                {"a@tabatabaei@gmail..com", false},
                {"a.taba tabaei@gmail.com", false},
                {"@gmail.com", false},
                {"a.tabatabaei@", false},
                {"mkyong", false}
        });
    }

    @Test
    public void IsEmailValidTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class mClass = User.class;
        Method isEmailValid = mClass.getDeclaredMethod("isEmailValid", String.class);
        isEmailValid.setAccessible(true);
        Object value = isEmailValid.invoke(null, email);
        assertEquals("Email validation test failed!", isMatched, value);
    }


}
