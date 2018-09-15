import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Tarish Rhees on 9/13/2018.
 */
public class GenderAndLastNameComparatorTest {
    private final Record EGWENE_ALVERE = new Record("al'Vere", "Egwene", "", "F", "green", "");
    private final Record SIUN_SANCHE = new Record("Sanche", "Siun", "B", "F", "blue", "");
    private final Record RAND_ALTHOR = new Record("al'Thor", "Rand", "", "M", "black", "");
    private final Record GARETH_BRYNE = new Record("Bryne", "Gareth", "W", "M", "white", "");

    //Object Under Test
    private GenderAndLastNameComparator comparator = new GenderAndLastNameComparator();

    @Test
    public void comparesDifferentGendersAndLastNames() {
        //Same gender and same name
        assertThat(comparator.compare(EGWENE_ALVERE, EGWENE_ALVERE), is(0));
        assertThat(comparator.compare(RAND_ALTHOR, RAND_ALTHOR), is(0));

        //Gender is the same, but name is different
        assertThat(comparator.compare(EGWENE_ALVERE, SIUN_SANCHE) < 0, is(true));
        assertThat(comparator.compare(SIUN_SANCHE, EGWENE_ALVERE) > 0, is(true));

        //Gender is different but name is the same - female first to compare
        Record EGWENE_ALVERE_AS_MAN = new Record("al'Vere", "Egwene", "", "M", "green", "");
        assertThat(comparator.compare(EGWENE_ALVERE, EGWENE_ALVERE_AS_MAN) < 0, is(true));

        //Gender is different but name is the same - male first to compare
        Record RAND_ALTHOR_AS_WOMAN = new Record("al'Thor", "Rand", "", "F", "black", "");
        assertThat(comparator.compare(RAND_ALTHOR, RAND_ALTHOR_AS_WOMAN) > 0, is(true));

        //Gender is different and name is different - female first to compare
        assertThat(comparator.compare(EGWENE_ALVERE, GARETH_BRYNE) < 0, is(true));
        assertThat(comparator.compare(SIUN_SANCHE, GARETH_BRYNE) < 0, is(true));

        //Gender is different and name is different - male first to compare
        assertThat(comparator.compare(RAND_ALTHOR, EGWENE_ALVERE) > 0, is(true));
        assertThat(comparator.compare(RAND_ALTHOR, SIUN_SANCHE) > 0, is(true));
    }
}