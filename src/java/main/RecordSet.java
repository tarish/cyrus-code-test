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
        LastNameComparator nameComparator = new LastNameComparator();
        TreeSet<Record> sortedRecords = new TreeSet<>(
                nameComparator
        );

        for (Record record : records) {
            sortedRecords.add(record);
        }
        return sortedRecords;
    }

    public Set<Record> getRecordsSortedByLastNameDescending() {
        LastNameComparator nameComparator = new LastNameComparator();
        TreeSet<Record> sortedRecords = new TreeSet<>(
                nameComparator.reversed()
        );

        for (Record record : records) {
            sortedRecords.add(record);
        }
        return sortedRecords;
    }
}
