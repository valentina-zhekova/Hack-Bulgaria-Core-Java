package com.hackbulgaria.corejava2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;
import com.hackbulgaria.corejava2.data.StudentsDataFactory;

public interface StudentOperationsSubclass extends StudentOperations {
    // should be so?
    public List<Student> someStudents = new StudentsDataFactory().getAllStudents();
    
    default public double getAverageMark() {
        return someStudents.stream()
                           .mapToDouble(Student::getGrade)
                           .average()
                           .getAsDouble();
    }

    default public List<Student> getAllPassing() {
        return someStudents.stream()
                           .filter(student -> student.getGrade() > 2.0)
                           .collect(Collectors.toList());
    }

    default public List<Student> getAllFailing() {
        return someStudents.stream()
                           .filter(student -> student.getGrade() <= 2.0)
                           .collect(Collectors.toList());
    }

    /**
     * Split the list of students into two groups - a group with equal or higher
     * marks than the given `splitMark` ('true') and the one with lower marks
     * than the given `splitMark` ('false')
     * 
     * @return
     */
    default public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        return someStudents.stream()
                           .collect(Collectors.groupingBy(
                                   student -> student.getGrade() >= splitMark, 
                                   Collectors.toList()));
    }

    // the comparator... ?
    default public List<Student> orderByMarkDescending() {
        Comparator<Student> byGradeDescending = (s1, s2) -> - Double.compare(s1.getGrade(), s2.getGrade());
        return someStudents.stream()
                           .sorted(byGradeDescending)
                           .collect(Collectors.toList());
    }

    default public List<Student> orderByMarkAscending() {
        Comparator<Student> byGradeAscending = (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade());
        return someStudents.stream()
                           .sorted(byGradeAscending)
                           .collect(Collectors.toList());
    }

    /**
     * @return clusterize the students by their marks and return all the
     *         students with the highest mark.
     * 
     *         Example: If Georgi and Ivo have 6.0, but Radoslav has 5.0, you
     *         have to return Georgi and Ivo, but not Radoslav
     */
    default public List<Student> getStudentsWithLowestMarks() {
        List<Student> sortedAscending = orderByMarkAscending();
        return sortedAscending.stream()
                              .filter(student -> student.getGrade() == sortedAscending.get(0).getGrade())
                              .collect(Collectors.toList());
    }

    default public List<Student> getStudentsWithHighestMarks() {
        List<Student> sortedDescending = orderByMarkDescending();
        return sortedDescending.stream()
                               .filter(student -> student.getGrade() == sortedDescending.get(0).getGrade())
                               .collect(Collectors.toList());
    }

    /**
     * @return a map consisting of a List of marks per a given age, e.g.
     *         result.get(20) would return the list of all the marks of the
     *         students that are 20 years old.
     */
    default public Map<Integer, List<Double>> getMarksDistributionByAge() {
        return someStudents.stream()
                           .collect(Collectors.groupingBy(
                                   Student::getAge, 
                                   Collectors.mapping(
                                           Student::getGrade, 
                                           Collectors.toList())));
    }

    default public Map<Gender, Double> getAverageMarkByGender() {
        return someStudents.stream()
                           .collect(Collectors.groupingBy(
                                   Student::getGender, 
                                   Collectors.averagingDouble(Student::getGrade)));
    }

    /**
     * example: Return a map that contains 4.5 -> 3 times 4.0 -> 2 times. 2.0 ->
     * 8 times.
     * 
     * @return
     */
    // Integer problem
    default public Map<Double, Integer> getMarksDistribution() {
        //return someStudents.stream()
        //                     .collect(Collectors.groupingBy(
        //                             Student::getGrade, 
        //                             Collectors.counting()));
        return null;
    }

    /**
     * @return "first@email.com, second@email.com, third@email.com..."
     */
    // maybe not working properly
    default public String getEmailToHeader() {
        return someStudents.stream()
                           .map(student -> student.getEmail() + ", ")
                           .toString();
    }

    /**
     * Split the students by their gender, and then partition them by their age
     */
    default public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
        return someStudents.stream()
                           .collect(Collectors.groupingBy(
                                   Student::getGender, 
                                   Collectors.groupingBy(
                                           Student::getAge, 
                                           Collectors.toList())));
    }
}
