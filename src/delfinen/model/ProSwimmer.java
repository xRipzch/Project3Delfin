package delfinen.model;

import delfinen.misc.SwimDiscipline;

import java.util.ArrayList;

public class ProSwimmer extends Swimmer {
    private SwimDiscipline swimDisciplin;
    private double quickestTime; // Sikre invarians
    //private Map<SwimDiscipline, Double> trainingResults;
    private ArrayList<ResultTraining> trainingResultTrainings;
    private ArrayList<ResultCompetition> competitionResult;


    public ProSwimmer(String firstName, String lastName, int yearOfBirth, String email,
                      String address, boolean isActive, boolean isPaid,
                      SwimDiscipline swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, address, isActive, isPaid);
        this.swimDisciplin = swimDisciplin;
        this.trainingResultTrainings = new ArrayList<ResultTraining>();
        this.competitionResult = new ArrayList<ResultCompetition>();


    }

    public void addResultToArray(ResultTraining resultTraining) {
        trainingResultTrainings.add(resultTraining);
    }

    public void addCompResultToArray(ResultCompetition resultCompetition) {
        competitionResult.add(resultCompetition);
    }

    public ArrayList<ResultCompetition> getCompetitionResult() {
        return competitionResult;
    }

    public ArrayList<ResultTraining> getTrainingResults() {
        return trainingResultTrainings;
    }


    public SwimDiscipline getSwimDisciplin() {
        return swimDisciplin;
    }

    @Override
    public String toString() {
        return "ProSwimmer{" +
                "trainingResults=" + trainingResultTrainings +
                '}';
    }
}