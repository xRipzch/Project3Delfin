package delfinen.model;

import delfinen.controller.ChairmanProController;
import delfinen.menu.ExecuteMenu;
import delfinen.viewer.Landing;

import java.util.ArrayList;

public class Delfinen {


    static ExecuteMenu executeMenu = new ExecuteMenu();
    static Landing landing = new Landing();

    public static void main(String[] args) {
        new Delfinen().run();
    }

    private void run() {
        landing.intro1();
        executeMenu.executeMenu();
    }
}
