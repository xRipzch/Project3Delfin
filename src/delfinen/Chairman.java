package delfinen;
import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);

   private ChairmanRegularController chairmanRegularController = new ChairmanRegularController();
   private ChairmanProController chairmanProController = new ChairmanProController();
   private UI ui = new UI();

    public void addProSwimmer() {
        chairmanProController.createProMember();
    }

    public void addRegularSwimmer() {
        chairmanRegularController.createRegularMember();
    }

    public void removeRegularSwimmer(){
        chairmanRegularController.chooseRegularSwimmerToRemove();
    }

    public void removeProSwimmer () {
        chairmanProController.chooseProSwimmerToRemove();
    }
    public void loadFileProSwimmers() {
        chairmanProController.loadFileProSwimmers();
    }


    public void displayRegularSwimmer() {
        chairmanRegularController.displayRegularSwimmers();
    }

    public void displayProSwimmer() {
        chairmanProController.displayProSwimmers();
    }

    public void changeRegularSwimmerToPro() {
        int chosenMember = chairmanRegularController.chooseRegularSwimmer();
        chairmanProController.addProSwimmerToList( chairmanRegularController.createProSwimmerFromRegular(chosenMember));
        chairmanRegularController.removeMemberFromInt(chosenMember);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Regular has been changed to pro!" + ConsoleColors.RESET);
    } // TODO SKRIV NAVN DER BLIVER ÆNDRET

    public void changeProSwimmerToRegular() {
        int chosenMember = chairmanProController.chooseProSwimmer();
        chairmanRegularController.addRegularSwimmerToList(chairmanProController.createRegularSwimmerFromPro(chosenMember));
        chairmanProController.removeMemberFromInt(chosenMember);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Pro swimmer changed to regular!" + ConsoleColors.RESET);
    }// TODO SKRIV NAVN DER BLIVER ÆNDRET

    public void changeActivityStatus() {
        int swimmerType = ui.chooseSwimmerType(); // todo fix så vi ikke kalder UI klasse

        if (swimmerType == 1) {
            chairmanProController.changeActivityStatusPro();
        } else if (swimmerType == 2) {
            chairmanRegularController.changeActivityStatusRegular();
        }
    }
}


