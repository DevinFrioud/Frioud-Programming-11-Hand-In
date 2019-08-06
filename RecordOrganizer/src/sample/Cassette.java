package sample;

public class Cassette extends Media {
    private String length;
    private String tapeType;
    private String colour;



    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTapeType() {
        return tapeType;
    }

    public void setTapeType(String tapeType) {
        this.tapeType = tapeType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


// constructor for cassette class based on media class
    Cassette(String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format) {
        super(name, condition, label, catNumber, releaseYear, genre, artist, format);
    }
    Cassette(String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format, String length, String tapeType, String colour) {
        super(name, condition, label, catNumber, releaseYear, genre, artist, format);
        this.length = length;
        this.tapeType = tapeType;
        this.colour = colour;
    }
    public String get1Configs(){
        return length;
    }
    public String get2Configs(){
        return tapeType;
    }
    public String get3Configs(){
        return colour;
    }

}


