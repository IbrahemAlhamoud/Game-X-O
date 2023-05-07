import java.util.Scanner;

public class Game {

    public EventManager events;


    public Game() {
        this.events = new EventManager("eventEdit","eventResults");
    }

    public void editTables (App app){

        events.notify("eventEdit",app);

    }

    public void results (App app){

        events.notify("eventResults",app);
    }







}
