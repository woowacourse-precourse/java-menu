package menu.controller;

import java.util.ArrayList;
import java.util.stream.IntStream;
import menu.model.Crew;
import menu.view.OutputView;

public class MenuContoller {
    private Crew crew;
    private  ArrayList<ArrayList<String>> crews;
    private InputController inputController;
    private OutputView outputView;
    private int crewsnumber;
    public MenuContoller(){
        inputController = new InputController();
        outputView = new OutputView();
    }

    public void initRecommand(){
        outputView.printStart();
        crew = inputController.getCrewsName();
        crew.setCrews();
        crews=crew.getCrews();
        crewsnumber = crews.size();
    }

    public void startRecommand(){
        setNotEat();

    }
    public void setNotEat(){
        IntStream.range(0,crewsnumber).forEach(i -> {
            inputController.setDislike(crew,i);
        }
        );
        crews = crew.getCrews();
//        System.out.println(crews);
    }
    public void getMenuRecommand(){

    }
    public void endRecommand(){

    }

}
