package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tarish Rhees on 8/22/2018.
 */
public class RecordFileParser {

    public Set<Record> parseWithDelimeter(String inputPath, String delimeter) {
        FileReader input;
        BufferedReader reader;

        Set<Record> records = new HashSet<>();

        try {
            input = new FileReader(inputPath);
            reader = new BufferedReader(input);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(delimeter);

                Record record = new Record(
                        data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(),  data[5].trim()
                );

                records.add(record);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}
