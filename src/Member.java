public class Member {
    private String firstName;
    private  String lastName;
    private  int yearOfBirth;
    private String email;
    private  String adress;
    private boolean isActive;
    private boolean hasPaid;


    public Member (String firstName, String lastName, int yearOfBirth,
                   String email, String adress, boolean isActive, boolean hasPaid) {//der mangler type af svømmer
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.adress = adress;
        this.isActive = isActive;
        this.hasPaid = false;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }


    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
