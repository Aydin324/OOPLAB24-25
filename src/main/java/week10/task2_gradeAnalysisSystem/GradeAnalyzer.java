package week10.task2_gradeAnalysisSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class GradeAnalyzer {
    private List<Integer> grades = new ArrayList<Integer>();

    public GradeAnalyzer(List<Integer> grades) {
        this.grades = grades;
    }

    public OptionalDouble calculateAverage() {
        OptionalDouble average = grades.stream()
                .mapToInt(Integer::intValue)
                .average();

        return average;
    }

    public void printSummary(){
        OptionalDouble average = calculateAverage();
        if(average.isPresent()){
            System.out.println("The average of grades is: " + average.getAsDouble());
        }
        else{
            System.out.println("There are no grades to be analyzed.");
        }
    }
}
