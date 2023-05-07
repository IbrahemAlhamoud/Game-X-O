
import java.util.ArrayList;
import java.util.List;

public class iteratorClient implements EventListener{



    private  TeamPlayerAll teamPlayer;

    private  Boolean  lock = false;
    private String teamPlayerWin ;



    public String getTeamPlayerWin() {
        return teamPlayerWin;
    }

    public void setTeamPlayerWin(String teamPlayerWin) {
        this.teamPlayerWin = teamPlayerWin;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    private  List<List<Integer>> solutions (){

        List<List<Integer>> data = List.of(

                List.of(0,1,2),
                List.of(0,3,6),
                List.of(0,4,8),
                List.of(2,5,8),
                List.of(1,4,7),
                List.of(2,4,6),
                List.of(3,4,5),
                List.of(6,7,8),
                List.of(3,0,6),
                List.of(3,6,0),
                List.of(4,1,7),
                List.of(4,7,1),
                List.of(5,2,8),
                List.of(5,8,2),
                List.of(4,8,0),
                List.of(4,0,8),
                List.of(4,2,6),
                List.of(4,6,2),
                List.of(1,0,2),
                List.of(1,2,0),
                List.of(7,8,6),
                List.of(7,6,8),
                List.of(4,3,5),
                List.of(4,5,3));



        //data.forEach(System.out::println);

        return data;

    }




    @Override
    public void update(String eventType, App app) {




            teamPlayer = new TeamPlayerAll(solutions());
            ResultsGame  resultsGame = new ResultsGame(teamPlayer,app);
            resultsGame.show();



    }
}
