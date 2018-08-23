package test.java;

import main.java.Record;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/22/2018.
 */
public class RecordTest {

    @Test
    public void sanityCheck_constructsRecordWithAllFields() {
        Record record = new Record();
        assertThat(record.getLastName(), nullValue());

        record = new Record("Halfelf", "Grace", "", "F", "White", "1913-05-03");
        assertThat(record.getLastName(), is("Halfelf"));
        assertThat(record.getFirstName(), is("Grace"));
        assertThat(record.getMiddleInitial(), is(""));
        assertThat(record.getDateOfBirth(), is("1913-05-03"));
    }
}