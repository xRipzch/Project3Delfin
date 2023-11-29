import java.util.Collection;

public class ProSwimmer  extends Swimmer {
    private SwimDiscipline swimDisciplin;
    private double quickestTime; // Sikre invarians


    public ProSwimmer (String firstName, String lastName, int yearOfBirth, String email,
                       String address, boolean isActive, boolean isPaid,
                       SwimDiscipline swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, address, isActive, isPaid);
        this.swimDisciplin = swimDisciplin;
    }


    public SwimDiscipline getSwimDisciplin() {
        return swimDisciplin;
    }

    public void setSwimDisciplin(SwimDiscipline swimDisciplin) {
        this.swimDisciplin = swimDisciplin;
    }

    public void setQuickestTime(double quickestTime) {
        if (quickestTime>0){
        this.quickestTime = quickestTime;
    } else System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid value.");
    }
    public double getQuickestTime() {
        return quickestTime;
    }


}
