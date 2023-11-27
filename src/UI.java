import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class UI {

    Member member = new Member("first name", "last name", 1990, "email", "adresse", true, true);
    Scanner scanner = new Scanner(System.in);
    FileHandling fileHandling = new FileHandling();

    ///////////////////////////////////////////CREATE MEMBER///////////////////////////////////////////

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
        boolean validInput = false;

        do {
            System.out.println("Does the member want an active membership?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            choice = scanner.nextInt();

            if (choice == 1) {
                isActive = true;
                validInput = true;
            } else if (choice == 2) {
                isActive = false;
                validInput = true;
            } else {
                System.out.println("Invalid choice. Try again");
            }
        } while (!validInput);
        return isActive;
    }


        public boolean hasPaid () {
            int choice = 0;
            boolean hasPaid = true;
            boolean validInput = false;

            do {
                System.out.println("Has the member paid?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                choice = scanner.nextInt();

                if (choice == 1) {
                    hasPaid = true;
                    printConfirmationForPayment();
                    validInput = true;
                } else if (choice == 2) {
                    hasPaid = false;
                    System.out.println("Please provide payment in the next 30 days");
                    validInput = true;
                } else {
                    System.out.println("Invallid choice. Try again.");
                }

            } while (!validInput);
            return hasPaid;
        }


        public SwimDisciplin chooseSwimDisciplin () {
            int choice = 0;
            System.out.println("Please choose a swimming discipline:");
            System.out.println("1. Crawl");
            System.out.println("2. Butterfly");
            System.out.println("3. Breaststroke");
            System.out.println("4. Backcrawl");
            System.out.println("5. Medley");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    return SwimDisciplin.CRAWL;
                }
                case 2 -> {
                    return SwimDisciplin.BUTTERFLY;
                }
                case 3 -> {
                    return SwimDisciplin.BREASTSTROKE;
                }
                case 4 -> {
                    return SwimDisciplin.BACKCRAWL;
                }
                case 5 -> {
                    return SwimDisciplin.MEDLEY;
                }
                default -> {
                    System.out.println("Invalid choice, try again.");
                    return null;
                }
            }
        }


    ///////////////////////////////////////////MESSAGES///////////////////////////////////////////

        public void printConfirmationForPayment () {
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


        public void removeMessage () {
            System.out.println("Enter the number corresponding to the member you want to remove: ");
        }

        public void ConfirmationMessage () {
            System.out.println("Success!");
        }


///////////////////////////////////////////EDIT MEMBERS///////////////////////////////////////////



    public int chooseSwimmerType() {
        boolean validInput = false;
        int choice = 0;

        do {
            System.out.println("Please choose the type of swimmer:");
            System.out.println("1. Proffesional swimmers");
            System.out.println("2. Regular swimmers");
            choice = scanner.nextInt();

            if (choice == 1) {
                validInput = true;
            } else if (choice == 2) {
                validInput = true;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } while (!validInput);

        return choice;
    }

    ///////////////////////////////////////////UNCATEGORIZED///////////////////////////////////////////

    public int getUserInputInt () {
        Scanner scanner = new Scanner(System.in);
        removeMessage();
        return scanner.nextInt();
    }

}
