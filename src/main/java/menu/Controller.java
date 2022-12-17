package menu;

import menu.domain.MenuRepository;
import menu.service.Service;
import menu.utills.Converter;
import menu.utills.Validator;
import menu.utills.constants.CoachQuantity;
import menu.utills.constants.HateMenuQuantity;
import menu.view.InputVIew;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Service service = new Service();

    public void run() {
        setMenus();
        OutputView.printStartMessage();
        setCoach();
        recommend();
        printResult();
    }

    private void setMenus() {
        service.setMenus();
    }

    private void setCoach() {
        List<String> coachNames = getCoachNames();
        List<List<String>> hateMenus = getHateMenu(coachNames);
        service.setCoach(coachNames, hateMenus);
    }

    private void recommend() {
        service.recommend();
    }

    private void printResult() {
        OutputView.printFinalMessage();
        OutputView.printCategoryResult(service.getCategoryString());
        OutputView.printRecommendResult(service.getRecommendedResult());
    }

    private List<String> getCoachNames() {
        try {
            String coachNameInput = InputVIew.getCoachNameInput();
            List<String> coachNames = Converter.toListByDelimiter(coachNameInput);
            Validator.isInSize(coachNames, CoachQuantity.MIN.getQuantity(), CoachQuantity.MAX.getQuantity());
            Validator.containDuplicate(coachNames);
            Validator.checkLength(coachNames);
            return coachNames;
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getCoachNames();
        }
    }

    private List<List<String>> getHateMenu(List<String> coaches) {
        List<List<String>> hateMenuList = new ArrayList<>();
        for (String coach : coaches) {
            hateMenuList.add(getHateMenuByCoach(coach));
        }
        return hateMenuList;
    }

    private List<String> getHateMenuByCoach(String coach) {
        try {
            String hatMenuInput = InputVIew.getHateMenu(coach);
            if (hatMenuInput.isBlank()) {
                return null;
            }
            List<String> hateMenus = Converter.toListByDelimiter(hatMenuInput);
            Validator.containDuplicate(hateMenus);
            Validator.isInSize(hateMenus, HateMenuQuantity.MIN.getQuantity(), HateMenuQuantity.MAX.getQuantity());
            checkExistedMenuName(hateMenus);
            return hateMenus;
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getHateMenuByCoach(coach);
        }
    }

    private void checkExistedMenuName(List<String> hateMenus) {
        for (String menuName : hateMenus) {
            MenuRepository.getMenuByName(menuName);
        }
    }
}
