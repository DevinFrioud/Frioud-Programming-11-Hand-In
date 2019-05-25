public class Main {
    public static void main(String[] args) {
       School highSchool = new School("Ridgemont High", "778-555-4026", "admin@ridgemont.ca");
        Student Devin = new Student("Devin", "Frioud", 12);
        Student Peter = new Student("Peter", "Stanley", 10);
        Student Ferris = new Student("Ferris", "Bueller", 12);
        Student Steven = new Student("Steven", "Knight", 11);
        Student Liggy = new Student("Liggy", "Brioche", 10);
        Student Daniel = new Student("Daniel", "Flutt", 9);
        Student Zach = new Student("Zach", "Gary", 8);
        Student Colin = new Student("Colin", "McQuag", 8);
        Student Ally = new Student("Ally", "Peters", 9);
        Student Ena = new Student("Ena", "Laglaji", 11);
        Teacher Clay = new Teacher("Jaimie", "Clay", "Leadership");
        Teacher Mack = new Teacher("Pete", "Mack", "Physics");
        Teacher Kawene = new Teacher("Rodayo", "Kawene", "Math");
        highSchool.addStudent(Devin);
        highSchool.addStudent(Peter);
        highSchool.addStudent(Ferris);
        highSchool.addStudent(Steven);
        highSchool.addStudent(Liggy);
        highSchool.addStudent(Daniel);
        highSchool.addStudent(Zach);
        highSchool.addStudent(Colin);
        highSchool.addStudent(Ally);
        highSchool.addStudent(Ena);
        highSchool.addTeacher(Clay);
        highSchool.addTeacher(Mack);
        highSchool.addTeacher(Kawene);
        System.out.println("Here is a full list of students attending " + highSchool.getSchoolName());
        highSchool.showStudents();
        System.out.println("Here is a full list of teachers working at " + highSchool.getSchoolName());
        highSchool.showTeachers();
        highSchool.deleteStudent(Ferris);
        highSchool.deleteStudent(Liggy);
        highSchool.deleteTeacher(Clay);
        System.out.println("Here is an updated list of students attending " + highSchool.getSchoolName());
        highSchool.showStudents();
        System.out.println("Here is an updated list of teachers working at " + highSchool.getSchoolName());
        highSchool.showTeachers();

    }
}
