import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Tarish Rhees on 8/24/2018.
 */
public class FileParserTest {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    Date JUN_3_1975;

    //Object Under Test
    private FileParser parser;

    @Before
    public void setUp() throws Exception {
        JUN_3_1975 = formatter.parse("6/3/1975");
        parser = new FileParser();
    }

    @Test
    public void parsesAPipeDelimitedLineIntoARecordObject() {
        Record expected = new Record("Bouillon", "Francis", "G", "M", "Blue", JUN_3_1975);

        String line = "Bouillon | Francis | G | M | Blue | 6-3-1975";
        Record record = parser.createRecordFrom(line, "\\|");

        assertThat(record, equalTo(expected));
    }

    @Test
    public void parsesACommaDelimitedLineIntoARecordObject() throws ParseException {
        Record expected = new Record("Abercrombie", "Neil", null, "M", "Tan", formatter.parse("2/13/1943"));

        String line = "Abercrombie, Neil, Male, Tan, 2/13/1943";
        Record record = parser.createRecordFrom(line, ",");

        assertThat(record, equalTo(expected));
    }

    @Test
    public void parsesASpaceDelimitedLineIntoARecordObject() throws ParseException {
        Record expected = new Record("Hingis", "Martina", "M", "F", "Green", formatter.parse("4/2/1979"));

        String line = "Hingis Martina M F 4-2-1979 Green";
        Record record = parser.createRecordFrom(line, "\\s");

        assertThat(record, equalTo(expected));
    }

//    @Test
    public void parsesAMultipleTypesOfSpaceDelimitedLineIntoARecordObject() {
        //TODO: Find a way to test for multiple spaces and/or tabs
    }

    @Test
    public void readsFileLinesIntoRecords() throws IOException, ParseException {
        Record bouillon = new Record("Bouillon", "Francis", "G", "M", "Blue", JUN_3_1975);
        Record smith = new Record("Smith", "Steve", "D", "M", "Red", formatter.parse("3/3/1985"));
        Record bonk = new Record("Bonk", "Radek", "S", "M", "Green", JUN_3_1975);

        Set<Record> actual = parser.parseFile("resources/pipe.txt", "\\|");
        assertThat(actual.size(), is(3));
        assertThat(actual, hasItems(smith, bonk, bouillon));
    }
}