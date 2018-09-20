import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Tarish Rhees on 9/19/2018.
 */
public class DateOfBirthComparatorTest {
    private SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private Record NYNEAVE_ALMEARA;
    private Record EGWENE_ALVERE;
    private Record RAND_ALTHOR;
    private Record MATRIM_CAUTHON;

    //Object Under Test
    private DateOfBirthComparator comparator = new DateOfBirthComparator();

    @Before
    public void setUp() throws ParseException {
        NYNEAVE_ALMEARA = new Record("al'Meara", "Nynaeve", "t", "F", "yellow", formatter.parse("1/1/1973"));
        EGWENE_ALVERE = new Record("al'Vere", "Egwene", "", "F", "green", formatter.parse("5/3/1981"));
        RAND_ALTHOR = new Record("al'Thor", "Rand", "", "M", "black", formatter.parse("6/3/1978"));
        MATRIM_CAUTHON = new Record("Cauthon", "Matrim", "Z", "M", "brown", formatter.parse("6/3/1978"));
    }

    @Test
    public void comparesBirthdatesAndLastNames() throws ParseException {
        //Same birthdate and same name
        assertThat(comparator.compare(EGWENE_ALVERE, EGWENE_ALVERE), is(0));
        assertThat(comparator.compare(RAND_ALTHOR, RAND_ALTHOR), is(0));

        //Same birthdate, and different name
        assertThat(comparator.compare(RAND_ALTHOR, MATRIM_CAUTHON) < 0, is(true));

        //Different birthdate and same name
        Record EGWENE_ALVERE_LATER_BIRTHDATE = new Record("al'Vere", "Egwene", "", "F", "green", formatter.parse("1/1/1985"));
        assertThat(comparator.compare(EGWENE_ALVERE, EGWENE_ALVERE_LATER_BIRTHDATE) < 0, is(true));

        Record EGWENE_ALVERE_EARLIER_BIRTHDATE = new Record("al'Vere", "Egwene", "", "F", "green", formatter.parse("1/1/1975"));
        assertThat(comparator.compare(EGWENE_ALVERE, EGWENE_ALVERE_EARLIER_BIRTHDATE) > 0, is(true));

        //Different birthdate and different name
        assertThat(comparator.compare(EGWENE_ALVERE, RAND_ALTHOR) > 0, is(true));
        assertThat(comparator.compare(NYNEAVE_ALMEARA, MATRIM_CAUTHON) < 0, is(true));
    }
}