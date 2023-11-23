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
        ui.printConfirmationForPayment(Member member);

        //tilføj member til arraylist
    }


    public ArrayList<Member> getAllMembers() {
        return new ArrayList<Member>(allMembers);
    }


}


