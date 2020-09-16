package step12.lecture;

import java.util.Collections;
import java.util.List;

public class Lecture {
    private final String title;
    private final int pass;
    private final List<Integer> scores;

    public Lecture(final String title, final int pass, final List<Integer> scores) {
        this.title = title;
        this.pass = pass;
        this.scores = scores;
    }

    public double average() {
        System.out.print("parent : ");
        return scores.stream()
                     .mapToInt(Integer::intValue)
                     .average()
                     .orElse(0);
    }

    public String stats() {
        return String.format("Title : %s, Evaluation Method : %s", title, this.getEvaluationMethod());
    }

    public String getEvaluationMethod() {
        return "Pass or Fail";
    }

    public String evaluate() {
        final int passCount = (int) passCount();
        return String.format("parent Pass : %d , Fail : %d", passCount, failCount(passCount));
    }

    private long passCount() {
        return scores.stream()
                     .filter(score -> score >= pass)
                     .count();
    }

    private int failCount(final int passCount) {
        return scores.size() - passCount;
    }



    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }
}
