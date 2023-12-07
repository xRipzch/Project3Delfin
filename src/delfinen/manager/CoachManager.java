package delfinen.manager;

import delfinen.filehandling.FHProSwimmer;
import delfinen.misc.SwimDiscipline;
import delfinen.model.Coach;
import delfinen.model.ProSwimmer;

import java.util.ArrayList;

public class CoachManager {

    FHProSwimmer fhProSwimmer = new FHProSwimmer();
    ArrayList<ProSwimmer> proSwimmers = fhProSwimmer.loadFileProSwimmers();


    Coach coachBackstroke = new Coach("Baggy", createBackstrokeArray());
    Coach coachBreaststroke = new Coach("Brian", createBreaststrokeArray());
    Coach coachButterfly = new Coach("Bunny", createButterflyArray());
    Coach coachCrawl = new Coach("Casper", createCrawlArray());
    Coach coachMedley = new Coach("Magnus", createMedleyArray());
    ArrayList <Coach> coaches = new ArrayList<>();


    public void addCoachesToArray(){
        coaches.add(coachBackstroke);
        coaches.add(coachBreaststroke);
        coaches.add(coachButterfly);
        coaches.add(coachCrawl);
        coaches.add(coachMedley);
    }


    public ArrayList<ProSwimmer> createBackstrokeArray() {
        ArrayList<ProSwimmer> backStrokeSwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.BACKSTROKE) {
                backStrokeSwimmers.add(proSwimmers.get(i));
            }
        }
        return backStrokeSwimmers;
    }

    public ArrayList<ProSwimmer> createBreaststrokeArray() {
        ArrayList<ProSwimmer> breastStrokeSwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.BREASTSTROKE) {
                {
                    breastStrokeSwimmers.add(proSwimmers.get(i));
                }
            }
        }
        return breastStrokeSwimmers;
    }

    public ArrayList<ProSwimmer> createButterflyArray() {
        ArrayList<ProSwimmer> butterflySwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.BUTTERFLY) {
                butterflySwimmers.add(proSwimmers.get(i));
            }
        }
        return butterflySwimmers;

    }

    public ArrayList<ProSwimmer> createCrawlArray() {
        ArrayList<ProSwimmer> crawlSwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.CRAWL) {
                crawlSwimmers.add(proSwimmers.get(i));
            }
        }
        return crawlSwimmers;
    }

    public ArrayList<ProSwimmer> createMedleyArray() {
        ArrayList<ProSwimmer> medleySwimmers = new ArrayList<>();
        for (int i = 0; i < proSwimmers.size(); i++) {
            if (proSwimmers.get(i).getSwimDisciplin() == SwimDiscipline.MEDLEY) {
                medleySwimmers.add(proSwimmers.get(i));
            }
        }
        return medleySwimmers;
    }


    public ArrayList<Coach> getCoaches(){
        addCoachesToArray();
        return coaches;
    }

}

