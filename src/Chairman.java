import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);
    UI ui = new UI();
    FileHandling fileHandling;
    Cashier cashier;
    Coach coach;

    public Chairman(FileHandling filehandling, Cashier cashier) {
        this.fileHandling = filehandling;
        this.cashier = cashier;
    }

    public void createProMember() {
        ProSwimmer proswimmer = new ProSwimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAddress(), ui.typeAddress(),
                ui.isActive(), ui.isPaid(), ui.chooseSwimDisciplin());

        fileHandling.getProSwimmers().add(proswimmer);
        ui.memberCreatedConfirmationMessage();
        cashier.createSubscription(proswimmer);
        // coach.addSwimmerToArrayList();
       // coach.sortAllArrayLists();
    }

    public void createRegularMember() {
        Swimmer swimmer = new Swimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAddress(), ui.typeAddress(), ui.isActive(), ui.isPaid());

        fileHandling.getRegularSwimmers().add(swimmer);
        ui.memberCreatedConfirmationMessage();
        cashier.createSubscription(swimmer);

    }


    public void removeProMember(ProSwimmer proSwimmer) {
        fileHandling.getProSwimmers().remove(proSwimmer);
    }


    public ArrayList<ProSwimmer> getProMembers() {
        return new ArrayList<>(fileHandling.getProSwimmers());
    }


    public void chooseProSwimmerToRemove() {
        displayProMember();
        int memberIndexToRemove = ui.chooseMember();

        if (isValidIndexPro(memberIndexToRemove, fileHandling.getProSwimmers())) {
            ProSwimmer proSwimmerToRemove = getProMembers().get(memberIndexToRemove);
            removeProMember(proSwimmerToRemove);
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + proSwimmerToRemove.getFirstName() + " " + proSwimmerToRemove.getLastName() +
                    " has been removed from Delfinen." + ConsoleColors.RESET);
            scanner.nextLine();
        }
    }


    private boolean isValidIndexPro(int index, ArrayList<ProSwimmer> proMembers) {
        return index >= 0 && index < getProMembers().size();
    }


    public void removeRegularMember(Swimmer regularSwimmer) {
        fileHandling.getRegularSwimmers().remove(regularSwimmer);
    }

    public ArrayList<Swimmer> getRegularSwimmers() {
        return new ArrayList<>(fileHandling.getRegularSwimmers());
    }

    public void chooseRegularSwimmerToRemove() {
        displayRegularMember();
        int memberIndexToRemove = ui.chooseMember();
        if (isValidIndexRegular(memberIndexToRemove, fileHandling.getRegularSwimmers())) {

            Swimmer regularSwimmerToRemove = getRegularSwimmers().get(memberIndexToRemove);
            removeRegularMember(regularSwimmerToRemove);
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + regularSwimmerToRemove.getFirstName() + " " +
                    regularSwimmerToRemove.getLastName() + " has been removed from Delfinen." + ConsoleColors.RESET);
            scanner.nextLine();
        }
    }

    private boolean isValidIndexRegular(int index, ArrayList<Swimmer> regularSwimmers) {
        return index >= 0 && index < getRegularSwimmers().size();
    }


    public void displayProMember() {
        printHeaderForMembers();

        for (int i = 0; i < fileHandling.getProSwimmers().size(); i++) {
            String indexColored = ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1) + "." + ConsoleColors.RESET;
            System.out.printf("%s %-28s %s %-3d %s | %s  %-35s %-30s %s %-5s %s  %s %s %-11s%n",
                    indexColored + ConsoleColors.CYAN_BOLD_BRIGHT,
                    fileHandling.getProSwimmers().get(i).getFirstName() + " " + fileHandling.getProSwimmers().get(i).getLastName(),
                    ConsoleColors.YELLOW_BOLD_BRIGHT,
                    (LocalDateTime.now().getYear() - fileHandling.getProSwimmers().get(i).getYearOfBirth()),
                    ConsoleColors.PURPLE_BOLD_BRIGHT,
                    ConsoleColors.YELLOW_BOLD_BRIGHT,
                    fileHandling.getProSwimmers().get(i).getEmail(),
                    fileHandling.getProSwimmers().get(i).getAddress(),
                    ConsoleColors.CYAN_BOLD_BRIGHT,
                    fileHandling.getProSwimmers().get(i).isActive(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT,
                    "|",
                    ConsoleColors.CYAN_BOLD_BRIGHT,
                    fileHandling.getProSwimmers().get(i).isPaid() + ConsoleColors.RESET);
        }
    }

    public void printHeaderForMembers(){
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n   NAME                          AGE      EMAIL" +
                "                               ADDRESS                         MEMBER     ARREARS");
    }

    public void displayRegularMember() {
        printHeaderForMembers();

        for (int i = 0; i < fileHandling.getRegularSwimmers().size(); i++) {
            String indexColored = ConsoleColors.PURPLE_BOLD_BRIGHT + (i + 1) + "." + ConsoleColors.RESET;
            System.out.printf("%s %-28s %s %-3d %s | %s  %-35s %-30s %s %-5s %s  %s %s %-11s%n",
                    indexColored + ConsoleColors.CYAN_BOLD_BRIGHT,
                    fileHandling.getRegularSwimmers().get(i).getFirstName() + " " + fileHandling.getRegularSwimmers().get(i).getLastName(),
                    ConsoleColors.YELLOW_BOLD_BRIGHT,
                    (LocalDateTime.now().getYear() - fileHandling.getRegularSwimmers().get(i).getYearOfBirth()),
                    ConsoleColors.PURPLE_BOLD_BRIGHT,
                    ConsoleColors.YELLOW_BOLD_BRIGHT,
                    fileHandling.getRegularSwimmers().get(i).getEmail(),
                    fileHandling.getRegularSwimmers().get(i).getAddress(),
                    ConsoleColors.CYAN_BOLD_BRIGHT,
                    fileHandling.getRegularSwimmers().get(i).isActive(),
                    ConsoleColors.PURPLE_BOLD_BRIGHT,
                    "|",
                    ConsoleColors.CYAN_BOLD_BRIGHT,
                    fileHandling.getRegularSwimmers().get(i).isPaid() + ConsoleColors.RESET);
        }
    }

    public void changeActivityStatus() {
        int swimmerType = ui.chooseSwimmerType();

        if (swimmerType == 1) {
            changeActivityStatusPro();
        } else if (swimmerType == 2) {
            changeActivityStatusRegular();
        }
    }

    private void changeActivityStatusPro() {
        displayProMember();
        int chosenMember = ui.chooseMember();
        int statusChoice = ui.chooseStatus();
        boolean validChoice = false;

        do {
            if (statusChoice == 1) {
                fileHandling.getProSwimmers().get(chosenMember).setActive(true);
                validChoice = true;
            } else if (statusChoice == 2) {
                fileHandling.getProSwimmers().get(chosenMember).setActive(false);
                validChoice = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Try again." + ConsoleColors.RESET);
            }
        } while (!validChoice);
        scanner.close();
    }


    private void changeActivityStatusRegular() {
        displayRegularMember();
        int chosenMember = ui.chooseMember();
        int statusChoice = ui.chooseStatus();
        boolean validChoice = false;

        do {
            if (statusChoice == 1) {
                fileHandling.getRegularSwimmers().get(chosenMember).setActive(true);
                validChoice = true;
            } else if (statusChoice == 2) {
                fileHandling.getRegularSwimmers().get(chosenMember).setActive(false);
                validChoice = true;
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Try again." + ConsoleColors.RESET);
            }
        } while (!validChoice);
        scanner.close();
    }


    public void changeRegularSwimmerToPro() {
        displayRegularMember();
        int chosenMember = ui.chooseMember();
        ProSwimmer regularToProSwimmer = new ProSwimmer(
                fileHandling.getRegularSwimmers().get(chosenMember).getFirstName(),
                fileHandling.getRegularSwimmers().get(chosenMember).getLastName(),
                fileHandling.getRegularSwimmers().get(chosenMember).getYearOfBirth(),
                fileHandling.getRegularSwimmers().get(chosenMember).getEmail(),
                fileHandling.getRegularSwimmers().get(chosenMember).getAddress(),
                fileHandling.getRegularSwimmers().get(chosenMember).isActive(),
                fileHandling.getRegularSwimmers().get(chosenMember).isPaid(),
                ui.chooseSwimDisciplin());

        fileHandling.getProSwimmers().add(regularToProSwimmer);
        removeRegularMember(fileHandling.getRegularSwimmers().get(chosenMember));
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Regular swimmer changed to pro!" + ConsoleColors.RESET);
    }

    public void changeProSwimmerToRegular() {
        displayProMember();
        int chosenMember = ui.chooseMember();
        Swimmer proToRegularSwimmer = new Swimmer(
                fileHandling.getProSwimmers().get(chosenMember).getFirstName(),
                fileHandling.getProSwimmers().get(chosenMember).getLastName(),
                fileHandling.getProSwimmers().get(chosenMember).getYearOfBirth(),
                fileHandling.getProSwimmers().get(chosenMember).getEmail(),
                fileHandling.getProSwimmers().get(chosenMember).getAddress(),
                fileHandling.getProSwimmers().get(chosenMember).isActive(),
                fileHandling.getProSwimmers().get(chosenMember).isPaid());

        fileHandling.getRegularSwimmers().add(proToRegularSwimmer);
        removeProMember(fileHandling.getProSwimmers().get(chosenMember));
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Pro swimmer changed to regular!" + ConsoleColors.RESET);
    }


    public void sortByAge() { //Ikke sikkert den her metode skal bruges.
        ArrayList<Swimmer> juniorSwimmers = new ArrayList<>();
        ArrayList<Swimmer> seniorSwimmers = new ArrayList<>();
        ArrayList<Swimmer> membersAbove60 = new ArrayList<>();
        if (!fileHandling.getProSwimmers().isEmpty()) {
            for (ProSwimmer proSwimmer : fileHandling.getProSwimmers()) {
                if (proSwimmer.getYearOfBirth() < 18) {
                    juniorSwimmers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 18 && proSwimmer.getYearOfBirth() < 60) {
                    seniorSwimmers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 60) {
                    membersAbove60.add(proSwimmer);
                }
            }
            if (!fileHandling.getRegularSwimmers().isEmpty()) {
                for (Swimmer Swimmer : fileHandling.getRegularSwimmers()) {
                    if (Swimmer.getYearOfBirth() < 18) {
                        juniorSwimmers.add(Swimmer);
                    } else if (Swimmer.getYearOfBirth() >= 18 && Swimmer.getYearOfBirth() < 60) {
                        seniorSwimmers.add(Swimmer);
                    } else if (Swimmer.getYearOfBirth() >= 60) {
                        membersAbove60.add(Swimmer);
                    }
                }
            }
        }
    }
}


