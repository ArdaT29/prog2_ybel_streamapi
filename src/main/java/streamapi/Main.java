package streamapi;

import java.io.InputStream;
import java.util.*;

/** Starter for the stream api task. */
public class Main {
    /**
     * And go.
     *
     * @param args command line parameters, not used
     */
    public static void main(String... args) {

        // Task I: Students
        List<Student> students = List.of(
            new Student("A", 30, Enrollment.IFM),
            new Student("B", 45, Enrollment.IFM),
            new Student("C", 60, Enrollment.ELT),
            new Student("D", 45, Enrollment.ARCH),
            new Student("E", 80, Enrollment.IFM)
        );
        System.out.println("Summe ECTS aller Studierenden: " + students(students));
        // Task II: Set of ECTS of all IFM students
        System.out.println("ECTS IFM-Studierende (als Set): " + ifmCps(students));
        // Task III: Random
        System.out.println("10 Zufallszahlen (0–9): " + random());
        // Task IV+V: Resources

    }

    /**
     * Task I: Students.
     *
     * <p>Calculate the total credits earned by all students.
     *
     * @param studentList List of students
     * @return Sum of credit points of all students
     */
    // Commit: Aufgabe I gelöst: Summe der ECTS mit Stream API berechnet
    // Änderung: Imperative Schleife durch Stream ersetzt, Summe über mapToInt und sum()
    public static Integer students(List<Student> studentList) {
        return studentList.stream()
            .mapToInt(Student::cps)
            .sum();
    }

    /**
     * Task II: Set of ECTS of all IFM students.
     *
     * <p>Identify the different credit points of all IFM students.
     *
     * @param studentList List of students
     * @return Set of credit points of all IFM students
     */
    // Commit: Aufgabe II gelöst: ECTS-Werte von IFM-Studierenden als Set gesammelt
    // Änderung: Stream mit Filter für IFM, Methodenreferenz und toSet()
    public static Set<Integer> ifmCps(List<Student> studentList) {
        return studentList.stream()
            .filter(s -> s.enrollment() == Enrollment.IFM)
            .map(Student::cps)
            .collect(Collectors.toSet());
    }

    /**
     * Task III: Random.
     *
     * <p>Calculate ten random integers between 0 and 10.
     *
     * @return List of ten random integers (between 0 and 10)
     */
    // Commit: Aufgabe III gelöst: 10 Zufallszahlen zwischen 0 und 9 mit Stream API generiert
    // Änderung: Random-Stream erzeugt, mit boxed() in Integer-Liste umgewandelt
    public static List<Integer> random() {
        return new Random()
            .ints(10, 0, 10)
            .boxed()
            .collect(Collectors.toList());
    }

    /**
     * Task IV: Open resources.
     *
     * <p>Open the file specified by the {@code path} parameter. This file is located in the
     * resources folder of the project.
     *
     * @param path Name of the file to be accessed within the resource folder.
     * @return An open {@link InputStream} for the resource file
     */
    // Commit: Aufgabe IV gelöst: Ressourcendatei als InputStream geöffnet
    // Änderung: Zugriff auf Ressourcen mit getClassLoader().getResourceAsStream
    private static InputStream getResourceAsStream(String path) {
        return Main.class.getClassLoader().getResourceAsStream(path);
    }

    /**
     * Task V: Read resources.
     *
     * <p>Read all lines from the resource file (specified by the {@code path} parameter). Merge all
     * lines that start with the letter "a" and are at least two characters long. The lines are to
     * be separated in the resulting string by a line-end character {@code "\n"}.
     *
     * @param path Name of the file to be accessed within the resource folder
     * @return String of all matching lines, separated by {@code "\n"}
     */
    public static String resources(String path) {
        // TODO
        throw new UnsupportedOperationException();
    }
}
