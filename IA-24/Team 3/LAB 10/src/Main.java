import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database();
        printResult();

    }

    public static void Database() {
        Film film1 = new Film("Deadpool");
        Film film2 = new Film("Focus");
        Film film3 = new Film("The Pursuit of Happyness");
        Actor actor1 = new Actor("Ryan Rodney");
        Actor actor2 = new Actor("Will Smith");
        Actor actor3 = new Actor("Syre Smith");
        Actor actor4 = new Actor("Brad Pitt");

        Database.addFilm(film1);
        Database.addFilm(film2);
        Database.addFilm(film3);
        Database.addActor(actor1);
        Database.addActor(actor2);
        Database.addActor(actor3);
        Database.addActor(actor4);

        film1.addActor(actor1);
        film2.addActor(actor2);
        film3.addActor(actor2);
        film3.addActor(actor3);
        actor1.addFilm(film1);
        actor2.addFilm(film2);
        actor2.addFilm(film3);
        actor3.addFilm(film3);

    }

    private static String mostActor() {
        int countActor = 0;
        String mostActored = "";
        List<Film> allfilms = Database.getFilms();
        for (Film film : allfilms) {
            if (countActor < film.getActors().size()) {
                countActor = film.getActors().size();
                mostActored = film.getName();
            } else if (countActor == film.getActors().size() && film.getActors().size() != 0) {
                mostActored = film.getName() + " and " + mostActored;
            }
        }
        return mostActored;
    }

    private static void printResult() {
        System.out.println("The largest number of actors in the film : " + mostActor());
        System.out.println(notFilmed()+ " - didn't act in any film ");
        System.out.println("This actor has played with "+ listOfActors("Syre Smith"));
    }

    private static String notFilmed() {
        String notInFilm ="";
        List<Actor> allActors = Database.getActors();
        for (Iterator<Actor> i = allActors.iterator(); i.hasNext(); ) {
            Actor actor = (Actor) i.next();
            if (actor.getFilms().isEmpty()) {
                notInFilm=actor.getName();
            }
        }
        return notInFilm;
    }

   public static ArrayList listOfActors (String name){
         ArrayList arrayList = new ArrayList();
          List allFilms = Database.getFilms();
          for (Iterator iterator = allFilms.iterator(); iterator.hasNext();){
            Film film = (Film) iterator.next();
            List actors = film.getActors();
              if (actors.contains(name) ){
                  for (int i =0; i< actors.size(); i++){
                    String actorName = (String) actors.get(i);
                      arrayList.add(actorName);
                  }
                  arrayList.remove(name);
              }
          }
          return arrayList;
        }






}



















