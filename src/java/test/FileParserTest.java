import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Tarish Rhees on 8/24/2018.
 */
public class FileParserTest {
    @Test
    public void parsesAPipeDelimitedStringIntoARecordObject() {
        Record expected = new Record("Bouillon", "Francis", "G", "M", "Blue", "6-3-1975");

        FileParser parser = new FileParser();
        String line = "Bouillon | Francis | G | M | Blue | 6-3-1975";
        Record record = parser.parseLine(line, "\\|");

        assertThat(record, equalTo(expected));
    }

    @Test
    public void readsFileLinesIntoRecords() {

    }
}