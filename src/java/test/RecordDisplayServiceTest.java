import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayServiceTest {
    //Object Under Test
    private RecordDisplayService displayService;

    @Before
    public void setUp() {
        displayService = new RecordDisplayService();
    }

    @Test
    public void displayARecordInSpecificFieldOrder() {
        Record record = new Record("Halfelf", "Grace", "L", "F", "white", "1/23/1913");
        String result = displayService.display(record);

        assertThat(result, is("Halfelf Grace F 1/23/1913 white"));
    }
}