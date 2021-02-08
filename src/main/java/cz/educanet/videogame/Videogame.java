package cz.educanet.videogame;

public class Videogame {
    private int id;
    private String name;
    private String genre;
    private int release;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getRelease() {
        return release;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRelease(int release) {
        this.release = release;
    }
}
