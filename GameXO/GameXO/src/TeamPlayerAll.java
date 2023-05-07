
import java.util.ArrayList;

import java.util.List;

public class TeamPlayerAll implements TeamPlayer{

    private List<List<Integer>> pass ;




    public TeamPlayerAll(List<List<Integer>> pass) {
        this.pass = pass;


    }

    public List<List<Integer>> getPass() {
        return pass;
    }

    public List<List<Integer>> possibilitiesPlayer (List<Integer> l,String name){
        List<List<Integer>> num =new ArrayList<>();
        for (int i=0; i<l.size();i++){

            for (int j=i+1; j<l.size();j++){

                for (int z=j+1; z<l.size();z++){

                    List<Integer> a = new ArrayList<>();
                    a.add(l.get(i));
                    a.add(l.get(j));
                    a.add(l.get(z));
                    num.add(a);

                }

            }
        }

        System.out.println("Number possibilities Player "+name+" ----> "+num.size());
        num.forEach(System.out::println);

        return num;
    }

    public  iteratorManager chooseIterator (App app){

        if(app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer2())){

            return createPlayerIterator(possibilitiesPlayer(app.getInitTable().getChoosePlayer1(),app.getPlayer().getPlayer1()),app.getPlayer().getPlayer1());

        }

        else if (app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer1())) {

            return createPlayerIterator(possibilitiesPlayer(app.getInitTable().getChoosePlayer2(),app.getPlayer().getPlayer2()),app.getPlayer().getPlayer2());
        }

        return null;
    }
    @Override
    public iteratorManager createPlayerIterator(List<List<Integer>> possibilities,String player) {
        return  new iteratorTeamPlayer(this,possibilities,player);
    }

}
