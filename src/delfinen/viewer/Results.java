package delfinen.viewer;

import delfinen.misc.SwimDiscipline;

public class Results {

    private String name;
    private double time;
    private String date;
    private SwimDiscipline swimDiscipline;
    private String competitionName;

    public Results(String name, double time, String date, SwimDiscipline swimDiscipline, String competitionName) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.swimDiscipline = swimDiscipline;
        this.competitionName = competitionName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SwimDiscipline getSwimDiscipline() {
        return swimDiscipline;
    }

    public void setSwimDiscipline(SwimDiscipline swimDiscipline) {
        this.swimDiscipline = swimDiscipline;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
}
