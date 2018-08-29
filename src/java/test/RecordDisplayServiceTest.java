import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayServiceTest {
    private final Record GRACE_HALFELF = new Record("Halfelf", "Grace", "L", "F", "black", "1/23/1913");
    private final Record LUNARIENNE_GNOME = new Record("Gnome", "Lunarienne", "", "F", "white", "5/3/2004");
    private final Record LAMIERINA_WARRIOR = new Record("Warrior", "Lamierina", "S", "F", "red", "8/31/2005");

    //Object Under Test
    private RecordDisplayService displayService;

    @Before
    public void setUp() {
        displayService = new RecordDisplayService();
    }

    @Test
    public void getsSetOfRecordsForDisplay() {

        Set<Record> records = new HashSet<>();
        records.add(GRACE_HALFELF);
        records.add(LUNARIENNE_GNOME);

        assertThat(
                displayService.getRecordsForDisplay(records),
                is("Last Name\tFirst Name\tGender\tDate of Birth\tFavorite Color\nHalfelf\tGrace\tF\t1/23/1913\tblack\nGnome\tLunarienne\tF\t5/3/2004\twhite\n")
        );
    }

    @Test
    public void displaysSetOfRecordsAsFile() throws IOException {
        Set<Record> records = new HashSet<>();
        records.add(GRACE_HALFELF);
        records.add(LUNARIENNE_GNOME);

        File result = displayService.displayAsFile(records, "resources\\records.txt");

        assertThat(result.exists(), is(true));
        assertThat(result.getPath(), is("resources\\records.txt"));
        assertThat(result.length(), is(123L));

        result.deleteOnExit();
    }

    @Test
    public void displaySetOfRecordsSortedByLastName() throws IOException {
        Set<Record> records = new HashSet<>();
        records.add(GRACE_HALFELF);
        records.add(LAMIERINA_WARRIOR);
        records.add(LUNARIENNE_GNOME);

        RecordSet recordSet = new RecordSet();
        recordSet.setRecords(records);
        File expected = displayService.displayAsFile(recordSet.getRecordsSortedByLastName(), "resources\\expected.txt");


        File result = displayService.displayRecordsSortedByLastName(records, "resources\\records.txt");

        byte[] resultArray = Files.readAllBytes(result.toPath());
        byte[] expectedArray = Files.readAllBytes(expected.toPath());

        assertThat(resultArray, is(expectedArray));

        result.deleteOnExit();
        expected.deleteOnExit();
    }
}