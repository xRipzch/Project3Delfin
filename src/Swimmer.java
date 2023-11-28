public class Swimmer {
    private String firstName;
    private  String lastName;
    private  int yearOfBirth;
    private String email;
    private  String adress;
    private boolean isActive;
    private boolean isPaid;


    public Swimmer(String firstName, String lastName, int yearOfBirth,
                   String email, String adress, boolean isActive, boolean isPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.adress = adress;
        this.isActive = isActive;
        this.isPaid = isPaid;
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

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
