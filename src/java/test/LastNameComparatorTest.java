import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Tarish Rhees on 8/29/2018.
 */
public class LastNameComparatorTest {
    private final Record GRACE_HALFELF = new Record("Halfelf", "Grace", "", "", "", "");
    private Record MYSTAINA_HALFELF = new Record("Halfelf", "Mystaina", "", "", "", "");
    private final Record LUNARIENNE_GNOME = new Record("Gnome", "Lunarienne", "", "", "", "");

    //Object Under Test
    private LastNameComparator lastNameComparator = new LastNameComparator();

    @Test
    public void comparesLastNameOnly() {
        assertThat(lastNameComparator.compare(GRACE_HALFELF, GRACE_HALFELF), is(0));
        assertThat(lastNameComparator.compare(LUNARIENNE_GNOME, GRACE_HALFELF) < 0, is(true));
        assertThat(lastNameComparator.compare(GRACE_HALFELF, LUNARIENNE_GNOME) > 0, is(true));
    }

    @Test
    public void ignoresCaseWhenComparing() {
        Record GRACE_2 = new Record("HALFELF", "grace", "", "", "", "");
        assertThat(lastNameComparator.compare(GRACE_HALFELF, GRACE_2), is(0));
    }

    @Test
    public void comparesByFirstNameWhenLastNameIsEqual() {
        assertThat(lastNameComparator.compare(GRACE_HALFELF, GRACE_HALFELF), is(0));
        assertThat(lastNameComparator.compare(GRACE_HALFELF, MYSTAINA_HALFELF) < 0, is(true));
        assertThat(lastNameComparator.compare(MYSTAINA_HALFELF, GRACE_HALFELF) > 0, is(true));
    }

    @Test
    public void comparesByMiddleInitialWhenLastAndFirstNamesAreEqual() {
        Record GRACE_2 = new Record("Halfelf", "Grace", "", "", "", "");

        GRACE_HALFELF.setMiddleInitial("M");

        GRACE_2.setMiddleInitial("M");
        assertThat(lastNameComparator.compare(GRACE_HALFELF, GRACE_2), is(0));

        GRACE_2.setMiddleInitial("Z");
        assertThat(lastNameComparator.compare(GRACE_HALFELF, GRACE_2) < 0, is(true));

        GRACE_2.setMiddleInitial("A");
        assertThat(lastNameComparator.compare(GRACE_HALFELF, GRACE_2) > 0, is(true));
    }
}