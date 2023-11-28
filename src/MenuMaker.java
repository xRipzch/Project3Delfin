import java.io.Console;
import java.util.Scanner;

public class MenuMaker {
    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;
    private int chooseStaffMember = -1;
    Chairman chairman;
    Menu mainMenu = new Menu("Main Menu:", pointsMainMenu());
    Menu chairmanMenu = new Menu("Chairman Menu:", pointsChairmanMenu());
    Menu coachMenu = new Menu("Coach Menu:", pointsCoachMenu());
    Menu cashierMenu = new Menu("Cashier Menu:", pointsCashierMenu());
    Menu changeMemberMenu = new Menu("Change member menu", pointsChooseChangeMenu());

    public MenuMaker(Chairman chairman) {
        this.chairman = chairman;
    }


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
            case 2 -> chairman.createRegularMember();
            case 3 -> chairman.chooseRegularSwimmerToRemove();
            case 4 -> chairman.chooseProSwimmerToRemove();
            case 5 -> chairman.displayRegularMember();
            case 6 -> chairman.displayProMember();
            case 7 -> chooseChangeMenu();
            case 9 -> chooseFromMainMenu();
        }
    }

    private void chooseChangeMenu() {
changeMemberMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> exitProgram();
            case 1 -> chairman.changeRegularSwimmerToPro();
            case 2 -> chairman.changeProSwimmerToRegular();
        //    case 3 -> chairman.changeSwimDiciple();
            case 4 -> chairman.changeActivityStatus();
        //    case 5 -> chairman.changeEmail();
        //    case 6 -> chairman.changeAdress();

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
        return new String[]{ConsoleColors.BLUE + "1. Chairman menu.", "2. Coach menu.",
                "3. Cashier menu.", "0. Exit program." + ConsoleColors.RESET};
    }

    private String[] pointsChairmanMenu() {
        return new String[]{ConsoleColors.BLUE_BOLD + "1. Add new pro member to Delfinen.", "2. Add new regular member.",
                "3. Remove  regular member from Delfinen" + "\n4. Remove pro member from Delfinen.",
                "5. Display regular member list.", "6. Display pro member list.", "7. Edit member.", "9. Main Menu.", "0. Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsCoachMenu() {
        return new String[]{ConsoleColors.BLUE_BRIGHT + "1. Connect to pro Swimmer", ".2. XXXXXXX",
                "9. Main Menu.", "0. Exit program" + ConsoleColors.RESET};
    }

    private String[] pointsCashierMenu() {
        return new String[]{ConsoleColors.BLUE_UNDERLINED + "1. View finances", "2. XXXXXX",
                "9. Main Menu.", "0. Exit program." + ConsoleColors.RESET};
    }

    private String[] pointsChooseChangeMenu() {
        return new String[]{ConsoleColors.BLUE_BOLD + "1. Change regular swimmer to pro.",
                "2. Change pro swimmer to regular.", "3. Change swim diciplin for pro swimmer.",
                "4. Change activity status.", "5. Change email of member.",
                "6. Change address of member", "9. Main Menu.", "0. Exit program" + ConsoleColors.RESET};
    }
}
