import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Tarish Rhees on 8/25/2018.
 */
public class RecordSetTest {
    Date FEB_2_1915;
    Date FEB_6_1976;
    Date MAY_3_1975;
    Date MAY_14_1914;
    Date JUNE_3_1913;

    //Object Under Test
    private RecordSet recordSet;

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        FEB_2_1915 = formatter.parse("2/2/1915");
        FEB_6_1976 = formatter.parse("2/6/1976");
        MAY_3_1975 = formatter.parse("5/3/1975");
        MAY_14_1914 = formatter.parse("5/14/1914");
        JUNE_3_1913 = formatter.parse("6/3/1913");
        
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
    public void providesSetOfRecordsSortedByLastNameAscending() {
        Record smith = new Record("Smith", "Lyn", "L", "F", "grey", FEB_2_1915);
        Record hoschler = new Record("Hoschler", "Louise", "M", "F", "blue", MAY_14_1914);
        Record rhees = new Record("Rhees", "Tarish", "J", "F", "blue", MAY_3_1975);

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

        //Check sorted records are in Ascending order
        Set<Record> sortedRecords = recordSet.getRecordsSortedByLastNameAscending();
        assertThat(sortedRecords.size(), is(3));

        //NOTE: Order Matters for this test!!! Do not rearrange unless changing requirements!
        iterator = sortedRecords.iterator();
        assertThat(iterator.next(), is(hoschler));
        assertThat(iterator.next(), is(rhees));
        assertThat(iterator.next(), is(smith));
    }

    @Test
    public void providesSetOfRecordsSortedByLastNameDescending() {
        Record smith = new Record("Smith", "Lyn", "L", "F", "grey", FEB_2_1915);
        Record hoschler = new Record("Hoschler", "Louise", "M", "F", "blue", MAY_14_1914);
        Record rhees = new Record("Rhees", "Tarish", "J", "F", "blue", MAY_3_1975);

        Set<Record> records = new HashSet<>();
        records.add(smith);
        records.add(hoschler);
        records.add(rhees);
        recordSet.setRecords(records);

        //Check sorted records are in Descending order
        Set<Record> sortedRecords = recordSet.getRecordsSortedByLastNameDescending();
        assertThat(sortedRecords.size(), is(3));

        //NOTE: Order Matters for this test!!! Do not rearrange unless changing requirements!
        Iterator<Record> iterator = sortedRecords.iterator();
        assertThat(iterator.next(), is(smith));
        assertThat(iterator.next(), is(rhees));
        assertThat(iterator.next(), is(hoschler));
    }

    @Test
    public void providesSetOfRecordsSortedByGenderAndThenLastNameAscending() {
        Record grandma_smith = new Record("Smith", "Lyn", "L", "F", "grey", null);
        Record grandma_hoschler = new Record("Hoschler", "Louise", "M", "F", "blue", null);
        Record grandpa_hoschler = new Record("Hoschler", "Dennis", "K", "M", "red", null);
        Record tarish = new Record("Rhees", "Tarish", "J", "F", "blue", null);
        Record mike = new Record("Rhees", "Ronald", "M", "M", "white", null);

        Set<Record> records = new HashSet<>();
        records.add(mike);
        records.add(tarish);
        records.add(grandma_hoschler);
        records.add(grandpa_hoschler);
        records.add(grandma_smith);
        recordSet.setRecords(records);

        Set<Record> sortedRecords = recordSet.getRecordsSortedByGenderAndThenName();
        assertThat(sortedRecords.size(), is(5));

        //NOTE: Order Matters for this test!!! Do not rearrange unless changing requirements!
        Iterator<Record> iterator = sortedRecords.iterator();
        assertThat(iterator.next(), is(grandma_hoschler));
        assertThat(iterator.next(), is(tarish));
        assertThat(iterator.next(), is(grandma_smith));
        assertThat(iterator.next(), is(grandpa_hoschler));
        assertThat(iterator.next(), is(mike));
    }
}