import java.util.ArrayList;
import java.util.List;

class Database {
    private static List<Film> allfilms = new ArrayList();
    public static void addFilm(Film film) {
        allfilms.add(film);
    }

    private static List<Actor> allactors = new ArrayList();
    public static void addActor(Actor actor) {
        allactors.add(actor);
    }

    public static List<Actor> getActors(){
        return allactors;
    }
    public static List<Film> getFilms(){
        return allfilms;
    }
}