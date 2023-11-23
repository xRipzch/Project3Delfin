import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class UI {

    Member member = new Member("first name", "last name", 1990, "email", "adresse", true, true);
    Scanner scanner = new Scanner(System.in);
    FileHandling fileHandling = new FileHandling();

    public String typeFirstName() {
        String firstName = "";
        while (firstName.isEmpty()) {
            System.out.println("Please enter the new members first name:");
            firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()) {
                System.out.println("Field can't be empty. try again");
            }
        }
        return firstName;
    }

    public String typeLastName() {
        String lastName = "";
        while (lastName.isEmpty()) {
            System.out.println("Please enter the new members last name:");
            lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) {
                System.out.println("Field can't be empty. try again");
            }
        }
        return lastName;
    }

    public int typeYearOfBirth() {//kontrol for for langt tal
        int yearOfBirth = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Please enter the new members birthyear");
            try {
                yearOfBirth = Integer.parseInt(scanner.nextLine().trim());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return yearOfBirth;
    }


    public String typeEmailAdress() { //skal der tilføjes noget for at sikre at der indtastes et gyldigt email format?
        String emailAdress = "";
        while (emailAdress.isEmpty()) {
            System.out.println("Please enter the new members Email adress:");
            emailAdress = scanner.nextLine().trim();
            if (emailAdress.isEmpty()) {
                System.out.println("Field can't be empty. try again");
            }
        }
        return emailAdress;
    }


    public String typeAdress() { //skal der tilføjes noget ift. nummer?
        String adress = "";
        while (adress.isEmpty()) {
            System.out.println("Please enter the new members adress:");
            adress = scanner.nextLine().trim();
            if (adress.isEmpty()) {
                System.out.println("Field can't be empty. try again");
            }
        }
        return adress;
    }

    public boolean isActive() {
        int choice = 0;
        boolean isActive = false;
        System.out.println("Does the member want an active membership?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> isActive = true;
            case 2 -> isActive = false;
            default -> {
                System.out.println("Invalid choice. Try again.");
                isActive();
            }
        }
        return isActive;
    }

    public boolean hasPaid() {
        int choice = 0;
        boolean hasPaid = false;
        System.out.println("Has the member paid?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                hasPaid = true;
                printConfirmationForPayment(member);

            }
            case 2 -> hasPaid = false;
            default -> {
                System.out.println("Invalid choice. Try again.");
                hasPaid();
            }
        }
        return hasPaid;

    }

    public void printConfirmationForPayment(Member member) {
        Subscription Subscription = new Subscription();
        System.out.println("You're subscription is:  " +
                Subscription.getSubscriptionPrice(member) + "$$$.");
        try {
            System.out.println("Proccessing Payment.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Proccessing Payment..");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Proccessing Payment...");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Payment received!");
    }

    public int getUserInputInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number corresponding to the member you want to remove: ");
        return scanner.nextInt();
    }
}