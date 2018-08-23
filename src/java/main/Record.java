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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String forDisplay() {
        return String.format("%s %s %s %s %s",
                getLastName(), getFirstName(), getGender(),
                getDateOfBirth(), getFavoriteColor()
        );
    }
}
