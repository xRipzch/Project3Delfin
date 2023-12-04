package delfinen;

import java.util.Scanner;

public class MenuMaker {
    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;
    private int chooseStaffMember = -1;
    private Chairman chairman = new Chairman();
    private Cashier cashier = new Cashier();

    Menu mainMenu = new Menu("Main Menu:", pointsMainMenu());
    Menu chairmanMenu = new Menu("Chairman Menu:", pointsChairmanMenu());
    Menu coachMenu = new Menu("Coach Menu:", pointsCoachMenu());
    Menu cashierMenu = new Menu("Cashier Menu:", pointsCashierMenu());
    Menu changeMemberMenu = new Menu("Change member menu", pointsEditMenu());
    UI ui = new UI();



    public void executeMenu() {
        chooseFromMainMenu();
        do {
            switch (chooseStaffMember) {
                case 0 -> exitProgram();
                case 1 -> chooseFromChairmanMenu();
            //    case 2 -> chooseFromCoachMenu();
                case 3 -> chooseFromCashierMenu();
                default ->
                        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again." + ConsoleColors.RESET);
            }
        } while (userChoice != 0);
    }

    private void chooseFromCashierMenu() {
        cashierMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> cashier.displayFinance();
            case 2 -> cashier.displayMembersInArrears();
            case 3 -> cashier.recievePayment();
            case 9 -> chooseFromMainMenu();
        }
    }

   /* private void chooseFromCoachMenu() {
        coachMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();

            case 1 -> {
                coach.searchProSwimmerByName();
                System.out.println(proSwimmer.getTrainingResults());
            }
           // case 2 -> proSwimmer.searchProSwimmerByName1();
//            case 3 -> Ui.chooseSeniorOrJunior();
  //          case 4 -> coach.printBestFiveInDelfinen();
            case 9 -> chooseFromMainMenu();
        }
    }*/

    private void chooseFromChairmanMenu() {
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
            case 9 -> chooseFromMainMenu();
        }
    }

    private void chooseEditMenu() {
        changeMemberMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> chairman.changeRegularSwimmerToPro();
            case 2 -> chairman.changeProSwimmerToRegular();
            //    case 3 -> chairman.changeSwimDisciplineForProSwimmer();
            case 4 -> chairman.changeActivityStatus();
            //    case 5 -> chairman.changeEmail();
            //    case 6 -> chairman.changeAddress();
            case 9 -> chooseFromMainMenu();
        }
    }

    private void chooseFromMainMenu() {
        mainMenu.printMenu();
        chooseStaffMember = scanner.nextInt();
        if (chooseStaffMember == 0)
            exitProgram();
    }

    private int exitProgram() {
        return userChoice = 0;
    }

    public void loadFileProSwimmers() {
        chairman.loadFileProSwimmers();

    }


    private String[] pointsMainMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Chairman menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Coach menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Cashier menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsChairmanMenu() {
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

    private String[] pointsCoachMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Add time to swimmer." + ConsoleColors.PURPLE_BOLD_BRIGHT + "[" +ConsoleColors.CYAN_BOLD_BRIGHT + "Training" +ConsoleColors.PURPLE_BOLD_BRIGHT +"]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Add time to swimmer." + ConsoleColors.PURPLE_BOLD_BRIGHT + "[" + ConsoleColors.CYAN_BOLD_BRIGHT +"Competition" + ConsoleColors.PURPLE_BOLD_BRIGHT +"]",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " View top 5 for different disciplines.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " View top 5 for all swimmers in Delfinen.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsCashierMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " View finances.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Show members in arrears.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Receive payment from member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }
// TODO KONTINUIETT OM PRO ELLER REGULAR KOMEMR FØRST I SOUTS/KODEN
    private String[] pointsEditMenu() {
        return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Change regular swimmer to pro.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Change pro swimmer to regular.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Change swim discipline for pro swimmer.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Change activity status.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.BLUE_BOLD + " Change email of member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "6." + ConsoleColors.BLUE_BOLD + " Change address of member",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }
}
