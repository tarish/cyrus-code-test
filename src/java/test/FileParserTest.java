import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by Tarish Rhees on 8/24/2018.
 */
public class FileParserTest {

    //Object Under Test
    private FileParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new FileParser();
    }

    @Test
    public void parsesAPipeDelimitedStringIntoARecordObject() {
        Record expected = new Record("Bouillon", "Francis", "G", "M", "Blue", "6-3-1975");

        String line = "Bouillon | Francis | G | M | Blue | 6-3-1975";
        Record record = parser.parseLine(line, "\\|");

        assertThat(record, equalTo(expected));
    }

    @Test
    public void readsFileLinesIntoRecords() throws IOException {
        Record bouillon = new Record("Bouillon", "Francis", "G", "M", "Blue", "6-3-1975");
        Record smith = new Record("Smith", "Steve", "D", "M", "Red", "3-3-1985");
        Record bonk = new Record("Bonk", "Radek", "S", "M", "Green", "6-3-1975");

        Set<Record> actual = parser.parseFile("resources/pipe.txt", "\\|");
        assertThat(actual.size(), is(3));
        assertThat(actual, hasItems(smith, bonk, bouillon));
    }
}