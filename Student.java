import java.util.concurrent.ThreadLocalRandom;

/********************
 * Student Class contains data about a student. The static studentID variable maintains the studentNumber.
 * There is no setter for studentID or studentNumber because it remains unchanged once created.
 *
 *
 */

public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    static int studentID = 100000;
    private int studentNumber;
    Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        studentNumber = studentID;
        studentID++;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }


    public String toString(){ //Returns the student's info as a string
        return("Name: " + firstName + " " + lastName + " Grade: " + grade);
    }
}
