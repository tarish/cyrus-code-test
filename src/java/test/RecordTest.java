import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordTest {
    @Test
    public void displaysARecordInSpecificFieldOrder() {
        Record record = new Record("Halfelf", "Grace", "L", "F", "white", "1/23/1913");
        assertThat(record.getForDisplay(), is("Halfelf\t\t\t|\t\tGrace\t\t|\t\tF\t\t|\t\t1/23/1913\t\t|\t\twhite"));
    }

    @Test
    public void recordIsEqualToAnotherRecordWhenAllFieldsMatch() {
        //All fields have content
        Record grace = new Record("Halfelf", "Grace", "L", "F", "white", "1/23/1913");
        Record halfelf = new Record("Halfelf", "Grace", "L", "F", "white", "1/23/1913");
        assertThat(grace, equalTo(halfelf));

        //Records with null and empty fields are equal
        grace.setMiddleInitial(null);
        halfelf.setMiddleInitial("");
        assertThat(grace, equalTo(halfelf));
    }
}