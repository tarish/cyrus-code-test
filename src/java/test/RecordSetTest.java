import org.hamcrest.core.IsCollectionContaining;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/25/2018.
 */
public class RecordSetTest {

    //Object Under Test
    RecordSet recordSet;

    @Before
    public void setUp() {
        recordSet = new RecordSet();
    }

    @Test
    public void providesNullSafeSetOfRecords() {
        Set<Record> records = recordSet.getRecords();
        assertThat(records, notNullValue());
        assertThat(records.isEmpty(), is(true));
    }

    @Test
    public void providesSetOfRecords() {
        Set<Record> someRecords = new HashSet<>();
        Record expectedRecord = new Record();
        someRecords.add(expectedRecord);
        recordSet.setRecords(someRecords);

        Set<Record> actualRecords = recordSet.getRecords();
        assertThat(recordSet.getRecords().size(), is((1)));
        assertThat(actualRecords.contains(expectedRecord), is(true));
    }

    @Test
    public void providesSetOfRecordsSortedByLastName() {
        Record smith = new Record("Smith", "Lyn", "L", "F", "grey", "02-02");
        Record hoschler = new Record("Hoschler", "Louise", "M", "F", "blue", "05-14");
        Record rhees = new Record("Rhees", "Tarish", "J", "F", "blue", "05-03");

        Set<Record> records = new HashSet<>();
        records.add(smith);
        records.add(hoschler);
        records.add(rhees);
        recordSet.setRecords(records);

        //Sanity check that original records are NOT in name order
        Iterator<Record> iterator = records.iterator();
        assertThat(iterator.next(), is(smith));
        assertThat(iterator.next(), is(hoschler));
        assertThat(iterator.next(), is(rhees));

        //Check sorted records are in expected order
        Set<Record> sortedRecords = recordSet.getRecordsSortedByLastName();
        assertThat(sortedRecords.size(), is(3));

        iterator = sortedRecords.iterator();
        assertThat(iterator.next(), is(hoschler));
        assertThat(iterator.next(), is(rhees));
        assertThat(iterator.next(), is(smith));
    }
}