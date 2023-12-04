package delfinen;

import delfinen.filehandling.FHProSwimmer;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChairmanProController {
    UI ui = new UI();

    Scanner scanner = new Scanner(System.in);

    private CashierController cashierController = new CashierController();
    private FHProSwimmer fhProSwimmer = new FHProSwimmer();
    private ArrayList<ProSwimmer> proSwimmers = fhProSwimmer.loadFileProSwimmers();

    private boolean isValidIndexPro(int index, ArrayList<ProSwimmer> proMembers) {
        return index >= 0 && index < proSwimmers.size();
    }


    public void createProMember() {
        ProSwimmer proSwimmer = new ProSwimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAddress(), ui.typeAddress(),
                ui.isActive(), ui.isPaid(), ui.chooseSwimDisciplin());

        addProSwimmerToList(proSwimmer);
        System.out.print(ConsoleColors.CYAN_BOLD_BRIGHT + proSwimmer.getFirstName() + ConsoleColors.RESET);
        ui.memberCreatedConfirmationMessage();
        cashierController.createSubscription(proSwimmer);
        fhProSwimmer.saveInProSwimmersFile(proSwimmers);
    }

    public void addProSwimmerToList(ProSwimmer proSwimmer){
    proSwimmers.add(proSwimmer);
    }


    public void loadFileProSwimmers() {
        fhProSwimmer.loadFileProSwimmers();
    }


    public void removeProMember(ProSwimmer proSwimmer) {
        proSwimmers.remove(proSwimmer);
    }


    public void displayProSwimmers() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n       NAME                          AGE      EMAIL" +
                "                               ADDRESS                         DISCIPLINE           MEMBER    ARREARS");
        for (int i = 0; i < proSwimmers.size(); i++) {
            System.out.printf("%s %-4s %s %-28s %s %-3d %s | %s  %-35s %-30s %s %-20s %-5s %s | %s %-6s %s %s%n",
                    ConsoleColors.PURPLE_BOLD_BRIGHT, (i + 1) + ".", ConsoleColors.CYAN_BOLD_BRIGHT,
                    proSwimmers.get(i).getFirstName() + " " +
                            proSwimmers.get(i).getLastName(), ConsoleColors.YELLOW_BOLD_BRIGHT,
                    (LocalDateTime.now().getYear() - proSwimmers.get(i).getYearOfBirth()),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, ConsoleColors.YELLOW_BOLD_BRIGHT,
                    proSwimmers.get(i).getEmail(), proSwimmers.get(i).getAddress(),
                    ConsoleColors.CYAN_BOLD_BRIGHT, proSwimmers.get(i).getSwimDisciplin(),
                    proSwimmers.get(i).isActive(), ConsoleColors.PURPLE_BOLD_BRIGHT,
                    ConsoleColors.CYAN_BOLD_BRIGHT, proSwimmers.get(i).isPaid(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT, "|" + ConsoleColors.RESET);
        }
        System.out.println();
    }


    public void chooseProSwimmerToRemove() {
        displayProSwimmers();
        int memberIndexToRemove = ui.chooseMember();

        if (isValidIndexPro(memberIndexToRemove, proSwimmers)) {
            removeMemberFromInt(memberIndexToRemove);
        }
    }

    public void removeMemberFromInt(int memberIndexToRemove){
        ProSwimmer proSwimmerToRemove = proSwimmers.get(memberIndexToRemove);
        removeProMember(proSwimmerToRemove);
    }


    public int chooseProSwimmer(){
        displayProSwimmers();
        int chosenMember = ui.chooseMember();
        return chosenMember;
    }


    public void changeActivityStatusPro() {
        displayProSwimmers();
        int chosenMember = ui.chooseMember();
        int statusChoice = ui.chooseStatus();
        boolean validChoice = false;

        do {
            if (statusChoice == 1) {
                proSwimmers.get(chosenMember).setActive(true);
                validChoice = true;
            } else if (statusChoice == 2) {
                proSwimmers.get(chosenMember).setActive(false);
                validChoice = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Try again." + ConsoleColors.RESET);
            }
        } while (!validChoice);
        scanner.close();
    }


    public Swimmer createRegularSwimmerFromPro(int chosenMember){
        Swimmer proToRegularSwimmer = new Swimmer(
                proSwimmers.get(chosenMember).getFirstName(),
                proSwimmers.get(chosenMember).getLastName(),
                proSwimmers.get(chosenMember).getYearOfBirth(),
                proSwimmers.get(chosenMember).getEmail(),
                proSwimmers.get(chosenMember).getAddress(),
                proSwimmers.get(chosenMember).isActive(),
                proSwimmers.get(chosenMember).isPaid());

        return proToRegularSwimmer;
    }



}
