import java.util.*;

public class iteratorTeamPlayer implements iteratorManager {

    private TeamPlayerAll teamPlayerAll;

    private List<List<Integer>> possibilities ;

    private String Player;

    private  String win ;

    private boolean lockReverse =false;
    private boolean lockHasNext =false;
    private int currentPosition = 0;

    private Map <String,Object> data = new HashMap<>();

    public iteratorTeamPlayer(TeamPlayerAll teamPlayerAll, List<List<Integer>> possibilities, String player) {
        this.teamPlayerAll = teamPlayerAll;
        this.possibilities = possibilities;
        this.Player=player;
    }




    private Map<String,Object> Results(List<Integer> list){

        this.win=this.Player;

        System.out.println("Win is ------> "+this.Player+" Because he chose the solution "+list);
        if (this.lockReverse){

            this.lockReverse=false;
        }

        lockHasNext=true;
        data.put("result",true);
        data.put("winPlayer",this.win);
        return data;
    }

    @Override
    public boolean hasNext() {
        if(lockHasNext) {
            lockHasNext = false;
            return false;
        }
        else if (currentPosition < teamPlayerAll.getPass().size()) {

            return true;
        }
        return false;
    }

    @Override
    public Map<String,Object> getNext() {


 /*
        if ((!hasNext())) {

            return false;
        }


       for (List<Integer> list:teamPlayerAll.getPass()) {

            possibilities.stream()
                    .forEach(i ->
                    { if (i.equals(list)) {
                        Results(list);
                    }});
        }*/

        for (List<Integer> list:possibilities){

           if( list.equals(teamPlayerAll.getPass().get(currentPosition))){

               currentPosition++;
               return Results(list);}

           List modifiableList = new ArrayList(list);
           Collections.reverse(modifiableList);

           if (modifiableList.equals(teamPlayerAll.getPass().get(currentPosition))) {
               this.lockReverse=true;
                currentPosition++;
                return Results(list);
           }

        }

        currentPosition++;

        data.put("result",false);
        data.put("winPlayer",null);

        return data;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
