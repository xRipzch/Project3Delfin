package delfinen.model;


import delfinen.menu.MainMenu;
import delfinen.viewer.Landing;



public class Delfinen {


    static MainMenu mainMenu = new MainMenu();
    static Landing landing = new Landing();

    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
        landing.intro1();
        mainMenu.executeMainMenu(-1);
    }
}
