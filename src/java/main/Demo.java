import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tarish Rhees on 9/13/2018.
 */
public class Demo {
    public static void main(String[] args) {
        FileParser parser = new FileParser();

        try {
            Set<Record> records = parser.parseFile("resources/comma.txt", ",");
            records.addAll(parser.parseFile("resources/pipe.txt", "\\|"));
            records.addAll(parser.parseFile("resources/space.txt", "\\s"));

            RecordDisplayService displayService = new RecordDisplayService();
            displayService.displayAsFile(records, "out/unsorted.txt");

            displayService.displayRecordsSortedByDescendingLastName(records, "out/descendingLastName.txt");
            displayService.displayRecordsSortedByGenderAndAscendingLastName(records, "out/genderAndName.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
