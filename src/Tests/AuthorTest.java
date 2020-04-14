import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AuthorTest {
    private Author author;

    @Before
    public void setUp() throws Exception {
        author = new Author("Fred", "Flintstone", LocalDate.of(1965,8,8));
    }

    @Test
    public void setFirstName() {
        author.setFirstName("george");
        String expResult = "George";
        assertEquals(expResult, author.getFirstName());
    }

    @Test
    public void setFirstNameInvalidNonCharacters(){
        try {
            author.setFirstName("2e");
            fail("an empty first name or blank spaces should have triggered an exception");
        } catch (IllegalArgumentException e)
        {
            System.out.println("correct exception for empty first name "+e.getMessage());
        } catch (Exception e)
        {
            fail("Wrong exception thrown for setFirstName() with a non-character");
        }
    }

    @Test
    public void setFirstNameInvalid() {
        try {
            author.setFirstName("   ");
            fail("an empty first name or blank spaces should have triggered an exception");
        } catch (IllegalArgumentException e)
        {
            System.out.println("correct exception for empty first name "+e.getMessage());
        } catch (Exception e)
        {
            fail("Wrong exception thrown for setFirstName() with an invalid name");
        }
    }

    @Test
    public void setFirstNameInvalid2() {
        try {
            author.setFirstName(" J  ");
            fail("an empty first name or blank spaces should have triggered an exception");
        } catch (IllegalArgumentException e)
        {
            System.out.println("correct exception for empty first name "+e.getMessage());
        } catch (Exception e)
        {
            fail("Wrong exception thrown for setFirstName() with an invalid name");
        }
    }

    @Test
    public void setLastName() {
        author.setLastName("george");
        String expResult = "George";
        assertEquals(expResult, author.getLastName());
    }

    @Test
    public void setLastNameInvalid() {
        try {
            author.setLastName("   ");
            fail("an empty last name or blank spaces should have triggered an exception");
        } catch (IllegalArgumentException e)
        {
            System.out.println("correct exception for empty last name "+e.getMessage());
        } catch (Exception e)
        {
            fail("Wrong exception thrown for setLastName() with an invalid name");
        }
    }

    @Test
    public void setLastNameInvalid2() {
        try {
            author.setLastName(" J  ");
            fail("an empty last name or blank spaces should have triggered an exception");
        } catch (IllegalArgumentException e)
        {
            System.out.println("correct exception for empty last name "+e.getMessage());
        } catch (Exception e)
        {
            fail("Wrong exception thrown for setLastName() with an invalid name");
        }
    }

    @Test
    public void setBirthday() {
        author.setBirthday(LocalDate.of(2015,01,23));
        LocalDate expResult =LocalDate.of(2015,01,23);
        assertEquals(expResult, author.getBirthday());
    }

    @Test
    public void setBirthdayInvalid() {
        try{
            author.setBirthday(LocalDate.of(2019,01,01));
            fail("author less than 3 years of age should trigger an exception");
        } catch (IllegalArgumentException e)
        {
            System.out.println("Correctly identified invalid birthday");
        } catch(Exception e)
        {
            fail("wrong exception thrown for invalid birthday");
        }

    }


    @Test
    public void getAge() {
        int expResult = 54;
        assertEquals(expResult, author.getAge());
    }

    @Test
    public void testToString() {
        String expResult = "Fred Flintstone aged: 54";
        String result = author.toString();
        assertEquals(expResult, result);
    }
}