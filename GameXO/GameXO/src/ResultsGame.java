import java.util.HashMap;
import java.util.Map;

public class ResultsGame {


    private TeamPlayerAll teamPlayer;
    private App app;






    public ResultsGame(TeamPlayerAll teamPlayer,App app) {
        this.teamPlayer = teamPlayer;
        this.app=app;

    }

    public void show(){
        Map<String,Object> b ;
        iteratorManager iterator = teamPlayer.chooseIterator(app);
        while (iterator.hasNext()){

            b = iterator.getNext();

            if(b.get("winPlayer")!=null){

                app.getIteratorClient().setTeamPlayerWin((String) b.get("winPlayer"));
            }
           app.getIteratorClient().setLock((Boolean) b.get("result"));


        }





    }
}
