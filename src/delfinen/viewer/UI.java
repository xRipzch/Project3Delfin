package delfinen.viewer;

import delfinen.model.ProSwimmer;
import delfinen.misc.ConsoleColors;
import delfinen.misc.SwimDiscipline;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class UI {

    Scanner scanner = new Scanner(System.in);
    ProSwimmer proSwimmer = new ProSwimmer("first", "last", 1994, " email", "address", true, true, SwimDiscipline.BACKSTROKE);






    ///////////////////////////////////////////FIRST AND LAST NAME///////////////////////////////////////////

    public String typeFirstName() {
        String firstName = "";
        while (firstName.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Please enter the new members first name:" + ConsoleColors.RESET);
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
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Please enter the new member's year of birth:"+
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "["+ConsoleColors.CYAN_BOLD_BRIGHT + "YYYY" +
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "]" + ConsoleColors.RESET);
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

    public boolean isValidYearOfBirth(int yearOfBirth) { //sikre at YOB er mellem 1900 og nuværende år
        int currentYear = LocalDate.now().getYear();
        return yearOfBirth > 1900 && yearOfBirth <= currentYear;
    }

    //////////////////////////////////////////EMAIL///////////////////////////////////////////
    public String typeEmailAddress() {
        String email = "";
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
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BRIGHT + " Yes");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BRIGHT + " No" + ConsoleColors.RESET);

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


    public boolean isPaid() {
        int choice = 0;
        boolean isPaid = false;
        boolean validInput = false;

        do {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Has the member paid?");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BRIGHT + " Yes");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BRIGHT + " No" + ConsoleColors.RESET);

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


    public SwimDiscipline chooseSwimDisciplin() {
        int choice = 0;
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\nPlease choose a swimming discipline:");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Crawl.");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Butterfly.");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Breaststroke.");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Backstroke.");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.BLUE_BOLD + " Medley." + ConsoleColors.RESET);
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


    public void removeMessage() {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Enter the number corresponding to the member you want to remove: "
                + ConsoleColors.RESET);
    }

    public void memberCreatedConfirmationMessage() {
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + " has " +ConsoleColors.GREEN_BOLD_BRIGHT + "successfully" +
               ConsoleColors.YELLOW_BOLD_BRIGHT + " been added to the system!" + ConsoleColors.RESET);
    }


///////////////////////////////////////////EDIT MEMBERS///////////////////////////////////////////

    public int chooseSwimmerType() { //bliver ikke brugt længere
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

    public int chooseMember() {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Please choose member" + ConsoleColors.RESET);//skal sikres så den kan catche et forkert svar
        int choice = scanner.nextInt();
        scanner.nextLine();
        int chosenMember = choice - 1;
        return chosenMember;
    }


    public int chooseStatus() {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Change the status to:");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BRIGHT + " Active.");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BRIGHT + " Passive." + ConsoleColors.RESET);
        int choice = scanner.nextInt();
        return choice;
    }
        public String askForName() {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Enter the name of the member you want to note swim time for: " + ConsoleColors.RESET);
            String name = scanner.nextLine();

            return name;
        }
        public double askForTime() {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Enter the time you want to add: " + ConsoleColors.RESET);
            double time = scanner.nextDouble();
            scanner.nextLine();
            return time;
        }

    ///////////////////////////////////////////Subscription MESSAGES ///////////////////////////////////////////

    public void printConfirmationForPayment() {
        try {
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + "Processing Payment");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(ConsoleColors.RED_BOLD_BRIGHT + " ..");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + " ..");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(ConsoleColors. GREEN_BOLD_BRIGHT + " .." + ConsoleColors.RESET);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Payment Received!\n" + ConsoleColors.RESET);
    }

    public void printSubscriptionPrice(int subscriptionPrice) {
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "You're subscription fee is: " + ConsoleColors.GREEN_BOLD_BRIGHT +
                ConsoleColors.GREEN_UNDERLINED + subscriptionPrice + ConsoleColors.RESET +
                ConsoleColors.GREEN_BOLD_BRIGHT + " DKK,-" + ConsoleColors.RESET);
    }
///////////////////////////////////////Coach Menuer/////////////////////////////////////////////////////////////////////////////
    /*public void chooseSeniorOrJunior ()   {

        int choice = 0;
        System.out.println("1. Senior");
        System.out.println("2. Junior");
        switch (choice) {
            case 1 -> displayBestFiveSenior();
            case 2 -> displayBestFiveJunior();
        }
    }


    public void displayBestFiveSenior() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Crawl");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Backstroke");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "3. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Breaststroke");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "4. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Butterfly");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "5. " + ConsoleColors.RESET + "Show best 5 senior swimmers in Medley");

        int choice = 0;
        switch (choice) {
            case 1 -> coach.printBestFiveSeniorSwimmersInCrawl();
            case 2 -> coach.printBestFiveSeniorSwimmersBackstroke();
            case 3 -> coach.printBestFiveSeniorSwimmersBreaststroke();
            case 4 -> coach.printBestFiveSeniorSwimmersButterfly();
            case 5 -> coach.printBestFiveSeniorSwimmersMedley();
        }
    }

    public void displayBestFiveJunior() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Crawl");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Backstroke");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "3. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Breaststroke");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "4. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Butterfly");
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "5. " + ConsoleColors.RESET + "Show best 5 junior swimmers in Medley");

        int choice = 0;
        switch (choice) {
            case 1 -> coach.printBestFiveJuniorSwimmersInCrawl();
            case 2 -> coach.printBestFiveJuniorSwimmersBackstroke();
            case 3 -> coach.printBestFiveJuniorSwimmersBreaststroke();
            case 4 -> coach.printBestFiveJuniorSwimmersButterfly();
            case 5 -> coach.printBestFiveJuniorSwimmersMedley();
        }
    } */
}