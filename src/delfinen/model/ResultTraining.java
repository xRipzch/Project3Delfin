package delfinen.model;

import delfinen.misc.SwimDiscipline;

import java.time.LocalDate;
import java.util.Comparator;


public class ResultTraining implements Comparator {
    private double trainingResult;
    private LocalDate date;
    private SwimDiscipline swimDiscipline;

    ProSwimmer proSwimmer = new ProSwimmer("first", "last", 1994, " email", "address", true, true, SwimDiscipline.BACKSTROKE);


    public ResultTraining(double trainingResult, LocalDate date, SwimDiscipline swimDiscipline){
        this.trainingResult = trainingResult;
        this.date = date;
        this.swimDiscipline = swimDiscipline;
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

    public String getName(){
        return proSwimmer.getFirstName() + " " + proSwimmer.getLastName();
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nResult: " + trainingResult +
                "\n Date: " + date +
                "\n SwimDiscipline: " + swimDiscipline;
    }
}
