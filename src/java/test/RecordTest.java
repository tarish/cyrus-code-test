import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordTest {
    @Test
    public void displaysARecordInSpecificFieldOrder() {
        Record record = new Record("Halfelf", "Grace", "L", "F", "white", "1/23/1913");
        assertThat(record.getForDisplay(), is("Halfelf\tGrace\tF\t1/23/1913\twhite"));
    }
}