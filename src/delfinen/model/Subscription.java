package delfinen.model;

public class Subscription {
    private String firstName;
    private  String lastName;
    private  int yearOfBirth;
    private String email;
    private boolean isActive;
    private boolean isPaid;
    private int price;


    public Subscription (String firstName, String lastName, String email,
                         boolean isActive, boolean isPaid, int subscriptionPrice ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.isActive = isActive;
        this.isPaid = isPaid;
        this.price = subscriptionPrice;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isPaid() {
        return isPaid;
    }


    public int getPrice() {
        return price;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
