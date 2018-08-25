/**
 * Created by Tarish Rhees on 8/24/2018.
 */
public class FileParser {
    public Record parseLine(String line) {
        if (line.isEmpty()) {
            return null;
        }

        String[] data = line.split("\\|");

        Record record = new Record();
        record.setLastName(data[0]);
        record.setFirstName(data[1]);
        record.setMiddleInitial(data[2]);
        record.setGender(data[3]);
        record.setFavoriteColor(data[4]);
        record.setDateOfBirth(data[5]);
        return record;
    }
}
