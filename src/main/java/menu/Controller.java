package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    MessageView messageView = new MessageView();
    InputView inputView = new InputView();

    public void run(){
        messageView.serviceStartMessage();
        recommendMenu(coachNotEatMenu(coachName()));
    }

    public List<String> coachName(){
        messageView.coachNameMessage();
        return inputView.coachNameInput();
    }

    public List<Coach> coachNotEatMenu(List<String> name){
        List<Coach> coachInfo= new ArrayList<>();
        List<String> notEatFood;
        for (String coachName : name) {
            messageView.coachNotEatMessage(coachName);
            notEatFood = inputView.coachCantEatInput();
            coachInfo.add(new Coach(coachName, notEatFood));
        }
        return coachInfo;
    }

    public void recommendMenu(List<Coach> coachInfo){
        Recommend recommend = new Recommend();
        messageView.recommendMessage();
        recommend.recommend(coachInfo);
    }

}
