import java.util.Set;

/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayService {
    public String display(Set<Record> records) {
        String result = "Last Name\tFirst Name\tGender\tDate of Birth\tFavorite Color\n";

        for (Record record : records) {
            result += record.getForDisplay();
            result += "\n";
        }

        System.out.println(result);
        return result;
    }
}
