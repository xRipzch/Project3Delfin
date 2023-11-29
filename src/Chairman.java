import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<ProSwimmer> proSwimmers;
    private ArrayList<Swimmer> regularSwimmers;
    UI ui = new UI();
    FileHandling fileHandling;
    Cashier cashier;
    Coach coach;

    public Chairman(FileHandling filehandling, Cashier cashier, ArrayList<ProSwimmer> proSwimmers, ArrayList<Swimmer> regularSwimmers) {
            this.fileHandling = filehandling;
            this.cashier = cashier;
            this.proSwimmers = proSwimmers;
            this.regularSwimmers = regularSwimmers;
        }
    public void initRegularMember () {regularSwimmers = fileHandling.loadRegularMembersFromFile();}
    public void initProMember() {
            proSwimmers = fileHandling.loadProMembersFromFile();
        }


    public void createProMember() {
        ProSwimmer proswimmer = new ProSwimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAddress(), ui.typeAddress(),
                ui.isActive(), ui.isPaid(), ui.chooseSwimDisciplin());

        proSwimmers.add(proswimmer);
        ui.memberCreatedConfirmationMessage();
        cashier.createSubscription(proswimmer);
        coach.addSwimmerToArrayList();
        coach.sortAllArrayLists();
    }

    public void createRegularMember() {
        Swimmer swimmer = new Swimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAddress(), ui.typeAddress(), ui.isActive(), ui.isPaid());

        regularSwimmers.add(swimmer);
        ui.memberCreatedConfirmationMessage();
        cashier.createSubscription(swimmer);

    }


    public void removeProMember(ProSwimmer proSwimmer) {
        proSwimmers.remove(proSwimmer);
    }


    public ArrayList<ProSwimmer> getProMembers() {
        return new ArrayList<>(proSwimmers);
    }


    public void chooseProSwimmerToRemove() {
        displayProMember();
        int memberIndexToRemove = ui.chooseMember();

        if (isValidIndexPro(memberIndexToRemove, proSwimmers)) {
            ProSwimmer proSwimmerToRemove = getProMembers().get(memberIndexToRemove);
            removeProMember(proSwimmerToRemove);
            System.out.println(ConsoleColors.RED_BOLD + proSwimmerToRemove.getFirstName() + " " + proSwimmerToRemove.getLastName() +
                    " has been removed from Delfinen." + ConsoleColors.RESET);
            scanner.nextLine();
        }
    }


    private boolean isValidIndexPro(int index, ArrayList<ProSwimmer> proMembers) {
        return index >= 0 && index < getProMembers().size();
    }


    public void removeRegularMember(Swimmer regularSwimmer) {
        regularSwimmers.remove(regularSwimmer);
    }
    public ArrayList<Swimmer> getRegularSwimmers() {
        return new ArrayList<>(regularSwimmers);
    }

    public void chooseRegularSwimmerToRemove() {
        displayRegularMember();
        int memberIndexToRemove = ui.chooseMember();
        if (isValidIndexRegular(memberIndexToRemove, regularSwimmers)) {

          Swimmer regularSwimmerToRemove = getRegularSwimmers().get(memberIndexToRemove);
            removeRegularMember(regularSwimmerToRemove);
            System.out.println(regularSwimmerToRemove.getFirstName() + " " + regularSwimmerToRemove.getLastName() +
                    " has been removed from Delfinen.");
            scanner.nextLine();
        }
    }
    private boolean isValidIndexRegular(int index, ArrayList<Swimmer> regularSwimmers) {
        return index >= 0 && index < getRegularSwimmers().size();
    }


    public void displayProMember () {
        for (int i = 0; i < proSwimmers.size(); i++) {
            System.out.println((i+1) + ". " +
                    "Name: " + proSwimmers.get(i).getFirstName() + " " + proSwimmers.get(i).getLastName() +
                    " Age: " + (LocalDateTime.now().getYear() - proSwimmers.get(i).getYearOfBirth()) +
                    " Email: " + proSwimmers.get(i).getEmail() +
                    " Address: " + proSwimmers.get(i).getAddress() +
                    " Is active: " + proSwimmers.get(i).isActive() +
                    " Has paid: " + proSwimmers.get(i).isPaid() +
                    " Disciplin: " + proSwimmers.get(i).getSwimDisciplin());


        }

    }
    public void displayRegularMember () {
        for (int i = 0; i < regularSwimmers.size(); i++) {
            System.out.println(((i+1) + ". " +
                    "Name: " + regularSwimmers.get(i).getFirstName() + "," + regularSwimmers.get(i).getLastName() +
                    "Age: " + (LocalDateTime.now().getYear() - regularSwimmers.get(i).getYearOfBirth() +
                    "Email: " + regularSwimmers.get(i).getEmail() +
                    "Address: " + regularSwimmers.get(i).getAddress() +
                    "Is active:" + regularSwimmers.get(i).isActive() +
                    "Has paid: " + regularSwimmers.get(i).isPaid())));
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
        int statusChoice =ui.chooseStatus();
        boolean validChoice= false;

        do {
            if (statusChoice == 1) {
                proSwimmers.get(chosenMember).setActive(true);
                validChoice = true;
            } else if (statusChoice == 2) {
                proSwimmers.get(chosenMember).setActive(false);
                validChoice = true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }while(!validChoice);
        scanner.close();
    }



    private void changeActivityStatusRegular() {
        displayRegularMember();
        int chosenMember = ui.chooseMember();
        int statusChoice =ui.chooseStatus();
        boolean validChoice= false;

        do {
            if (statusChoice == 1) {
                regularSwimmers.get(chosenMember).setActive(true);
                validChoice = true;
            } else if (statusChoice == 2) {
                regularSwimmers.get(chosenMember).setActive(false);
                validChoice = true;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }while(!validChoice);
        scanner.close();
    }


    public void changeRegularSwimmerToPro() {
        displayRegularMember();
        int chosenMember = ui.chooseMember();
        ProSwimmer regularToProSwimmer = new ProSwimmer(
                regularSwimmers.get(chosenMember).getFirstName(),
                regularSwimmers.get(chosenMember).getLastName(),
                regularSwimmers.get(chosenMember).getYearOfBirth(),
                regularSwimmers.get(chosenMember).getEmail(),
                regularSwimmers.get(chosenMember).getAddress(),
                regularSwimmers.get(chosenMember).isActive(),
                regularSwimmers.get(chosenMember).isPaid(),
                ui.chooseSwimDisciplin());

        proSwimmers.add(regularToProSwimmer);
        removeRegularMember(regularSwimmers.get(chosenMember));
        System.out.println("Regular swimmer changed to pro!");
    }

    public void changeProSwimmerToRegular() {
        displayProMember();
        int chosenMember = ui.chooseMember();
        Swimmer proToRegularSwimmer = new Swimmer(
                proSwimmers.get(chosenMember).getFirstName(),
                proSwimmers.get(chosenMember).getLastName(),
                proSwimmers.get(chosenMember).getYearOfBirth(),
                proSwimmers.get(chosenMember).getEmail(),
                proSwimmers.get(chosenMember).getAddress(),
                proSwimmers.get(chosenMember).isActive(),
                proSwimmers.get(chosenMember).isPaid());

        regularSwimmers.add(proToRegularSwimmer);
        removeProMember(proSwimmers.get(chosenMember));
        System.out.println("Pro swimmer changed to regular!");
    }




    public void sortByAge() { //Ikke sikkert den her metode skal bruges.
        ArrayList<Swimmer> juniorSwimmers = new ArrayList<>();
        ArrayList<Swimmer> seniorSwimmers = new ArrayList<>();
        ArrayList<Swimmer> membersAbove60 = new ArrayList<>();
        if (!proSwimmers.isEmpty()) {
            for (ProSwimmer proSwimmer : proSwimmers) {
                if (proSwimmer.getYearOfBirth() < 18) {
                    juniorSwimmers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 18 && proSwimmer.getYearOfBirth() < 60) {
                    seniorSwimmers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 60) {
                    membersAbove60.add(proSwimmer);
                }
            }
            if (!regularSwimmers.isEmpty()) {
                for (Swimmer Swimmer : regularSwimmers) {
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


