import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tarish Rhees on 8/24/2018.
 */
public class FileParser {
    public Record parseLine(String line, String delimeter) {
        if (line.isEmpty()) {
            return null;
        }

        String[] data = line.split(delimeter);

        Record record = new Record();
        record.setLastName(data[0]);
        record.setFirstName(data[1]);
        record.setMiddleInitial(data[2]);
        record.setGender(data[3]);
        record.setFavoriteColor(data[4]);
        record.setDateOfBirth(data[5]);
        return record;
    }

    public Set<Record> parseFile(String inputPath, String delimeter) throws IOException {
        Set<Record> records = new HashSet<>();

        FileReader file = new FileReader(inputPath);
        BufferedReader reader = new BufferedReader(file);

        String line;
        while ((line = reader.readLine()) != null) {
            records.add(parseLine(line, delimeter));
        }
        reader.close();

        return records;
    }
}
