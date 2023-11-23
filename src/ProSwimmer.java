public class ProSwimmer  extends  Member{
    private  SwimDisciplin swimDisciplin;


    public ProSwimmer (String firstName, String lastName, int yearOfBirth, String email, String adresse, boolean isActive, SwimDisciplin swimDisciplin) {
        super(firstName, lastName, yearOfBirth, email, adresse, isActive, true);
        this.swimDisciplin = swimDisciplin;
    }

    public SwimDisciplin getSwimDisciplin() {
        return swimDisciplin;
    }

    public void setSwimDisciplin(SwimDisciplin swimDisciplin) {
        this.swimDisciplin = swimDisciplin;
    }
}
