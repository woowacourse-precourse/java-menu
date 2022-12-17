package menu.controller;

import java.util.ArrayList;
import menu.model.Crew;
import menu.view.OutputView;

public class MenuContoller {
    private Crew crew;
    private  ArrayList<ArrayList<String>> crews;
    private InputController inputController;
    private OutputView outputView;
    public MenuContoller(){
        inputController = new InputController();
        outputView = new OutputView();
    }

    public void initRecommand(){
        outputView.printStart();
        crew = inputController.getCrewsName();
        crew.setCrews();
        crews=crew.getCrews();

    }
    public void startRecommand(){
        getNotEat();
    }
    public void getNotEat(){

    }
    public void endRecommand(){

    }

}
