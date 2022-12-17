package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    MessageView messageView = new MessageView();
    InputView inputView = new InputView();
    public void run(){
        messageView.serviceStartMessage();
        coachNotEatMenu(coachName());

        recommendMenu();
    }
    public List<String> coachName(){
        messageView.coachNameMessage();
        return inputView.coachNameInput();
    }
    public void coachNotEatMenu(List<String> name){
        for(int i=0; i<name.size(); i++) {
            List<Coach> coachInfo = new ArrayList<>();
            List<String> notEatFood = new ArrayList<>();
            messageView.coachNotEatMessage(name.get(i));
            notEatFood = inputView.coachCantEatInput();
            coachInfo.add(new Coach(name.get(i),notEatFood));
        }
    }
    public void recommendMenu(){
        AddCategory addCategory = new AddCategory();
        List<Menu> menu = new ArrayList<>();
        menu = addCategory.add(menu);
    }
}
