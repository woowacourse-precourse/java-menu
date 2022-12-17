package menu;

import menu.View.InputView;
import menu.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static menu.Constant.Message.*;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Recommender recommender;

    public void runController(){
        List<Coach> coaches = getCoachData();
        recommender = new Recommender(coaches);

    }

    private List<Coach> getCoachData(){
        List<Coach> coaches = new ArrayList<>();

        System.out.println(MSG_START);
        List<String> coachNames = getCoachNames();

        for(String name: coachNames){
            coaches.add(new Coach(name, getHateMenus(name)));
        }

        return coaches;
    }

    private List<String> getCoachNames(){
        System.out.println(MSG_GET_NAMES);
        return inputView.readCoaches();
    }

    private List<String> getHateMenus(String name){
        System.out.println(name + MSG_GET_HATEMENUS);
        return inputView.readHateMenus();
    }

    private void endRecommend(){

    }

}
