import java.util.Date;

/**
 * Created by Tarish Rhees on 9/19/2018.
 */
public class DateOfBirthComparator extends LastNameComparator {
    //TODO: Consider different design options with comparators. This one is going to do more than one thing!

    @Override
    public int compare(Record r1, Record r2) {
        Date r1Birthdate = r1.getDateOfBirth();
        Date r2Birthdate = r2.getDateOfBirth();

        int result = r1Birthdate.compareTo(r2Birthdate);
        if (result != 0) {
            return result;
        }
        return super.compare(r1, r2);
    }
}
