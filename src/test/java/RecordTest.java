package test.java;

import main.java.Record;
import org.junit.Test;

import java.sql.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Tarish Rhees on 8/22/2018.
 */
public class RecordTest {

    @Test
    public void sanityCheck_constructsRecordWithAllFields() {
        Record record = new Record();
        assertThat(record.getLastName(), nullValue());

        record = new Record("Halfelf", "Grace", "", "F", "White", Date.valueOf("1913-05-03"));
        assertThat(record.getLastName(), is("Halfelf"));
        assertThat(record.getFirstName(), is("Grace"));
        assertThat(record.getMiddleInitial(), is(""));
    }
}