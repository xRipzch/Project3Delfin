import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class UI {

    Scanner scanner = new Scanner(System.in);


    ///////////////////////////////////////////FIRST AND LAST NAME///////////////////////////////////////////

    public String typeFirstName() {
        String firstName = "";
        while (firstName.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BRIGHT +"Please enter the new members first name:" + ConsoleColors.RESET);
            firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Field can't be empty. try again" + ConsoleColors.RESET);
            }
        }
        return firstName;
    }

    public String typeLastName() {
        String lastName = "";
        while (lastName.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Please enter the new members last name:" + ConsoleColors.RESET);
            lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Field can't be empty. try again" + ConsoleColors.RESET);
            }
        }
        return lastName;
    }
/////////////////////////////////////////////Year of Birth////////////////////////////////////////////////////
    public int typeYearOfBirth() {
        int yearOfBirth = 0;

        while (yearOfBirth == 0 || !isValidYearOfBirth(yearOfBirth)) {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Please enter the new member's year of birth: [YYYY]"
            + ConsoleColors.RESET);
            try {
                String input = scanner.nextLine().trim();

                if (input.length() > 4) {  // Sikre at inputtet ikke er længere end 4 cifre
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter a valid number " +
                            "for the year of birth." + ConsoleColors.RESET);
                    continue;
                }
                yearOfBirth = Integer.parseInt(input);

                if (yearOfBirth == 0 || !isValidYearOfBirth(yearOfBirth)) {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid year of birth. Please enter a valid " +
                            "year." + ConsoleColors.RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter a valid number " +
                        "for the year of birth." + ConsoleColors.RESET);
            }
        }

        return yearOfBirth;
    }
    
    public boolean isValidYearOfBirth (int yearOfBirth) { //sikre at YOB er mellem 1900 og nuværende år
        int currentYear = LocalDate.now().getYear();
        return yearOfBirth > 1900 && yearOfBirth <= currentYear;
    }

//////////////////////////////////////////EMAIL///////////////////////////////////////////
    public String typeEmailAddress() {
           String email= "";
           while (email.isEmpty() || !isValid(email)) {
               System.out.println(ConsoleColors.BLUE_BRIGHT + "Please enter the new members email:" + ConsoleColors.RESET);
               email = scanner.nextLine().trim();

               if (email.isEmpty()) {  // Sikre at emailen er i korrekt format, ellers skal den prompte igen
                   System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Field can't be empty. Try again!" + ConsoleColors.RESET);
                } else if (!isValid(email)) {
                   System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid email. Try again!" + ConsoleColors.RESET);
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

////////////////////////////////////////////Address////////////////////////////////////////////////////
    public String typeAddress() { //Skal der tilføjes noget ift. nummer?
        String address = "";
        while (address.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Please enter the new members address:" + ConsoleColors.RESET);
            address = scanner.nextLine().trim();
            if (address.isEmpty()) {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Field can't be empty. try again" + ConsoleColors.RESET);
            }
        }
        return address;
    }

    public boolean isActive() {
        int choice = 0;
        boolean isActive = false;
        boolean validInput = false;

        do {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Does the member want an active membership?");
            System.out.println("1. Yes");
            System.out.println("2. No" + ConsoleColors.RESET);

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                isActive = true;
                validInput = true;
            } else if (choice == 2) {
                isActive = false;
                validInput = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again" + ConsoleColors.RESET);
            }
        } while (!validInput);
        return isActive;
    }


        public boolean isPaid () {
            int choice = 0;
            boolean isPaid = false;
            boolean validInput = false;

            do {
                System.out.println(ConsoleColors.BLUE_BRIGHT + "Has the member paid?");
                System.out.println("1. Yes");
                System.out.println("2. No" + ConsoleColors.RESET);

                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    isPaid = true;
                    printConfirmationForPayment();
                    validInput = true;
                } else if (choice == 2) {
                    isPaid = false;
                    System.out.println(ConsoleColors.BLUE_BRIGHT + "Please provide payment in the next 30 days" + ConsoleColors.RESET);
                    validInput = true;
                } else {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again." + ConsoleColors.RESET);
                }

            } while (!validInput);
                return isPaid;
        }


        public SwimDiscipline chooseSwimDisciplin () {
            int choice = 0;
            System.out.println(ConsoleColors.BLUE_BRIGHT + "\nPlease choose a swimming discipline:");
            System.out.println("1. Crawl");
            System.out.println("2. Butterfly");
            System.out.println("3. Breaststroke");
            System.out.println("4. Backcrawl");
            System.out.println("5. Medley" + ConsoleColors.RESET);
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    return SwimDiscipline.CRAWL;
                }
                case 2 -> {
                    return SwimDiscipline.BUTTERFLY;
                }
                case 3 -> {
                    return SwimDiscipline.BREASTSTROKE;
                }
                case 4 -> {
                    return SwimDiscipline.BACKSTROKE;
                }
                case 5 -> {
                    return SwimDiscipline.MEDLEY;
                }
                default -> {
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice, try again." + ConsoleColors.RESET);
                    return null;
                }
            }
        }


    ///////////////////////////////////////////MEMBER CREATION MESSAGES///////////////////////////////////////////


        public void removeMessage () {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Enter the number corresponding to the member you want to remove: "
                    + ConsoleColors.RESET);
        }

        public void memberCreatedConfirmationMessage () {
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "\nNew member successfully added to system!" + ConsoleColors.RESET);
        }


///////////////////////////////////////////EDIT MEMBERS///////////////////////////////////////////

    public int chooseSwimmerType() {
        boolean validInput = false;
        int choice = 0;

        do {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Please choose the type of swimmer:");
            System.out.println("1. Professional swimmers");
            System.out.println("2. Regular swimmers" + ConsoleColors.RESET);
            choice = scanner.nextInt();

            if (choice == 1) {
                validInput = true;
            } else if (choice == 2) {
                validInput = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again.");
            }
        } while (!validInput);

        return choice;
    }

    public int chooseMember(){
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Please choose member" + ConsoleColors.RESET);//skal sikres så den kan catche et forkert svar
        int choice = scanner.nextInt();
        scanner.nextLine();
        int chosenMember = choice - 1;
        return chosenMember;
    }


    public int chooseStatus() {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Change the status to:");
        System.out.println("1. Active.");
        System.out.println("2. Passive." + ConsoleColors.RESET);
        scanner.nextLine();
        int choice = scanner.nextInt();
        return choice;
    }



    ///////////////////////////////////////////Subscription MESSAGES ///////////////////////////////////////////

    public void printConfirmationForPayment () {
        try {
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + "Processing Payment");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("." + ConsoleColors.RESET);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Payment received!" + ConsoleColors.RESET);
    }

    public void printSubscriptionPrice(int subscriptionPrice){
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "You're subscription fee is:  " +
                ConsoleColors.GREEN_UNDERLINED + subscriptionPrice + ConsoleColors.GREEN_BOLD_BRIGHT + " DKK,-" + ConsoleColors.RESET);
    }

}
