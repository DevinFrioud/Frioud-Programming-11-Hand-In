package sample;

public class CompactDisk extends Media {
    private String bitRate;
    private String length;
    private String colour;

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


// constructor for CompactDisk class based on media class
    CompactDisk (String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format) {
        super(name, condition, label, catNumber, releaseYear, genre, artist, format);
    }
    CompactDisk (String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format, String length, String bitRate, String colour ) {
        super(name, condition, label, catNumber, releaseYear, genre, artist, format);
        this.bitRate = bitRate;
        this.length=length;
        this.colour = colour;
    }
    public String get1Configs(){
        return length;
    }
    public String get2Configs(){
        return bitRate;
    }
    public String get3Configs(){
        return colour;
    }

}




