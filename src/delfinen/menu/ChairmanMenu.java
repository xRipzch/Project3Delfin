package delfinen.menu;

import delfinen.model.Chairman;
import delfinen.misc.ConsoleColors;

import java.util.Scanner;

public class ChairmanMenu {
    Menu chairmanMenu = new Menu("Chairman Menu:", pointsChairmanMenu());
    Menu changeMemberMenu = new Menu("Change member menu", pointsEditMenu());
    MainMenu mainMenu = new MainMenu();

    private Chairman chairman = new Chairman();
    private Scanner scanner = new Scanner(System.in);
    private int userChoice = -1;


    public void chooseFromChairmanMenu() {
        chairmanMenu.printMenu();
        userChoice = scanner.nextInt();
            switch (userChoice) {
                case 0 -> mainMenu.exitProgram();
                case 1 -> chairman.addProSwimmer();
                case 2 -> chairman.addRegularSwimmer();
                case 3 -> chairman.removeRegularSwimmer();
                case 4 -> chairman.removeProSwimmer();
                case 5 -> chairman.displayRegularSwimmer();
                case 6 -> chairman.displayProSwimmer();
                case 7 -> chooseEditMenu();
                case 9 -> mainMenu.executeMainMenu(0);
            }
    }


    public void chooseEditMenu() {
        changeMemberMenu.printMenu();
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 0 -> mainMenu.exitProgram();
            case 1 -> chairman.changeRegularSwimmerToPro();
            case 2 -> chairman.changeProSwimmerToRegular();
//                case 3 -> chairman.changeSwimDisciplineForProSwimmer();
            case 4 -> chairman.changeActivityStatus();
//                case 5 -> chairman.changeEmail();
//                case 6 -> chairman.changeAddress();
            case 9 -> mainMenu.executeMainMenu(0);
        }
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
                ConsoleColors.PURPLE_BOLD_BRIGHT + "4." + ConsoleColors.BLUE_BOLD + " Change activity status.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "5." + ConsoleColors.BLUE_BOLD + " Change email of member.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "6." + ConsoleColors.BLUE_BOLD + " Change address of member",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "9." + ConsoleColors.BLUE_BOLD + " Main Menu.",
                ConsoleColors.PURPLE_BOLD_BRIGHT + "0." + ConsoleColors.BLUE_BOLD + " Exit program" + ConsoleColors.RESET};
    }
}
