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
        return record;
    }
}
