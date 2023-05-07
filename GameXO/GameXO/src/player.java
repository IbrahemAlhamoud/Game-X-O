import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class player {

    private String player1;
    private String player2;
    private String p1Choose;
    private String p2Choose;
    private Integer p1Count =0;
    private Integer p2Count =0;

    private  String instanceName = null;

    private Map<String,Object> data ;






    public void enterName() {

        Scanner o = new Scanner(System.in);
        System.out.println("Enter Player 1 :");
        String p1 = o.nextLine();


        Scanner o1 = new Scanner(System.in);
        System.out.println("Enter Player 2 :");
        String p2 = o1.nextLine();


        this.player1 = p1;
        this.player2 = p2;
    }

    public String getP1Choose() {
        return p1Choose;
    }

    public String getP2Choose() {
        return p2Choose;
    }

    private void dataGame (){

        Map<String, Object> m = new HashMap<>();
        m.put(getPlayer1(),getP1Choose());
        m.put(getPlayer2(), getP2Choose());
        this.data=m;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public void choose(String p,String name) {

      if(name.equals(getPlayer1())) {

          if (p.equals("x")) {
              this.p1Choose = p;
              this.p2Choose = "o";
          } else if (p.equals("o")) {

              this.p1Choose = p;
              this.p2Choose = "x";

          } else {
              throw new IllegalArgumentException("Enter X or O");
          }
      }
      else if (name.equals(getPlayer2())) {

          if (p.equals("x")) {
              this.p2Choose = p;
              this.p1Choose = "o";
          } else if (p.equals("o")) {

              this.p2Choose = p;
              this.p1Choose = "x";

          } else {
              throw new IllegalArgumentException("Enter X or O");
          }
      }

        System.out.println("Player1 --> " + this.player1 + " choose " + p1Choose);
        System.out.println("Player2 --> " + this.player2 + " choose " + p2Choose);
        dataGame();
        System.out.println(getData());
    }

    public String randomPlayers(Boolean b){

        String[] randomPlayer = {this.getPlayer1(),this.getPlayer2()};
        int id = (int)Math.round(Math.random());
        if((getInstanceName() == null)||(b==true)){
        String name = randomPlayer[id];
        setInstanceName(name);
        return name;
        }
        return null;
    }


    public Map<String,Object> FinalAll (App app){

        if(app.getIteratorClient().getTeamPlayerWin().equals(this.getPlayer1())){

            this.p1Count+=1;
            data.put("WinPlayer1",p1Count);
            data.put("WinPlayer2", p2Count);
            return data;


        } else if (app.getIteratorClient().getTeamPlayerWin().equals(this.getPlayer2())) {

            this.p2Count+=1;
            data.put("WinPlayer1",p1Count);
            data.put("WinPlayer2", p2Count);
            return data;
        }


        return null;
    }
}
