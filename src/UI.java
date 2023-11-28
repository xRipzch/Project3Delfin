import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class UI {

    Swimmer swimmer = new Swimmer("first name", "last name", 1990, "email", "adresse", true, true);
    Scanner scanner = new Scanner(System.in);


    ///////////////////////////////////////////FIRST AND LAST NAME///////////////////////////////////////////

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
/////////////////////////////////////////////Year of Birth////////////////////////////////////////////////////
    public int typeYearOfBirth() {
        int yearOfBirth = 0;

        while (yearOfBirth == 0 || !isValidYearOfBirth(yearOfBirth)) {
            System.out.println("Please enter the new member's year of birth: [YYYY]");
            try {
                String input = scanner.nextLine().trim();

                if (input.length() > 4) {  // Sikre at inputtet ikke er længere end 4 cifre
                    System.out.println("Invalid input. Please enter a valid number for the year of birth.");
                    continue;
                }
                yearOfBirth = Integer.parseInt(input);

                if (yearOfBirth == 0 || !isValidYearOfBirth(yearOfBirth)) {
                    System.out.println("Invalid year of birth. Please enter a valid year.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the year of birth.");
            }
        }

        return yearOfBirth;
    }
    
    public boolean isValidYearOfBirth (int yearOfBirth) { //sikre at YOB er mellem 1900 og nuværende år
        int currentYear = LocalDate.now().getYear();
        return yearOfBirth > 1900 && yearOfBirth <= currentYear;
    }

//////////////////////////////////////////EMAIL///////////////////////////////////////////
    public String typeEmailAdress() {
           String email= "";
           while (email.isEmpty() || !isValid(email)) {
               System.out.println("Please enter the new members email:");
               email = scanner.nextLine().trim();

               if (email.isEmpty()) {  // Sikre at emailen er i korrekt format, ellers skal den prompte igen
                   System.out.println("Field can't be empty. Try again!");
                } else if (!isValid(email)) {
                   System.out.println("Invalid email. Try again!");
               }
           }
              return email;
    }

    private boolean isValid(String email) {     // Logik til at tjekke om emailen er i korrekt format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                             "[a-zA-Z0-9_+&*-]+)*@" +
                             "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                             "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

////////////////////////////////////////////Adress////////////////////////////////////////////////////
    public String typeAdress() { //Skal der tilføjes noget ift. nummer?
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
            scanner.nextLine();

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


        public boolean isPaid () {
            int choice = 0;
            boolean isPaid = false;
            boolean validInput = false;

            do {
                System.out.println("Has the member paid?");
                System.out.println("1. Yes");
                System.out.println("2. No");

                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    isPaid = true;
                    printConfirmationForPayment();
                    validInput = true;
                } else if (choice == 2) {
                    isPaid = false;
                    System.out.println("Please provide payment in the next 30 days");
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }

            } while (!validInput);
                return isPaid;
        }


        public SwimDisciplin chooseSwimDisciplin () {
            int choice = 0;
            System.out.println("\nPlease choose a swimming discipline:");
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
                System.out.print(ConsoleColors.RED_BOLD + "Proccessing Payment.");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(ConsoleColors.RESET);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(ConsoleColors.GREEN_BOLD + "Payment received!" + ConsoleColors.RESET);
        }


        public void removeMessage () {
            System.out.println(ConsoleColors.BLUE + "Enter the number corresponding to the member you want to remove: "
                    + ConsoleColors.RESET);
        }

        public void ConfirmationMessage () {
            System.out.println(ConsoleColors.GREEN_BOLD + "Success!" + ConsoleColors.RESET);
        }


///////////////////////////////////////////EDIT MEMBERS///////////////////////////////////////////

    public int chooseSwimmerType() {
        boolean validInput = false;
        int choice = 0;

        do {
            System.out.println(ConsoleColors.BLUE + "Please choose the type of swimmer:");
            System.out.println("1. Proffesional swimmers");
            System.out.println("2. Regular swimmers" + ConsoleColors.RESET);
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

    public int chooseMember(){
        System.out.println("Please choose member");//skal sikres så den kan catche et forkert svar
        int choice = scanner.nextInt();
        scanner.nextLine();
        int chosenMember = choice - 1;
        return chosenMember;
    }


    public int chooseStatus() {
        System.out.println("Change the status to:");
        System.out.println("1. Active.");
        System.out.println("2. Passive.");
        scanner.nextLine();
        int choice = scanner.nextInt();
        return choice;
    }



    ///////////////////////////////////////////UNCATEGORIZED///////////////////////////////////////////

    //public int getUserInputInt () {
        //Scanner scanner = new Scanner(System.in);
        //removeMessage();
        //return scanner.nextInt();
    //}

}
