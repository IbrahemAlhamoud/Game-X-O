import java.util.Scanner;

public class commandEdit extends CommandBase{




    public commandEdit(Control control, App app) {
        super(control, app);
    }
    private Integer numberChoose(String number){
        Integer num;
        switch (number){

            case "0" :

                num = Integer.parseInt("0");
                break;

            case "1" :

                num = Integer.parseInt("1");
                break;

            case "2" :

                num = Integer.parseInt("2");
                break;

            case "3" :

                num = Integer.parseInt("3");
                break;

            case "4" :

                num = Integer.parseInt("4");
                break;

            case "5" :

                num = Integer.parseInt("5");
                break;


            case "6" :

                num = Integer.parseInt("6");
                break;

            case "7" :

                num = Integer.parseInt("7");
                break;


            case "8" :

                num = Integer.parseInt("8");
                break;

            default: {

                throw new IllegalArgumentException(" Enter number 0 -----> 8 ");
            }
        }
        return num;

    }

    private boolean checkLocation (String location) {
        Boolean b=true;
        Integer num = numberChoose(location);
        if (app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer2())) {

            for (Integer i : app.getInitTable().getChoosePlayer1()) {

                if (num == i) {

                    b = false;
                    System.out.println("Location cannot be taken " + i + " from the player " + app.getPlayer().getPlayer1());
                    break;
                }
            }
        }


         else if (app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer1())) {

            for (Integer i : app.getInitTable().getChoosePlayer2()) {

                if (num == i) {

                    b = false;
                    System.out.println("Location cannot be taken " + i + " from the player " + app.getPlayer().getPlayer2());
                    break;
                }
            }
        }
            return b;
    }


private void loop(Integer i){

    System.out.println("===========================================");
    System.out.println("round -----------> "+i);
    Scanner o = new Scanner(System.in);
    System.out.println("Enter location " + app.getPlayer().getInstanceName() + " :");
    String l = o.nextLine();
    if ((l != null)&&(checkLocation(l))) {

        this.control.editTable(numberChoose(l),app);

    }
    else {
        // throw new IllegalArgumentException("enter location the correct correct and available .....");
        System.out.println("enter location the correct correct and available .....");
        System.out.println("round -----------> "+i);
        app.getInitTable().availableArray(app.getControl().getId());
        loop(i);
    }
}

    @Override
    public void execute() {

        System.out.println("<----The game is 8 rounds---->");
        for (int i = 0; i <=9; i++){


            if(i==9){

                System.out.println("The score is equal");
                break;
            }

            if(i < 9){

                if(app.getIteratorClient().getLock()){
                    app.getIteratorClient().setLock(false);
                    break;
                }
                else{
                    loop(i);
                }

            }

            if(i>=4){
                this.control.scoreCalculation(app);
            }

        }
        app.getInitTable().printTableResultsAll(app);
        System.out.println("<-------Game over------->");

    }
}
