package delfinen.menu;

import delfinen.misc.ConsoleColors;

import java.util.Scanner;

public class MainMenu {

    Menu mainMenu = new Menu("Main Menu:", pointsMainMenu());

    private Scanner scanner = new Scanner(System.in);
    int chooseStaffMember = -1;

    public void executeMainMenu(int userChoice) {
        CashierMenu cashierMenu = new CashierMenu();
        CoachMenu coachMenu = new CoachMenu();
        ChairmanMenu chairmanMenu = new ChairmanMenu();

        mainMenu.printMenu();
        chooseStaffMember = scanner.nextInt();
        do {
            do {
                switch (chooseStaffMember) {
                    case 0 -> chooseStaffMember = exitProgram();
                    case 1 -> chairmanMenu.chooseFromChairmanMenu();
                    case 2 -> coachMenu.chooseSwimDiscipline();
                    case 3 -> cashierMenu.chooseFromCashierMenu();
                    default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice. Try again." + ConsoleColors.RESET);
                }
            } while (chooseStaffMember != 0);
        } while (userChoice != 0 || chooseStaffMember !=0);
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

}

