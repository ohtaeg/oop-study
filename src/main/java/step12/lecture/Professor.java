package step12.lecture;

public class Professor {
    private final String name;
    private final Lecture lecture;

    public Professor(final String name, final Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg : %.1f", name, lecture.evaluate(), lecture.average());
    }
}
