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
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.favoriteColor = favoriteColor;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName != null ? lastName : "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName != null ? firstName : "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial != null ? middleInitial : "";
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getGender() {
        return gender != null ? gender : "";
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteColor() {
        return favoriteColor != null ? favoriteColor : "";
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getDateOfBirth() {
        return dateOfBirth != null ? dateOfBirth : "";
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
