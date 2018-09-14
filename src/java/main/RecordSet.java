import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Tarish Rhees on 8/25/2018.
 */
public class RecordSet {
    private Set<Record> records = new HashSet<>();

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        if (records == null) {
            records = new HashSet<>();
        }
        this.records = records;
    }

    public Set<Record> getRecordsSortedByLastNameAscending() {
        LastNameComparator comparator = new LastNameComparator();
        TreeSet<Record> sortedRecords = new TreeSet<>(
                comparator
        );

        for (Record record : records) {
            sortedRecords.add(record);
        }
        return sortedRecords;
    }

    public Set<Record> getRecordsSortedByLastNameDescending() {
        LastNameComparator comparator = new LastNameComparator();
        TreeSet<Record> sortedRecords = new TreeSet<>(
                comparator.reversed()
        );
        for (Record record : records) {
            sortedRecords.add(record);
        }
        return sortedRecords;
    }

    public Set<Record> getRecordsSortedByGenderAndThenName() {
        GenderAndLastNameComparator comparator = new GenderAndLastNameComparator();
        TreeSet<Record> sortedRecords = new TreeSet<>(comparator);
        for (Record record : records) {
            sortedRecords.add(record);
        }
        return sortedRecords;
    }
}
