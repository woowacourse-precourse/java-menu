package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.MenuRecommendator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputview;
    private final  OutputView outputView;
    private Coaches coaches;


    public Controller(InputView inputview, OutputView outputView){
        this.inputview = inputview;
        this.outputView = outputView;
    }

    public void run(){
        outputView.printProgramStart();
        coaches = initCoachesInformation();
        initInedibleMenu();
        MenuRecommendator menuRecommendator = new MenuRecommendator();
        menuRecommendator.recommendMenu(coaches);
        outputView.printRecommendResult(coaches, menuRecommendator.getCategories());
        outputView.printProgramEnd();
    }

    private Coaches initCoachesInformation(){
        try{
            return new Coaches(inputview.readCoachNames());
        } catch(IllegalArgumentException error) {
            OutputView.printError(error.getMessage());
            return initCoachesInformation();
        }
    }

    private void initInedibleMenu(){
        for(Coach coach : coaches.getCoaches()){
            coach.addInedibleMenus(getInedibleMenu(coach));
        }
    }

    private List<String> getInedibleMenu(Coach coach){
        try{
            List<String> inputInedibleMenus = inputview.readInedibleMenus(coach.getName());
            Menu.validateExistedMenus(inputInedibleMenus);
            return inputInedibleMenus;
        } catch (IllegalArgumentException error){
            OutputView.printError(error.getMessage());
            return getInedibleMenu(coach);
        }
    }
}
