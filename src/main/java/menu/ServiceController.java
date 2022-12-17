package menu;

import java.util.ArrayList;
import java.util.List;

public class ServiceController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    InputException inputException = new InputException();
    List<CoachModel> serviceModel = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<String> selectedCategory = new ArrayList<>();

    public void runService() {
        initService();
        outputView.printServiceEnd(serviceModel, selectedCategory);
    }

    public void initService() {
        outputView.printServiceStart();
        initCoach();
        initCantEatMenu();
    }

    public void initCoach() {
        String coachNames;
        String[] coachNameList;
        outputView.printRequireCoachName();
        coachNames = inputView.readInput();
        coachNameList = coachNames.split(",");
        while (inputException.exceptionCoach(coachNameList)) {
            coachNames = inputView.readInput();
            coachNameList = coachNames.split(",");
        }
        makeServiceModel(coachNameList);
    }

    public void initCantEatMenu() {
        String menus;
        String[] menuList;
        for (int i = 0; i < serviceModel.size(); i++) {
            outputView.printRequireCantEatMenu(serviceModel.get(i).getName());
            menus = inputView.readInput();
            menuList = menus.split(",");
            while (inputException.exceptionMenu(menuList)) {
                menus = inputView.readInput();
                menuList = menus.split(",");
            }
            serviceModel.get(i).makeCantEatMenu(menuList);
        }
    }

    public void makeServiceModel(String[] coachNames) {
        for (int i = 0; i < coachNames.length; i++) {
            CoachModel coachModel = new CoachModel(coachNames[i]);
            serviceModel.add(coachModel);
        }
    }
}
