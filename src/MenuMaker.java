import java.util.Scanner;

public class MenuMaker {
    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;
    private int chooseStaffMember = -1;
    Chairman chairman = new Chairman();
    FileHandling fileHandling = new FileHandling();


    Menu mainMenu = new Menu("Main Menu:", pointsMainMenu());
    Menu chairmanMenu = new Menu("Chairman Menu:", pointsChairmanMenu());
    Menu coachMenu = new Menu("Coach Menu:", pointsCoachMenu());
    Menu cashierMenu = new Menu("Cashier Menu:", pointsCashierMenu());

    public void executeMenu() {
        chooseFromMainMenu();
        do {
            switch (chooseStaffMember) {
                case 0 -> exitProgram();
                case 1 -> chooseFromChairmanMenu();
                case 2 -> chooseFromCoachMenu();
                case 3 -> chooseFromCashierMenu();
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (userChoice != 0);
    }

    private void chooseFromCashierMenu() {
        cashierMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            //    case 1 -> fileHandling.printFinancesFile();
//            case 2 -> HVAD SKAL VI HAVE HER?
            case 9 -> chooseFromMainMenu();
        }
    }

    private void chooseFromCoachMenu() {
        coachMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            //    case 1 -> connectCoachToProSwimmer();
//            case 2 -> HVAD SKAL VI HAVE HER!?
            case 9 -> chooseFromMainMenu();
        }
    }

    private void chooseFromChairmanMenu() {
        chairmanMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> chairman.createProMember();
            case 2 -> chairman.createMember();
            case 3 -> chairman.removeMemberFromDelfinen();
            //    case 4 -> changeMembershipForExsitingMember();
            case 5 -> {
              fileHandling.loadAllMembersFromFile();
              fileHandling.initFromFile();
                chairman.displayMemberList();
            }
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

    private String[] pointsMainMenu() {
        return new String[]{"1. Chairman menu.", "2. Coach menu.",
                "3. Cashier menu.", "0. Exit program."};
    }

    private String[] pointsChairmanMenu() {
        return new String[]{"1. Add new pro member to Delfinen.", "2. Add new regular member.",
                "3. Remove member from Delfinen" + "4. Change membership for exsisting member.",
                "5. Display member list.", "9. Main Menu.", "0. Exit program"};
    }

    private String[] pointsCoachMenu() {
        return new String[]{"1. Connect to pro Swimmer", ".2. XXXXXXX",
                "9. Main Menu.", "0. Exit program"};
    }

    private String[] pointsCashierMenu() {
        return new String[]{"1. View finances", "2. XXXXXX",
                "9. Main Menu.", "0. Exit program."};
    }
}
