package delfinen;

import delfinen.filehandling.FHRegularSwimmer;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChairmanRegularController {
    UI ui = new UI();

    private CashierController cashierController = new CashierController();
    private FHRegularSwimmer fhRegularSwimmer = new FHRegularSwimmer();
    private ArrayList<Swimmer> regularSwimmers = fhRegularSwimmer.loadRegularMembersFromFile();

    private boolean isValidIndexRegular(int index, ArrayList<Swimmer> regularSwimmers) {
        return index >= 0 && index < regularSwimmers.size();
    }

    public void createRegularMember() {
        Swimmer swimmer = new Swimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAddress(), ui.typeAddress(), ui.isActive(), ui.isPaid());

        addRegularSwimmerToList(swimmer);
        System.out.print(ConsoleColors.CYAN_BOLD_BRIGHT + swimmer.getFirstName() + ConsoleColors.RESET);
        ui.memberCreatedConfirmationMessage();
        cashierController.createSubscription(swimmer);
        fhRegularSwimmer.saveInRegularSwimmersFile(regularSwimmers);
    }
    public void addRegularSwimmerToList(Swimmer swimmer){
        regularSwimmers.add(swimmer);
    }
    public void removeRegularSwimmer(Swimmer regularSwimmer) {
        regularSwimmers.remove(regularSwimmer);
    }
    public void displayRegularSwimmers() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n       NAME                          AGE      EMAIL" +
                "                               ADDRESS                         MEMBER    ARREARS");
        for (int i = 0; i < regularSwimmers.size(); i++) {
            System.out.printf("%s %-4s %s %-28s %s %-3d %s | %s  %-35s %-30s %s %-5s %s | %s %-6s %s %s%n",
                    ConsoleColors.PURPLE_BOLD_BRIGHT, (i + 1) + ".", ConsoleColors.CYAN_BOLD_BRIGHT,
                    regularSwimmers.get(i).getFirstName() + " " +
                            regularSwimmers.get(i).getLastName(), ConsoleColors.YELLOW_BOLD_BRIGHT,
                    (LocalDateTime.now().getYear() - regularSwimmers.get(i).getYearOfBirth()),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.YELLOW_BOLD_BRIGHT,
                    regularSwimmers.get(i).getEmail(),
                    regularSwimmers.get(i).getAddress(),
                    ConsoleColors.CYAN_BOLD_BRIGHT, regularSwimmers.get(i).isActive(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.CYAN_BOLD_BRIGHT,
                    regularSwimmers.get(i).isPaid(), ConsoleColors.PURPLE_BOLD_BRIGHT,
                    "|" + ConsoleColors.RESET);
        }
        System.out.println();
    }
    public void changeActivityStatusRegular() {
        displayRegularSwimmers();
        int chosenMember = ui.chooseMember();
        int statusChoice = ui.chooseStatus();
        boolean validChoice = false;

        do {
            if (statusChoice == 1) {
                regularSwimmers.get(chosenMember).setActive(true);
                validChoice = true;
            } else if (statusChoice == 2) {
                regularSwimmers.get(chosenMember).setActive(false);
                validChoice = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Try again." + ConsoleColors.RESET);
            }
        } while (!validChoice);

    }
    public void chooseRegularSwimmerToRemove() {
        displayRegularSwimmers();
        int memberIndexToRemove = ui.chooseMember();
        if (isValidIndexRegular(memberIndexToRemove, regularSwimmers)) {
        removeMemberFromInt(memberIndexToRemove);

        }
    }
    public void removeMemberFromInt (int memberIndexToRemove) {
        Swimmer regularSwimmerToRemove = regularSwimmers.get(memberIndexToRemove);
        removeRegularSwimmer(regularSwimmerToRemove);
    }

    public int chooseRegularSwimmer() {
        displayRegularSwimmers();
        int chosenMember = ui.chooseMember();
        return chosenMember;
    }

    public ProSwimmer createProSwimmerFromRegular(int chosenMember) {
        ProSwimmer regularToProSwimmer = new ProSwimmer(
                regularSwimmers.get(chosenMember).getFirstName(),
                regularSwimmers.get(chosenMember).getLastName(),
                regularSwimmers.get(chosenMember).getYearOfBirth(),
                regularSwimmers.get(chosenMember).getEmail(),
                regularSwimmers.get(chosenMember).getAddress(),
                regularSwimmers.get(chosenMember).isActive(),
                regularSwimmers.get(chosenMember).isPaid(),
                ui.chooseSwimDisciplin());
        return regularToProSwimmer;
    }
}
