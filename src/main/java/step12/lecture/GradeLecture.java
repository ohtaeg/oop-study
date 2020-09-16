package step12.lecture;

import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Lecture 출력 결과에 등급별 통계를 추가
 */
public class GradeLecture extends Lecture {
    private final List<Grade> grades;

    public GradeLecture(final String title, final int pass, final List<Integer> scores, final List<Grade> grades) {
        super(title, pass, scores);
        this.grades = grades;
    }

    // 오버로딩
    public double average(String gradeName) {
        return grades.stream()
                     .filter(each -> each.isName(gradeName))
                     .findFirst()
                     .map(this::gradeAverage)
                     .orElse(0d);
    }

    // 오버라이드
    @Override
    public String evaluate() {
        return super.evaluate() + " @ " + gradeStatistics();
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }

    private String gradeStatistics() {
        return grades.stream()
                     .map(grade -> format(grade))
                     .collect(joining(" "));
    }

    private double gradeAverage(final Grade grade) {
        return getScores().stream()
                          .filter(grade::isInclude)
                          .mapToInt(Integer::intValue)
                          .average()
                          .orElse(0);
    }

    private String format(final Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(final Grade grade) {
        return getScores().stream()
                          .filter(grade::isInclude)
                          .count();
    }
}
