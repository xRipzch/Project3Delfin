package delfinen.controller;

import delfinen.model.ProSwimmer;

import java.util.ArrayList;

public class CoachController {


    public ArrayList<ProSwimmer> getProSwimmers () {
         ChairmanProController proController = new ChairmanProController();
       return new ArrayList<>(proController.loadFileProSwimmers());
    }
}



