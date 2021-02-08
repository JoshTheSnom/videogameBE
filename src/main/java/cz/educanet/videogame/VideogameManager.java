package cz.educanet.videogame;

import javax.enterprise.context.ApplicationScoped;
import java.lang.reflect.Array;
import java.util.ArrayList;

@ApplicationScoped
public class VideogameManager {
    ArrayList<Videogame> videogames = new ArrayList<>();
    int count = 0;

    public ArrayList<Videogame> getVideogames() {
        return videogames;
    }
    public void addVideogame(Videogame newVideogame) {
        newVideogame.setId(count);
        count++;
        videogames.add(newVideogame);
    }

    public boolean editVideogame(int id, Videogame edited) {
        if(existsById(id)) {
            Videogame videogame = getVideogameById(id);
            videogame.setName(edited.getName());
            videogame.setGenre(edited.getGenre());
            videogame.setRelease(edited.getRelease());
            return true;
        }
        else return false;
    }

    public boolean deleteVideogame(int id) {
        return videogames.remove(getVideogameById(id));
    }

    public boolean existsById(int id) {
        for (Videogame videogame : videogames) {
            if (videogame.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Videogame getVideogameById(int id) {
        for (Videogame videogame : videogames) {
            if(videogame.getId() == id) {
                return videogame;
            }
        }
        return null;
    }


}
