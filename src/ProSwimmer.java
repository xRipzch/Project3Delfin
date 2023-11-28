public class ProSwimmer  extends Swimmer {
    private  SwimDisciplin swimDisciplin;


    public ProSwimmer (String firstName, String lastName, int yearOfBirth, String email,
                       String adress, boolean isActive, boolean isPaid, SwimDisciplin swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, adress, isActive, isPaid);
        this.swimDisciplin = swimDisciplin;
    }

    public SwimDisciplin getSwimDisciplin() {
        return swimDisciplin;
    }

    public void setSwimDisciplin(SwimDisciplin swimDisciplin) {
        this.swimDisciplin = swimDisciplin;
    }
}
