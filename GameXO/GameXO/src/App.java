import java.util.Scanner;

public class App {

    private player player = new player();
    private roleChange roleChange=new roleChange();
    private Control control = new Control();

    private initTable initTable = new initTable();

    private iteratorClient iteratorClient = new iteratorClient();


    public iteratorClient getIteratorClient() {
        return iteratorClient;
    }

    public Control getControl() {
        return control;
    }


    public player getPlayer() {
        return player;
    }

    public roleChange getRoleChange() {
        return roleChange;
    }

    public initTable getInitTable() {
        return initTable;
    }

    public void initGame() {

        this.player.enterName();
        start(false);

    }
    private void start(Boolean b){
        String x1 =this.player.randomPlayers(b);
        this.roleChange.role(x1,this.getPlayer());
        this.initTable.initializationArray();
        this.initTable.printTable(this.initTable.getAvailable());
        executeCommand(new commandEdit(control,this));
        PlayAgain();
    }

    private void PlayAgain (){

        Scanner o = new Scanner(System.in);
        System.out.println("Do you want to continue ...... [1 ---> yes , 2 ---> no]");
        String q = o.nextLine();
        if(q.equals("1")){

            Scanner o1 = new Scanner(System.in);
            System.out.println("Do you choose to continue with the current situation[1] or play a new game[2]?");
            String q1 = o.nextLine();
            if(q1.equals("1")){
                System.out.println("=============================================");

                this.getInitTable().getChoosePlayer1().clear();
                this.getInitTable().getChoosePlayer2().clear();
                this.getInitTable().getSave().clear();
                this.getInitTable().getAvailable().clear();
                start(true);


            } else if (q1.equals("2")) {

                System.out.println("=============================================");
                App app1 =new App();
                app1.initGame();

            }
            else {
                throw new IllegalArgumentException("Error Choose  continue with the current situation or play a new game ....");
            }


        } else if (q.equals("2")) {
            System.exit(0);
        }
        else {
            throw new IllegalArgumentException("Error Choose Yes or No ....");
        }
    }

    private void executeCommand(CommandBase command) {

         command.execute();

    }
}
