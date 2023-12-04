package delfinen;

import java.util.HashMap;
import java.util.Map;

public class ProSwimmer extends Swimmer {
    private SwimDiscipline swimDisciplin;
    private double quickestTime; // Sikre invarians
    private Map<SwimDiscipline, Double> trainingResults;


    public ProSwimmer(String firstName, String lastName, int yearOfBirth, String email,
                      String address, boolean isActive, boolean isPaid,
                      SwimDiscipline swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, address, isActive, isPaid);
        this.swimDisciplin = swimDisciplin;
        this.trainingResults = new HashMap<>();
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

    public double getQuickestTime() {
        return quickestTime;
    }

    public void addTrainingResult(SwimDiscipline swimDiscipline, double result) {
        if (!trainingResults.containsKey(swimDiscipline) || result > trainingResults.get(swimDiscipline))
            trainingResults.put(swimDiscipline, result);
    }
}
