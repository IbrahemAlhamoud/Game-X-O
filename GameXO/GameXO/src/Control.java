public class Control {

    private Integer id ;




    public Integer getId() {
        return id;
    }

    public void editTable (Integer location , App app){

        this.id=location;
        Game game = new Game();
        game.events.subscribe("eventEdit", app.getInitTable());
        game.events.subscribe("eventEdit", app.getRoleChange());
        game.editTables(app);


    }

    public void  scoreCalculation (App app){

        Game game1 = new Game();
        game1.events.subscribe("eventResults",app.getIteratorClient());
        game1.results(app);
    }


}
