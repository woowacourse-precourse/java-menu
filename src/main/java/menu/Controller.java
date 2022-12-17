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
        for(int i=0; i<name.size(); i++) {
            List<String> notEatFood = new ArrayList<>();
            messageView.coachNotEatMessage(name.get(i));
            notEatFood = inputView.coachCantEatInput();
            coachInfo.add(new Coach(name.get(i),notEatFood));
        }
        return coachInfo;
    }
    public List<Result> recommendMenu(List<Coach> coachInfo){
        Recommend recommend = new Recommend();
        messageView.recommendMessage();
        return recommend.recommend(coachInfo);
    }

}
