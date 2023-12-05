package delfinen.model;

import delfinen.misc.ConsoleColors;
import delfinen.misc.SwimDiscipline;

import java.util.HashMap;
import java.util.Map;

public class ProSwimmer extends Swimmer {
    private SwimDiscipline swimDisciplin;
    private double quickestTime; // Sikre invarians
    private Map<SwimDiscipline, Double> trainingResults;
    Coach coach;


    public ProSwimmer(String firstName, String lastName, int yearOfBirth, String email,
                      String address, boolean isActive, boolean isPaid,
                      SwimDiscipline swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, address, isActive, isPaid);
        this.swimDisciplin = swimDisciplin;
        this.trainingResults = new HashMap<>();
        if(swimDisciplin == SwimDiscipline.CRAWL)
            this.coach= new Coach("Casper");
        else if (swimDisciplin == SwimDiscipline.BREASTSTROKE)
            this.coach = new Coach("Brian");
        else if (swimDisciplin == SwimDiscipline.MEDLEY)
            this.coach = new Coach("Magnus");
        else if (swimDisciplin == SwimDiscipline.BUTTERFLY)
            this.coach = new Coach("Bunny");
        else if (swimDisciplin == SwimDiscipline.BACKSTROKE)
            this.coach = new Coach("Baggy");

    }

    public String getCoachName() {
        return coach.getName();
    }

    public SwimDiscipline getSwimDisciplin() {
        return swimDisciplin;
    }

    public void setSwimDisciplin(SwimDiscipline swimDisciplin) {
        this.swimDisciplin = swimDisciplin;
    }

    public void setQuickestTime(double quickestTime) {
        if (quickestTime > 0) {
            this.quickestTime = quickestTime;
        } else System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid value.");
    }

    public Map<SwimDiscipline, Double> getTrainingResults() {
        return trainingResults;
    }

    public double getQuickestTime(String swimDiscipline) {
        return quickestTime;
    }

    public void addTrainingResult(SwimDiscipline swimDiscipline, double result) {
        if (!trainingResults.containsKey(swimDiscipline) || result > trainingResults.get(swimDiscipline))
            trainingResults.put(swimDiscipline, result);
    }
}
