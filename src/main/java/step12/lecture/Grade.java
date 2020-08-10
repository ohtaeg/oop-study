package step12.lecture;

public class Grade {
    private final String name;
    private final int upper;
    private final int lower;

    public Grade(final String name, final int upper, final int lower) {
        this.name = name;
        this.upper = upper;
        this.lower = lower;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean isInclude(int score) {
        return score >= lower && score <= upper;
    }

    public String getName() {
        return name;
    }
}
