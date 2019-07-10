package sample;
/********************
 * Friend Class contains data about a friend.
 *
 *
 */
public class Friend {
    private String name;
    private int age;
    private String occupation;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
// constructor for Friend object
    Friend(String name, int age, String occupation, String location){
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.location = location;
    }
    public  String toString(){
        return(name);
    }

}
