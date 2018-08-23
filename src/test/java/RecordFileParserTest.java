package test.java;

import main.java.Record;
import main.java.RecordFileParser;
import org.junit.Test;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/22/2018.
 */
public class RecordFileParserTest {

    @Test
    public void parsePipeDelimitedFileIntoSetOfRecords() {
        RecordFileParser recordFileParser = new RecordFileParser();
        Set<Record> records = recordFileParser.parseWithDelimeter("resources/pipe.txt", "\\|");

        assertThat(records.size(), is(3));

        String allRecordsAsString = records.toString();
        assertThat(allRecordsAsString, containsString("Record{lastName='Smith', firstName='Steve', middleInitial='D', gender='M', favoriteColor='Red', dateOfBirth=3-3-1985}"));
        assertThat(allRecordsAsString, containsString("Record{lastName='Bonk', firstName='Radek', middleInitial='S', gender='M', favoriteColor='Green', dateOfBirth=6-3-1975}"));
        assertThat(allRecordsAsString, containsString("Record{lastName='Bouillon', firstName='Francis', middleInitial='G', gender='M', favoriteColor='Blue', dateOfBirth=6-3-1975}"));
    }
}

