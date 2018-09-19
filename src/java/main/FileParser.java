import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tarish Rhees on 8/24/2018.
 */
public class FileParser {
    public Record createRecordFrom(String line, String delimeter) {
        String[] data = parseLine(line, delimeter);
        if (data == null) return null;

        Record record = new Record();

        if ("\\|".equalsIgnoreCase(delimeter)) {
            record.setLastName(data[0]);
            record.setFirstName(data[1]);
            record.setMiddleInitial(data[2]);
            record.setGender(data[3]);
            record.setFavoriteColor(data[4]);
            record.setDateOfBirth(parseDate(data[5], delimeter));
        }
        if (",".equalsIgnoreCase(delimeter)) {
            record.setLastName(data[0]);
            record.setFirstName(data[1]);
            record.setMiddleInitial(null);
            record.setGender(data[2]);
            record.setFavoriteColor(data[3]);
            record.setDateOfBirth(parseDate(data[4], delimeter));
        }
        if ("\\s".equalsIgnoreCase(delimeter)) {
            record.setLastName(data[0]);
            record.setFirstName(data[1]);
            record.setMiddleInitial(data[2]);
            record.setGender(data[3]);
            record.setDateOfBirth(parseDate(data[4], delimeter));
            record.setFavoriteColor(data[5]);
        }
        return record;
    }

    private Date parseDate(String date, String delimeter) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        if (",".equalsIgnoreCase(delimeter)) {
            formatter.applyPattern("MM/dd/yyyy");
        }
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[] parseLine(String line, String delimeter) {
        if (line == null || line.isEmpty()) {
            return null;
        }
        //TODO: Throw exception if delimeter is null or empty! For now, assume it will always exist!

        return line.split(delimeter);
    }

    public Set<Record> parseFile(String inputPath, String delimeter) throws IOException {
        Set<Record> records = new HashSet<>();

        FileReader file = new FileReader(inputPath);
        BufferedReader reader = new BufferedReader(file);

        String line;
        while ((line = reader.readLine()) != null) {
            records.add(createRecordFrom(line, delimeter));
        }
        reader.close();

        return records;
    }
}
