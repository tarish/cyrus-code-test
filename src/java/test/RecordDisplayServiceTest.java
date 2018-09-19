import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayServiceTest {

    private Record GRACE_HALFELF;
    private Record LUNARIENNE_GNOME;
    private Record LAMIERINA_WARRIOR;

    //Object Under Test
    private RecordDisplayService displayService;

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        GRACE_HALFELF = new Record("Halfelf", "Grace", "L", "F", "black", formatter.parse("1/23/1913"));
        LUNARIENNE_GNOME = new Record("Gnome", "Lunarienne", "", "F", "white", formatter.parse("5/3/2004"));
        LAMIERINA_WARRIOR = new Record("Warrior", "Lamierina", "S", "F", "red", formatter.parse("8/31/2005"));

        displayService = new RecordDisplayService();
    }

    @Test
    public void getsHeaderLineForRecordReport() {
        assertThat(displayService.getRecordReportHeaderLine(),
                is("Last Name\t\t|\t\tFirst Name\t\t|\t\tGender\t\t|\t\tDate of Birth\t\t|\t\tFavorite Color")
        );
    }

    @Test
    public void getsSetOfRecordsForDisplay() {
        Set<Record> records = new HashSet<>();
        records.add(GRACE_HALFELF);
        records.add(LUNARIENNE_GNOME);

        assertThat(displayService.getRecordsForDisplay(records), is(
                "Halfelf\t\t\t|\t\tGrace\t\t|\t\tF\t\t|\t\t01/23/1913\t\t|\t\tblack\n" +
                "Gnome\t\t\t|\t\tLunarienne\t\t|\t\tF\t\t|\t\t05/03/2004\t\t|\t\twhite\n"
        ));
    }

    @Test
    public void displaysSetOfRecordsAsFile() throws IOException {
        Set<Record> records = new HashSet<>();
        records.add(GRACE_HALFELF);
        records.add(LUNARIENNE_GNOME);

        File result = displayService.displayAsFile(records, "resources\\records.txt");

        assertThat(result.exists(), is(true));
        assertThat(result.getPath(), is("resources\\records.txt"));
        //TODO: Find a better way to test comparing file output!

        result.deleteOnExit();
    }

    @Test
    public void displaySetOfRecordsSortedByLastName() throws IOException {
        Set<Record> records = new HashSet<>();
        records.add(GRACE_HALFELF);
        records.add(LAMIERINA_WARRIOR);
        records.add(LUNARIENNE_GNOME);

        //TODO: Improve! Make into actual file rather than just duplicating the underlying code.
        RecordSet recordSet = new RecordSet();
        recordSet.setRecords(records);
        File expected = displayService.displayAsFile(recordSet.getRecordsSortedByLastNameDescending(), "resources\\expected.txt");

        File result = displayService.displayRecordsSortedByDescendingLastName(records, "resources\\records.txt");

        byte[] resultArray = Files.readAllBytes(result.toPath());
        byte[] expectedArray = Files.readAllBytes(expected.toPath());

        assertThat(resultArray, is(expectedArray));

        result.deleteOnExit();
        expected.deleteOnExit();
    }
}