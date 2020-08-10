package step12.lecture;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {

    public FormattedGradeLecture(final String title, final int pass, final List<Integer> scores, final List<Grade> grades) {
        super(title, pass, scores, grades);
    }

    public String formatAverage() {
        return String.format("Avg : %1.f", super.average());
    }
}
