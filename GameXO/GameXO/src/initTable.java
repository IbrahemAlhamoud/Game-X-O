import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class initTable implements EventListener{

    private LinkedList<String> arrayTable = new LinkedList<>();
    private LinkedList<String>  available = new LinkedList<>();

    private Map<String, LinkedList<Integer>> save = new HashMap<>();
    private LinkedList<Integer> choosePlayer1 = new LinkedList<>();
    private LinkedList<Integer> choosePlayer2 = new LinkedList<>();



    public Map<String, LinkedList<Integer>> getSave() {
        return save;
    }
    public LinkedList<Integer> getChoosePlayer1() {
        return choosePlayer1;
    }

    public LinkedList<Integer> getChoosePlayer2() {
        return choosePlayer2;
    }

    public LinkedList<String> getArrayTable() {
        return arrayTable;
    }

    public LinkedList<String> getAvailable() {
        return available;
    }

    public void resetArray(LinkedList<String> a) {

        if (a.isEmpty()) {
            a.add("0");
            a.add("1");
            a.add("2");
            a.add("3");
            a.add("4");
            a.add("5");
            a.add("6");
            a.add("7");
            a.add("8");

        }
    }

    public void initializationArray(){

        resetArray(getAvailable());
        resetArray(getArrayTable());
    }


    public void printTable(LinkedList<String> l) {


        Table st = new Table();
        st.setShowVerticalLines(true);
        //st.setHeaders("one", "two", "three");
        st.addRow(l.get(0), l.get(1), l.get(2));
        st.addRow(l.get(3), l.get(4), l.get(5));
        st.addRow(l.get(6), l.get(7), l.get(8));
        st.print();
    }

    public void printTableResultsAll(App app) {
        System.out.println("<-------- Current results -------->");
        Map<String,Object> data = app.getPlayer().FinalAll(app);
        Table st = new Table();
        st.setShowVerticalLines(true);
        st.setHeaders(app.getPlayer().getPlayer1(),app.getPlayer().getPlayer2());
        st.addRow(String.valueOf(data.get("WinPlayer1")),(String.valueOf(data.get("WinPlayer2"))));
        st.print();
    }

    public void saveProspectGame(App app , int location ) {


        if (app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer1())) {
            choosePlayer1.add(location);
            save.put(app.getPlayer().getPlayer1(), choosePlayer1);
        } else if (app.getPlayer().getInstanceName().equals(app.getPlayer().getPlayer2())) {

            choosePlayer2.add(location);
            save.put(app.getPlayer().getPlayer2(), choosePlayer2);

        }
        save.forEach((k,v) -> {
            System.out.println("key: " + k + ", value: " + v);
        });

    }



    public void availableArray (Integer location) {


            available.set(location, null);
            System.out.print("available: ");
            for (String n : available) {
                System.out.print(" " + ((n != null) ? n : ""));
            }
            System.out.println();
            Integer i = 0;
            for (Object ob : available) {
                if (ob == null) {
                    i += 1;
                }
            }
            if (i == 9) {
                System.out.println("nothing location");
                //System.out.println("Game over");

            }
        }

    @Override
    public void update(String eventType, App app) {
        this.arrayTable.set(app.getControl().getId(),(String) app.getPlayer().getData().get(app.getPlayer().getInstanceName()));
        printTable(this.arrayTable);
        saveProspectGame(app,app.getControl().getId());
        availableArray(app.getControl().getId());

    }
}
