package delfinen.model;
import delfinen.manager.ChairmanProManager;
import delfinen.manager.ChairmanRegularManager;
import delfinen.misc.ConsoleColors;
import delfinen.viewer.UI;

import java.util.Scanner;

public class Chairman {
    private Scanner scanner = new Scanner(System.in);

   private ChairmanRegularManager chairmanRegularManager = new ChairmanRegularManager();
   private ChairmanProManager chairmanProManager = new ChairmanProManager();
   private UI ui = new UI();

    public void addProSwimmer() {
        chairmanProManager.createProMember();
    }

    public void addRegularSwimmer() {
        chairmanRegularManager.createRegularMember();
    }

    public void removeRegularSwimmer(){
        chairmanRegularManager.chooseRegularSwimmerToRemove();
    }

    public void removeProSwimmer () {
        chairmanProManager.chooseProSwimmerToRemove();
    }

    public void displayRegularSwimmer() {
        chairmanRegularManager.displayRegularSwimmers();
    }

    public void displayProSwimmer() {
        chairmanProManager.displayProSwimmers();
    }

    public void changeRegularSwimmerToPro() {
        int chosenMember = chairmanRegularManager.chooseRegularSwimmer();
        chairmanProManager.addProSwimmerToList( chairmanRegularManager.createProSwimmerFromRegular(chosenMember));
        chairmanRegularManager.removeMemberFromInt(chosenMember);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Regular has been changed to pro!" + ConsoleColors.RESET);
    } // TODO SKRIV NAVN DER BLIVER ÆNDRET

    public void changeProSwimmerToRegular() {
        int chosenMember = chairmanProManager.chooseProSwimmer();
        chairmanRegularManager.addRegularSwimmerToList(chairmanProManager.createRegularSwimmerFromPro(chosenMember));
        chairmanProManager.removeMemberFromInt(chosenMember);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Pro swimmer changed to regular!" + ConsoleColors.RESET);
    }// TODO SKRIV NAVN DER BLIVER ÆNDRET

    public void changeActivityStatus() {
        int swimmerType = ui.chooseSwimmerType(); // todo fix så vi ikke kalder UI klasse

        if (swimmerType == 1) {
            chairmanProManager.changeActivityStatusPro();
        } else if (swimmerType == 2) {
            chairmanRegularManager.changeActivityStatusRegular();
        }
    }
}


