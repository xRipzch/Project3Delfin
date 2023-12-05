package delfinen.menu;

import delfinen.misc.ConsoleColors;

import java.util.Scanner;

public class MainMenu {

    Menu mainMenu = new Menu("Main Menu:", pointsMainMenu());
    private Scanner scanner = new Scanner(System.in);
    int chooseStaffMember = -1;


    public int chooseFromMainMenu() {
        do {
            mainMenu.printMenu();
            chooseStaffMember = scanner.nextInt();
            if (chooseStaffMember == 0)
                exitProgram();
            return chooseStaffMember;
        } while (chooseStaffMember != 0);
    }


        private String[] pointsMainMenu () {
            return new String[]{ConsoleColors.PURPLE_BOLD_BRIGHT + "1." + ConsoleColors.BLUE_BOLD + " Chairman menu.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "2." + ConsoleColors.BLUE_BOLD + " Coach menu.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "3." + ConsoleColors.BLUE_BOLD + " Cashier menu.",
                    ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
        }

        public int exitProgram () {
            return chooseStaffMember = 0;
        }
    }

