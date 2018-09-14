import java.util.Comparator;

/**
 * Created by Tarish Rhees on 9/13/2018.
 */
public class GenderAndLastNameComparator extends LastNameComparator {
    //TODO: Consider different design options with comparators. This one is going to do more than one thing!

    @Override
    public int compare(Record r1, Record r2) {
        String r1Gender = r1.getGender();
        String r2Gender = r2.getGender();

        //TODO: Look up pattern rules!! Something tickling my brain about favoring composition over inheritence?
        int result = r1Gender.compareToIgnoreCase(r2Gender);
        if (result != 0) {
            return result;
        }
        return super.compare(r1, r2);
    }
}
