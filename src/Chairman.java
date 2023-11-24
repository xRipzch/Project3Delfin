import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Member> allMembers = new ArrayList<>();
    private ArrayList<ProSwimmer> proSwimmers = new ArrayList<>();
    private ArrayList<RegularSwimmer> regularSwimmers = new ArrayList<>();
    UI ui = new UI();
    FileHandling fileHandling = new FileHandling();
    Subscription subscription = new Subscription();


    public void createMember() {
        Member member = new Member(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAdress(), ui.typeAdress(),
                ui.isActive(), ui.hasPaid());

        if (member.getHasPaid()) {
            subscription.calculateSubscriptionPrice(member);
            ui.printConfirmationForPayment();
        }
         addMembertoList(member);
    }


    public void createProMember() {
        ProSwimmer proswimmer = new ProSwimmer(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAdress(), ui.typeAdress(),
                ui.isActive(), ui.hasPaid(), ui.chooseSwimDisciplin());

        if (proswimmer.getHasPaid()) {
            subscription.calculateSubscriptionPrice(proswimmer);
            ui.printConfirmationForPayment();
        }
        addMembertoList(proswimmer);
    }


    public void addMembertoList(Member member) {
        allMembers.add(member);
        fileHandling.writeAllMembersToFile(allMembers);
    }



    public void removeMember(Member member) {
        allMembers.remove(member);
        FileHandling fileHandling = new FileHandling();
        fileHandling.writeAllMembersToFile(allMembers);
    }


    public ArrayList<Member> getAllMembers() {
        return new ArrayList<Member>(allMembers);
    }

    public void displayMemberList() {
        for (int i = 0; i < getAllMembers().size(); i++) {
            System.out.println(i + ". " + getAllMembers().get(i).getFirstName() + " " +
                    getAllMembers().get(i).getLastName());
        }
    }


    public void removeMemberFromDelfinen() {
        UI ui = new UI();
        System.out.println("Choose member to remove from Delfinen.");
        displayMemberList();
        int memberIndexToRemove = ui.getUserInputInt();
        if (isValidIndex(memberIndexToRemove, allMembers)) {
            Member memberToRemove = getAllMembers().get(memberIndexToRemove);
            removeMember(memberToRemove);
            System.out.println(memberToRemove.getFirstName() + " " + memberToRemove.getLastName() +
                    " has been removed from Delfinen.");
            scanner.nextLine();

        }
    }

    private boolean isValidIndex(int index, ArrayList<Member> allMembers) {
        return index >= 0 && index < getAllMembers().size();
    }

    public void sortByAge() {
        ArrayList<Member> juniorMembers = new ArrayList<>();
        ArrayList<Member> seniorMembers = new ArrayList<>();
        ArrayList<Member> membersAbove60 = new ArrayList<>();
        Member member = new Member(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAdress(), ui.typeAdress(), ui.isActive(), ui.hasPaid());
        int i = 0;
        //for (i = 0; i < allMembers.size(); i++) ;
        if (allMembers.get(i).getYearOfBirth() < 18) {
            System.out.println("Junior");
            juniorMembers.add(member);
        } else if (allMembers.get(i).getYearOfBirth() >= 18 && allMembers.get(i).getYearOfBirth() < 60) {
            System.out.println("Senior");
            seniorMembers.add(member);
        } else if (allMembers.get(i).getYearOfBirth() >= 60) {
            System.out.println("Above 60");
            membersAbove60.add(member);
        }
    }
}




