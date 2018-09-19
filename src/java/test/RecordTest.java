import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordTest {
    private Date DATE_OF_BIRTH;

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        DATE_OF_BIRTH = formatter.parse("1/23/1913");
    }

    @Test
    public void displaysARecordInSpecificFieldOrder() {
        Record record = new Record("Halfelf", "Grace", "L", "F", "white", DATE_OF_BIRTH);
        assertThat(record.getForDisplay(), is("Halfelf\t\t\t|\t\tGrace\t\t|\t\tF\t\t|\t\t01/23/1913\t\t|\t\twhite"));
    }

    @Test
    public void recordIsEqualToAnotherRecordWhenAllFieldsMatch() {
        //All fields have the same  content
        Record grace = new Record("Halfelf", "Grace", "L", "F", "white", DATE_OF_BIRTH);
        Record halfelf = new Record("Halfelf", "Grace", "L", "F", "white", DATE_OF_BIRTH);
        assertThat(grace, equalTo(halfelf));

        //Records with null and empty fields are equal
        grace.setMiddleInitial(null);
        halfelf.setMiddleInitial("");
        assertThat(grace, equalTo(halfelf));
    }
}