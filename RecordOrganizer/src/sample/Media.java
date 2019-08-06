package sample;
// creates superclass media upon which three media classes are based
public class Media {
    protected String name;
    protected String condition;
    protected String label;
    protected String catNumber;
    protected int releaseYear;
    protected String genre;
    protected String artist;
    protected String format;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Media(String name, String condition, String label, String catNumber, int releaseYear, String genre, String artist, String format) {
        this.name = name;
        this.condition = condition;
        this.label = label;
        this.catNumber = catNumber;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artist = artist;
        this.format= format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCatNumber() {
        return catNumber;
    }

    public void setCatNumber(String catNumber) {
        this.catNumber = catNumber;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
// configs are the 3 criteria that change based on media type
    // records are the only media type with size and speed, whereas cassette has length and tape type
    public String get1Configs(){
        return null;
    }
    public String get2Configs(){
        return null;
    }
    public String get3Configs(){
        return null;
    }

    public String toString() {
        return (name);
    }
}
