package delfinen.misc;
import delfinen.model.ProSwimmer;

import java.util.Comparator;

public class ProSwimmerComparator implements Comparator<ProSwimmer> {

    private String swimDiscipline;

    public ProSwimmerComparator(String swimDiscipline) {
        this.swimDiscipline = swimDiscipline;

    }

    @Override
    public int compare (ProSwimmer swimmer1, ProSwimmer swimmer2) {
        Comparable time1 = swimmer1.getQuickestTime(swimDiscipline);
        Comparable time2 = swimmer2.getQuickestTime(swimDiscipline);

        return time1.compareTo(time2);
    }
}
