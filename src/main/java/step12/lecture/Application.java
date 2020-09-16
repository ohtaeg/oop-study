package step12.lecture;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Lecture lecture = new Lecture( "객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));
        Lecture gradeLecture = new GradeLecture("객체지향 프로그래밍"
                , 70
                , Arrays.asList(81, 95, 75, 50, 45)
                , Arrays.asList(new Grade("A", 100, 95)
                                ,new Grade("B", 94, 80)
                                ,new Grade("C", 79, 70)
                                ,new Grade("D", 69, 50)
                                ,new Grade("F", 49, 0))
        );

        System.out.println(lecture.evaluate());
        System.out.println(gradeLecture.evaluate());
        //System.out.println(gradeLecture.stats());
        System.out.println(lecture.average());
        System.out.println(gradeLecture.average());

        System.out.println("-----------------");
        Professor professor = new Professor("다익스트라", new Lecture("알고리즘", 70, Arrays.asList(81, 95, 75, 50, 45)));
        Professor otherProfessor = new Professor("다익스트라", new GradeLecture("객체지향 프로그래밍"
                , 70
                , Arrays.asList(81, 95, 75, 50, 45)
                , Arrays.asList(new Grade("A", 100, 95)
                ,new Grade("B", 94, 80)
                ,new Grade("C", 79, 70)
                ,new Grade("D", 69, 50)
                ,new Grade("F", 49, 0))
        ));
        System.out.println(professor.compileStatistics());
        System.out.println(otherProfessor.compileStatistics());
    }
}
