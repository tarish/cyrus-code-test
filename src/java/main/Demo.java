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
            System.out.println("===============================================================================================================");
            System.out.println("------------------------------------------- RAW COMBINED RECORD SET -------------------------------------------");
            System.out.println("===============================================================================================================");
            System.out.println(displayService.getRecordReportHeaderLine());
            System.out.println("===============================================================================================================");
            displayService.displayToConsole(records);

            displayService.displayRecordsSortedByDescendingLastName(records, "resources/descendingLastName.txt");
            displayService.displayRecordsSortedByGenderAndAscendingLastName(records, "resources/genderAndName.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
