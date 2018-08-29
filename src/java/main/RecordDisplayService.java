import java.io.*;
import java.util.Set;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayService {
    public String getRecordsForDisplay(Set<Record> records) {
        String result = "Last Name\tFirst Name\tGender\tDate of Birth\tFavorite Color\n";

        for (Record record : records) {
            result += record.getForDisplay();
            result += "\n";
        }

        return result;
    }

    public File displayAsFile(Set<Record> records, String outputPath) throws IOException {
        PrintWriter output = new PrintWriter(outputPath);
        output.write(getRecordsForDisplay(records));
        output.close();
        return new File(outputPath);
    }

    public void displayToConsole(Set<Record> records) {
        System.out.println(getRecordsForDisplay(records));
    }

    public File displayRecordsSortedByLastName(Set<Record> records, String outputPath) throws IOException {
        RecordSet recordSet = new RecordSet();
        recordSet.setRecords(records);
        return displayAsFile(recordSet.getRecordsSortedByLastName(), outputPath);
    }
}
