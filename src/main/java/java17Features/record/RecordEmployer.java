package java17Features.record;

import java.util.Comparator;
import java.util.List;

public class RecordEmployer {

    public static void main(String[] args) {
        List<Employer> employers = List.of(
                new Employer("Ivan", 5, 3, 8),
                new Employer("Jack", 8, 2, 5),
                new Employer("Antony", 3, 7, 7));

        getTopEmployers(employers, 2).forEach(System.out::println);
    }

    public record Employer(String name, int javaLevel, int testingLevel, int experienceLevel) {}

    public static List<Employer> getTopEmployers(List<Employer> employers, int limit) {
        record EmployerAndScore(Employer employer, int score) {}

        return employers.stream()
                .map(employer -> new EmployerAndScore(employer, calculateScore(employer)))
                .sorted(Comparator.comparing(EmployerAndScore::score, Comparator.reverseOrder()))
                .map(EmployerAndScore::employer)
                .limit(limit)
                .toList();
    }

    private static int calculateScore(Employer employer) {
        return employer.experienceLevel + employer.javaLevel + employer.testingLevel;
    }
}
