package sample;

public class Record extends Media {
    private int speed;
    private int size;
    private String colour;


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

// constructor for the record class based on the media class
    Record(String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format) {
        super(name, condition, label, catNumber, releaseYear, genre, artist, format);

    }
    Record(String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format, int speed, int size, String colour) {
        super(name, condition, label, catNumber, releaseYear, genre, artist, format);
        this.speed = speed;
        this.size = size;
        this.colour = colour;
    }
    public String get1Configs(){
        return Integer.toString(speed);
    }
    public String get2Configs(){
        return Integer.toString(size);
    }
    public String get3Configs(){
        return colour;
    }


}