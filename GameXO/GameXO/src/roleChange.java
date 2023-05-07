import java.util.Scanner;

public class roleChange implements EventListener{

    private player player;

    public player getPlayer() {
        return player;
    }

    public void setPlayer(player player) {
        this.player = player;
    }

    public void role (String players, player player){
        setPlayer(player);
        System.out.println(players + " what choose X or O .....");
        Scanner o = new Scanner(System.in);
        String p = o.nextLine();
        this.player.choose(p,players);
        System.out.println("Start "+players+" .... ");
        System.out.println("Choose the place you want ..... ");

    }
    @Override
    public void update(String eventType, App app) {

        if(app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer1())){

            app.getPlayer().setInstanceName(app.getPlayer().getPlayer2());
        }

        else if (app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer2())) {

            app.getPlayer().setInstanceName(app.getPlayer().getPlayer1());

        }


    }
}
