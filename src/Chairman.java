import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Member> allMembers = new ArrayList<>();
    private ArrayList<ProSwimmer> proSwimmers = new ArrayList<>();
    private ArrayList<RegularSwimmer> regularSwimmers = new ArrayList<>();
    UI ui = new UI();


    public void addMemberToDelfinen() {
        Member member = new Member(ui.typeFirstName(), ui.typeLastName(),
                ui.typeYearOfBirth(), ui.typeEmailAdress(), ui.typeAdress(), ui.isActive(), ui.hasPaid());
        ui.printConfirmationForPayment(member);
        allMembers.add(member);
        FileHandling fileHandling = new FileHandling();
        fileHandling.writeAllMembersToFile(allMembers);

        //tilføj member til arraylist
    }
    public void removeMember(Member member) {
        allMembers.remove(member);
        FileHandling fileHandling = new FileHandling();
        fileHandling.writeAllMembersToFile(allMembers);
    }


    public ArrayList<Member> getAllMembers() {
        return new ArrayList<Member>(allMembers);
    }


}


