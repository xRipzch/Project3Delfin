public class ProSwimmer  extends  Member{
    private  SwimDisciplin swimDisciplin;


    public ProSwimmer (String firstName, String lastName, int yearOfBirth, String email,
                       String adress, boolean isActive, boolean hasPaid, SwimDisciplin swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, adress, isActive, hasPaid);
        this.swimDisciplin = swimDisciplin;
    }

    public SwimDisciplin getSwimDisciplin() {
        return swimDisciplin;
    }

    public void setSwimDisciplin(SwimDisciplin swimDisciplin) {
        this.swimDisciplin = swimDisciplin;
    }
}
