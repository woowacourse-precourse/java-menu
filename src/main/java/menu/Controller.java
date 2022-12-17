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
    public void recommendMenu(List<Coach> coachInfo){
        messageView.recommendMessage();
        AddCategory addCategory = new AddCategory();

        List<Menu> menu = new ArrayList<>();
        menu = addCategory.add(menu);

        for(int i=0; i<5; i++) {
            String Category = randomCategory(menu);
            String Menu = randomMenu(menu, Category);
        }
    }
    public String randomCategory(List<Menu> menu){
        Random random = new Random();
        return random.RandomCategory(menu);
    }
    public String randomMenu(List<Menu> menu,String Category){
        Random random = new Random();
        return random.RandomMenu(menu,Category);
    }
}
