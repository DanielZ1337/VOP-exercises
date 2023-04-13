package student_information;

import java.util.TreeSet;

public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private String department;
    private String result;
    private double marks;

    public Student(String name, int age, String department, String result, double marks) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.result = result;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getResult() {
        return result;
    }

    public double getMarks() {
        return marks;
    }

    //uncomment the toString(). Make sure you use the same names of getter methods in the toString()
    @Override
    public String toString() {
        return String.format("%s \t \t %d \t \t %s \t \t %s \t \t %.2f\n", getName(), getAge(), getDepartment(), getResult(), getMarks());
    }

    @Override
    public int compareTo(Student s) {
        return Double.compare(this.getMarks(), s.getMarks());
    }

    public static void main(String[] args) {
//        Task 1a
        TreeSet<Student> studentSet1 = new TreeSet<>();
        studentSet1.add(new Student("Tim", 20, "me", "pass", 9.8));
        studentSet1.add(new Student("Bo", 21, "me", "pass", 9.2));
        studentSet1.add(new Student("Ella", 19, "ece", "fail", 3.2));
        studentSet1.add(new Student("Emma", 19, "ece", "pass", 9.6));
        studentSet1.add(new Student("Paul", 20, "cse", "pass", 8.6));
        System.out.println("Sorting based on Marks:");
        System.out.println(studentSet1);


//        Task 1b
        TreeSet<Student> studentSet2 = new TreeSet<>(new AgeComparator());
        studentSet2.addAll(studentSet1);
        System.out.println("Sorting based on Age:");
        System.out.println(studentSet2);


    }

}
