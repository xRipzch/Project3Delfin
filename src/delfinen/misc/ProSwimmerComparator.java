package delfinen.misc;

import delfinen.model.ProSwimmer;
import delfinen.model.ResultTraining;
import java.util.ArrayList;

import java.util.Comparator;

public class ProSwimmerComparator implements Comparator<ProSwimmer> {

    private SwimDiscipline swimDiscipline;

    public ProSwimmerComparator(SwimDiscipline swimDiscipline) {
        this.swimDiscipline = swimDiscipline;

    }

    @Override
    public int compare(ProSwimmer swimmer1, ProSwimmer swimmer2) {
        ArrayList<ResultTraining> results1 = swimmer1.getTrainingResults();
        ArrayList<ResultTraining> results2 = swimmer2.getTrainingResults();

        // Assuming you want to compare the first result's training time
        Double time1 = results1.isEmpty() ? Double.MAX_VALUE : results1.get(0).getTrainingResult();
        Double time2 = results2.isEmpty() ? Double.MAX_VALUE : results2.get(0).getTrainingResult();

        return Double.compare(time1, time2);
    }
}
