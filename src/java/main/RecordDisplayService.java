/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class RecordDisplayService {
    public String display(Record record) {
        String result = "";
        result = String.format("%s %s %s %s %s",
                record.getLastName(), record.getFirstName(), record.getGender(),
                record.getDateOfBirth(), record.getFavoriteColor()
        );
        return result;
    }
}
