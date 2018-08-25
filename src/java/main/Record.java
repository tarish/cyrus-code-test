/**
 * Created by Tarish Rhees on 8/23/2018.
 */
public class Record {
    private String lastName;
    private String firstName;
    private String middleInitial;
    private String gender;
    private String favoriteColor;
    private String dateOfBirth;

    public Record() {
    }

    public Record(String lastName, String firstName, String middleInitial, String gender, String favoriteColor, String dateOfBirth) {
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleInitial(middleInitial);
        setGender(gender);
        setFavoriteColor(favoriteColor);
        setDateOfBirth(dateOfBirth);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) lastName = "";
        this.lastName = lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) firstName = "";
        this.firstName = firstName.trim();
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        if (middleInitial == null) middleInitial = "";
        this.middleInitial = middleInitial.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null) gender = "";
        this.gender = gender.trim();
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        if (favoriteColor == null) favoriteColor = "";
        this.favoriteColor = favoriteColor.trim();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null) dateOfBirth = "";
        this.dateOfBirth = dateOfBirth.trim();
    }

    public String getForDisplay() {
        return String.format("%s\t%s\t%s\t%s\t%s",
                getLastName(), getFirstName(), getGender(),
                getDateOfBirth(), getFavoriteColor()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (getLastName() != null ? !getLastName().equals(record.getLastName()) : record.getLastName() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(record.getFirstName()) : record.getFirstName() != null)
            return false;
        if (getMiddleInitial() != null ? !getMiddleInitial().equals(record.getMiddleInitial()) : record.getMiddleInitial() != null)
            return false;
        if (getGender() != null ? !getGender().equals(record.getGender()) : record.getGender() != null) return false;
        if (getFavoriteColor() != null ? !getFavoriteColor().equals(record.getFavoriteColor()) : record.getFavoriteColor() != null)
            return false;
        return getDateOfBirth() != null ? getDateOfBirth().equals(record.getDateOfBirth()) : record.getDateOfBirth() == null;

    }

    @Override
    public int hashCode() {
        int result = getLastName() != null ? getLastName().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getMiddleInitial() != null ? getMiddleInitial().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getFavoriteColor() != null ? getFavoriteColor().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Last: %s; First: %s; Middle: %s; Gender: %s; Color: %s; DOB: %s",
                getLastName(), getFirstName(), getMiddleInitial(), getGender(), getFavoriteColor(), getDateOfBirth()
        );
    }
}
