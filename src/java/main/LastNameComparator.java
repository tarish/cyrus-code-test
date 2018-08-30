import java.util.Comparator;

/**
 * Created by Tarish Rhees on 8/29/2018.
 */
public class LastNameComparator implements Comparator<Record> {
    @Override
    public int compare(Record r1, Record r2) {
        String r1LastName = r1.getLastName();
        String r2LastName = r2.getLastName();

        int lastNameEquality = r1LastName.compareToIgnoreCase(r2LastName);
        //If last name matches
        if (lastNameEquality == 0) {
            String r1FirstName = r1.getFirstName();
            String r2FirstName = r2.getFirstName();

            int firstNameEquality = r1FirstName.compareToIgnoreCase(r2FirstName);
            //If first name matches
            if (firstNameEquality == 0) {
                String r1MiddleInit = r1.getMiddleInitial();
                String r2MiddleInit = r2.getMiddleInitial();
                return r1MiddleInit.compareToIgnoreCase(r2MiddleInit);
            }
            return firstNameEquality;
        }
        return lastNameEquality;
    }
}
