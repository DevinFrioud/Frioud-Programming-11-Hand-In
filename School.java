import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;
    ArrayList courses;

    private String schoolName;
    private String phoneNumber;
    private String emailAddress;
    School(String schoolName, String phoneNumber, String emailAddress){
        this.schoolName = schoolName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();

    }
    public void addTeacher(Teacher t){ //adds a selected teacher to the ArrayList
        this.teachers.add(t);
    }
    public void addStudent(Student s){ //adds a selected student to the ArrayList
        this.students.add(s);
    }
    public void deleteStudent(Student s){ //removes a selected student from the ArrayList
        this.students.remove(s);
    }
    public void deleteTeacher(Teacher t){ //removes a selected teacher from the ArrayList
        this.teachers.remove(t);
    }
    public void showTeachers(){ //Iterates through the ArrayList, prints each teacher
        this.teachers.forEach((temp) -> {
            System.out.println(temp);
        });
    }
    public void showStudents(){ //Iterates through the ArrayList, prints each student
        this.students.forEach((temp) -> {
            System.out.println(temp);
        });
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}


