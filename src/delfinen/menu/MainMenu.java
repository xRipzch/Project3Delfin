package delfinen.menu;

import delfinen.misc.ConsoleColors;
import delfinen.model.Cashier;
import delfinen.model.Chairman;
import delfinen.model.Coach;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    Menu mainMenu = new Menu("Main Menu:", pointsMainMenu());
    Menu chairmanMenu = new Menu("Chairman Menu:", pointsChairmanMenu());
    Menu changeMemberMenu = new Menu("Change member menu", pointsEditMenu());
    Menu cashierMenu = new Menu("Cashier Menu:", pointsCashierMenu());
    Menu juniorAndSeniorMenu = new Menu("Choose action", pointsJuniorAndSeniorMenu());
    Menu chooseSwimDisciplineMenu = new Menu("Choose swim discipline", pointsSwimDisciplineMenu());
    Menu specificPrintDisciplineMenu = new Menu("Choose action", pointsSpecificDisciplineMenu());

    Coach coach = new Coach();
    ArrayList<Coach> coaches = coach.getCoaches();

    private Chairman chairman = new Chairman();
    private Cashier cashier = new Cashier();
    private Scanner scanner = new Scanner(System.in);
    private int chooseStaffMember = -1;
    private int userChoice = -1;

    public void executeMainMenu() {
        mainMenu.printMenu();
        chooseStaffMember = scanner.nextInt();
            do {
                switch (chooseStaffMember) {
                    case 0 -> chooseStaffMember = exitProgram();
                    case 1 -> chooseFromChairmanMenu();
                    case 2 -> chooseSwimDiscipline();
                    case 3 -> chooseFromCashierMenu();
                    default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again." + ConsoleColors.RESET);
                }
            } while (chooseStaffMember != 0);
    }

    public void chooseFromChairmanMenu() {
        chairmanMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> chairman.addProSwimmer();
            case 2 -> chairman.addRegularSwimmer();
            case 3 -> chairman.removeRegularSwimmer();
            case 4 -> chairman.removeProSwimmer();
            case 5 -> chairman.displayRegularSwimmer();
            case 6 -> chairman.displayProSwimmer();
            case 7 -> chooseEditMenu();
            case 9 -> executeMainMenu();
        }
    }


    public void chooseEditMenu() {
        changeMemberMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> chairman.changeRegularSwimmerToPro();
            case 2 -> chairman.changeProSwimmerToRegular();
//                case 3 -> chairman.changeSwimDisciplineForProSwimmer();
            case 4 -> chairman.changeActivityStatusRegular();
            case 5 -> chairman.changeActivityStatusPro();
//                case 5 -> chairman.changeEmail();
//                case 6 -> chairman.changeAddress();
            case 9 -> executeMainMenu();
        }
    }

    public void chooseFromCashierMenu() {
        cashierMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> cashier.displayFinances();
            case 2 -> cashier.printMembersInArrears();
            case 3 -> cashier.processPayment();
            case 9 -> executeMainMenu();
        }
    }

    public void chooseSwimDiscipline() {
        chooseSwimDisciplineMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> chooseSpecificDisciplineMenu(0);
            case 2 -> chooseSpecificDisciplineMenu(1);
            case 3 -> chooseSpecificDisciplineMenu(2);
            case 4 -> chooseSpecificDisciplineMenu(3);
            case 5 -> chooseSpecificDisciplineMenu(4);
            case 9 -> executeMainMenu();
        }
    }

    public void chooseSpecificDisciplineMenu(int choice) {
        specificPrintDisciplineMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> juniorMenu(choice);
            case 2 -> seniorMenu(choice);
            case 9 -> executeMainMenu();
        }
    }


    public void juniorMenu(int choice) {
        juniorAndSeniorMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> coaches.get(choice).printBestFiveJuniorSwimmers();
            case 2 -> coaches.get(choice).printBestFiveJuniorCompSwimmers();
            case 3 -> coaches.get(choice).selectTrainingJunior();
            case 4 -> coaches.get(choice).selectCompJunior();
            case 9 -> executeMainMenu();
        }
    }

    public void seniorMenu(int choice) {
        juniorAndSeniorMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> coaches.get(choice).printBestFiveSeniorSwimmers();
            case 2 -> coaches.get(choice).printBestFiveSeniorCompSwimmers();
            case 3 -> coaches.get(choice).selectTrainingSenior();
            case 4 -> coaches.get(choice).selectCompSenior();
            case 9 -> executeMainMenu();
        }
    }


    public int exitProgram () {
        System.exit(0); // PLACEHOLDER
        return chooseStaffMember = 0;
    }

    private String[] pointsMainMenu () {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Chairman menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Coach menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Cashier menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }


    public String[] pointsChairmanMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Add new pro member to Delfinen.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Add new regular member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Remove  regular member from Delfinen",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Remove pro member from Delfinen.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.BLUE_BOLD + " Display regular member list.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "6." + ConsoleColors.BLUE_BOLD + " Display pro member list.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "7." + ConsoleColors.BLUE_BOLD + " Edit member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    public String[] pointsEditMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Change regular swimmer to pro.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Change pro swimmer to regular.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Change swim discipline for pro swimmer.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Change activity status for regular swimmer.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.BLUE_BOLD + " Change activity status for pro swimmer.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "6." + ConsoleColors.BLUE_BOLD + " Change email of member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "7." + ConsoleColors.BLUE_BOLD + " Change address of member",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    public String[] pointsCashierMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " View finances.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Show members in arrears.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Receive payment from member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsSwimDisciplineMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.CYAN_BOLD_BRIGHT + " Backstroke.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.CYAN_BOLD_BRIGHT + " Breaststroke.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.CYAN_BOLD_BRIGHT + " Butterfly.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.CYAN_BOLD_BRIGHT + " Crawl.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.CYAN_BOLD_BRIGHT + " Medley.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }


    private String[] pointsSpecificDisciplineMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " View junior swimmers.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " View senior swimmer.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};

    }

    private String[] pointsCoachMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Add time to swimmer." +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                "2" + ConsoleColors.BLUE_BOLD + " Competition PLACEHOLDER // TODO" + ConsoleColors.PURPLE_BOLD_BRIGHT +
                        "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines for Juniors",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines for Seniors.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsJuniorAndSeniorMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Show top 5 swimmers." +
                ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Show top 5 swimmers." +
                        ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Note time for swimmer." +
                        ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Training" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Note time for swimmer." +
                        ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT + "Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT + "]",

                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }



}

