package menu;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    MenuGame menuGame = new MenuGame();
    public void init(){
        outputView.printStart();
        makeCoaches();
        makeEachCoachesCantEatMenu();
        menuGame.makeMenuRecommend();
        outputView.printMenuResult(menuGame.getCoachMenus(),
                menuGame.getMenuRecommend().getCategorys());
    }

    private void makeEachCoachesCantEatMenu() {
        for(int i=0;i<menuGame.getCoaches().size();i++){
            while(true){
                try{
                    List<String> cantEatFoods = inputView.inputCantEatMenus(menuGame.getCoaches().get(i).getName());
                    menuGame.addFoodCoachCantEat(menuGame.getCoaches().get(i),cantEatFoods);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }
        }
    }

    private void makeCoaches() {
        List<String> coachesName;
        while(true){
            try{
                coachesName = inputView.inputCoaches();
                menuGame.makeCoaches(coachesName);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }
}
