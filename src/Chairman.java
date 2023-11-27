import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<ProSwimmer> proSwimmers = new ArrayList<ProSwimmer>();
    private ArrayList<Member> regularSwimmers = new ArrayList<Member>();
    UI ui = new UI();
    FileHandling fileHandling = new FileHandling();
    Subscription subscription = new Subscription();
        public Chairman() {
            this.fileHandling = new FileHandling();
        }
        public void initRegularMember () {
            regularSwimmers = fileHandling.loadRegularMembersFromFile();
        }

        public void initProMember () {
            proSwimmers = fileHandling.loadProMembersFromFile();
        }


    public void createProMember() {
            initProMember();
        ProSwimmer proswimmer = new ProSwimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAdress(), ui.typeAdress(),
                ui.isActive(), ui.hasPaid(), ui.chooseSwimDisciplin());
        proSwimmers.add(proswimmer);
        ui.ConfirmationMessage();
        fileHandling.writeToProSwimmersFile(proSwimmers);
        sortByAge();
        if (proswimmer.getHasPaid()) {
            subscription.calculateSubscriptionPrice(proswimmer);
            ui.printConfirmationForPayment();
        } // todo make sure filewriting works

    }



    public void removeProMember(ProSwimmer proSwimmer) {
        proSwimmers.remove(proSwimmer);
        //todo update file after removing
    }


    public ArrayList<ProSwimmer> getProMembers() {
        return new ArrayList<>(proSwimmers);
    }


    public void removeProMemberFromDelfinen() {
           initProMember();
        UI ui = new UI();
        System.out.println("Choose member to remove from Delfinen.");
        //todo make a display promember and call it here
        int memberIndexToRemove = ui.getUserInputInt();
        if (isValidIndexPro(memberIndexToRemove, proSwimmers)) {

            ProSwimmer proSwimmerToRemove = getProMembers().get(memberIndexToRemove);
            removeProMember(proSwimmerToRemove);
            System.out.println(proSwimmerToRemove.getFirstName() + " " + proSwimmerToRemove.getLastName() +
                    " has been removed from Delfinen.");
            scanner.nextLine();

        }
    }


    private boolean isValidIndexPro(int index, ArrayList<ProSwimmer> proMembers) {
        return index >= 0 && index < getProMembers().size();
    }

    public void createRegularMember() {
            initRegularMember();
        Member Member = new Member(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAdress(), ui.typeAdress(), ui.isActive(), ui.hasPaid());
        regularSwimmers.add(Member);
        ui.ConfirmationMessage();
        sortByAge();
        fileHandling.writeToRegularSwimmersFile(regularSwimmers);
        if (Member.getHasPaid()) {
            subscription.calculateSubscriptionPrice(Member);
            ui.printConfirmationForPayment();
        } // todo make sure filewriting works

    }
    public void removeRegularMember(Member regularMember) {
        regularSwimmers.remove(regularMember);
        //todo update file after removing
    }
    public ArrayList<Member> getRegularSwimmers() {
        return new ArrayList<>(regularSwimmers);
    }
    public void removeRegularMemberFromDelfinen() {
            initRegularMember();
        UI ui = new UI();
        System.out.println("Choose member to remove from Delfinen.");
        //todo make a display promember and call it here
        int memberIndexToRemove = ui.getUserInputInt();
        if (isValidIndexRegular(memberIndexToRemove, regularSwimmers)) {

          Member regularMemberToRemove = getRegularSwimmers().get(memberIndexToRemove);
            removeRegularMember(regularMemberToRemove);
            System.out.println(regularMemberToRemove.getFirstName() + " " + regularMemberToRemove.getLastName() +
                    " has been removed from Delfinen.");
            scanner.nextLine();
        }
    }
    private boolean isValidIndexRegular(int index, ArrayList<Member> regularSwimmers) {
        return index >= 0 && index < getRegularSwimmers().size();
    }


    public void displayProMember () {
        initProMember();
        for (int i = 0; i < proSwimmers.size(); i++) {
            System.out.println((i+1) + ". " +
                    "Name: " + proSwimmers.get(i).getFirstName() + " " + proSwimmers.get(i).getLastName() +
                    " Age: " + (LocalDateTime.now().getYear() - proSwimmers.get(i).getYearOfBirth()) +
                    " Email: " + proSwimmers.get(i).getEmail() +
                    " Adress: " + proSwimmers.get(i).getAdress() +
                    " Is active: " + proSwimmers.get(i).isActive() +
                    " Has paid: " + proSwimmers.get(i).getHasPaid());
            //skal displaye diciplin

        }

    }
    public void displayRegularMember () {
        initRegularMember();
        for (int i = 0; i < regularSwimmers.size(); i++) {
            System.out.println(((i+1) + ". " +
                    "Name: " + regularSwimmers.get(i).getFirstName() + "," + regularSwimmers.get(i).getLastName() +
                    "Age: " + (LocalDateTime.now().getYear() - regularSwimmers.get(i).getYearOfBirth() +
                    "Email: " + regularSwimmers.get(i).getEmail() +
                    "Adress: " + regularSwimmers.get(i).getAdress() +
                    "Is active:" + regularSwimmers.get(i).isActive() +
                    "Has paid: " + (regularSwimmers.get(i).getHasPaid()))));
        }
    }
    public void changeActivityStatus() {
       int choice = ui.chooseSwimmerType();

        if (choice == 1) {
            displayProMember();
        } else if (choice == 2) {
           displayRegularMember();
        }

        System.out.println("Choose the member you want to change:");
        int choice1 = scanner.nextInt();
        int chosenMember = scanner.nextInt(choice1 - 1);

        if (choice == 1) {

        }
        }

/*
    private void changeActivityStatusPro() {
            boolean validChoice= false;

    do {
    System.out.println("Change the status to:");
    System.out.println("1. Active.");
    System.out.println("2. Passive.");
    int choice2 = scanner.nextInt();

    if (choice2 == 1) {
        proSwimmers.get(chosenMember).setActive(true);
        validChoice = true;
    } else if (choice2 == 2) {
        proSwimmers.get(chosenMember).setActive(false);
        validChoice = true;
    } else {
        System.out.println("Invalid input. Try again.");
    }
}while(!validChoice);
        scanner.close();
    }

*/

    public void changeRegularSwimmerToPro() {
        //Skal først soute arraylisten
        //Så lade brugeren vælge medlem
        //Så spørge om hvilken diciplin der ønskes
        //Der skal laves et nyt proswimmer objekt
        //Det skal tilføjes til proswimmer arraylisten
        //Den originale regularswimmer skal slettes
    }

    public void changeProSwimmerToRegular() {
        //Skal først soute arraylisten
        //Så lade brugeren vælge medlem
        //Der skal laves et nyt regularswimmer objekt
        //Det skal tilføjes til regularswimmer arraylisten
        //Den originale proswimmer skal slettes
    }




    public void sortByAge() { 
        ArrayList<Member> juniorMembers = new ArrayList<>();
        ArrayList<Member> seniorMembers = new ArrayList<>();
        ArrayList<Member> membersAbove60 = new ArrayList<>();
        if (!proSwimmers.isEmpty()) {
            for (ProSwimmer proSwimmer : proSwimmers) {
                if (proSwimmer.getYearOfBirth() < 18) {
                    juniorMembers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 18 && proSwimmer.getYearOfBirth() < 60) {
                    seniorMembers.add(proSwimmer);
                } else if (proSwimmer.getYearOfBirth() >= 60) {
                    membersAbove60.add(proSwimmer);
                }
            }
            if (!regularSwimmers.isEmpty()) {
                for (Member Member : regularSwimmers) {
                    if (Member.getYearOfBirth() < 18) {
                        juniorMembers.add(Member);
                    } else if (Member.getYearOfBirth() >= 18 && Member.getYearOfBirth() < 60) {
                        seniorMembers.add(Member);
                    } else if (Member.getYearOfBirth() >= 60) {
                        membersAbove60.add(Member);
                    }
                }
            }
        }
    }
}


