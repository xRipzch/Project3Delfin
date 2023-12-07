package delfinen.model;

import delfinen.misc.SwimDiscipline;

import java.time.LocalDate;
import java.util.Comparator;


public class ResultCompetition implements Comparator {
    private double trainingResult;
    private LocalDate date;
    private SwimDiscipline swimDiscipline;
    private String competetionName;
    private int placement;

    ProSwimmer proSwimmer = new ProSwimmer("first", "last", 1994, " email", "address", true, true, SwimDiscipline.BACKSTROKE);


    public ResultCompetition(double trainingResult, LocalDate date, SwimDiscipline swimDiscipline, String competitionName, int palcement ){
        this.trainingResult = trainingResult;
        this.date = date;
        this.swimDiscipline = swimDiscipline;
        this.competetionName = competitionName;
        this.placement = palcement;
    }

    public double getTrainingResult() {
        return trainingResult;
    }

    public SwimDiscipline getSwimDiscipline() {
        return swimDiscipline;
    }

    public void setTrainingResult(double trainingResult) {
        this.trainingResult = trainingResult;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCompetetionName() {
        return competetionName;
    }

    public int getPlacement() {
        return placement;
    }

    public String getName(){
        return proSwimmer.getFirstName() + " " + proSwimmer.getLastName();
    }

    @Override
    public String toString() {
        return "Name: "  + getName() +
                "\nResult: " + trainingResult +
                "\n Date: " + date +
                "\n SwimDiscipline: " + swimDiscipline +
                "\n Competition: " + competetionName +
                "\n Placement: " + placement;
    }
}
