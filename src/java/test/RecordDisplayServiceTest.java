import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
    public void getsSetOfRecordsForDisplay() {
        Record graceHalfelf = new Record("Halfelf", "Grace", "L", "F", "black", "1/23/1913");
        Record lunarienneGnome = new Record("Gnome", "Lunarienne", "", "F", "white", "5/3/2004");

        Set<Record> records = new HashSet<>();
        records.add(graceHalfelf);
        records.add(lunarienneGnome);

        assertThat(
                displayService.getRecordsForDisplay(records),
                is("Last Name\tFirst Name\tGender\tDate of Birth\tFavorite Color\nHalfelf\tGrace\tF\t1/23/1913\tblack\nGnome\tLunarienne\tF\t5/3/2004\twhite\n")
        );
    }

    @Test
    public void displaysSetOfRecordsAsFile() throws IOException {
        Record graceHalfelf = new Record("Halfelf", "Grace", "L", "F", "black", "1/23/1913");
        Record lunarienneGnome = new Record("Gnome", "Lunarienne", "", "F", "white", "5/3/2004");

        Set<Record> records = new HashSet<>();
        records.add(graceHalfelf);
        records.add(lunarienneGnome);

        File result = displayService.displayAsFile(records, "resources\\records.txt");

        assertThat(result.exists(), is(true));
        assertThat(result.getPath(), is("resources\\records.txt"));
        assertThat(result.length(), is(123L));

        result.deleteOnExit();
    }
}