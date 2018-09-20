import java.io.*;
import java.util.Set;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayService {
    public String getRecordReportHeaderLine() {
        return "Last Name\t\t|\t\tFirst Name\t\t|\t\tGender\t\t|\t\tDate of Birth\t\t|\t\tFavorite Color";
    }

    public String getRecordsForDisplay(Set<Record> records) {
        String result = "";

        for (Record record : records) {
            result += record.getForDisplay() + "\n";
        }

        return result;
    }

    public File displayAsFile(Set<Record> records, String outputPath) throws IOException {
        PrintWriter output = new PrintWriter(outputPath);
        output.write(getRecordReportHeaderLine() + "\n");
        output.write(getRecordsForDisplay(records));
        output.close();
        return new File(outputPath);
    }

    public void displayToConsole(Set<Record> records) {
        System.out.println(getRecordsForDisplay(records));
    }

    public File displayRecordsSortedByDescendingLastName(Set<Record> records, String outputPath) throws IOException {
        RecordSet recordSet = new RecordSet();
        recordSet.setRecords(records);
        return displayAsFile(recordSet.getRecordsSortedByLastNameDescending(), outputPath);
    }

    public File displayRecordsSortedByGenderAndAscendingLastName(Set<Record> records, String outputPath) throws IOException {
        RecordSet recordSet = new RecordSet();
        recordSet.setRecords(records);
        return displayAsFile(recordSet.getRecordsSortedByGenderAndThenName(), outputPath);
    }

    public File displayRecordsSortedByBirthdateAndAscendingLastName(Set<Record> records, String outputPath) throws IOException {
        RecordSet recordSet = new RecordSet();
        recordSet.setRecords(records);
        return displayAsFile(recordSet.getRecordsSortedByDateOfBirthAndThenName(), outputPath);
    }
}
