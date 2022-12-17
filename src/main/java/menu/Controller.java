package menu;

import menu.service.Service;
import menu.utills.Converter;
import menu.utills.Validator;
import menu.utills.constants.CoachQuantity;
import menu.view.InputVIew;
import menu.view.OutputView;

import java.util.List;

public class Controller {
    private final Service service = new Service();

    public void run() {
        setMenus();
        OutputView.printStartMessage();
        List<String> coachNames = getCoachNames();
        List<List<String>> hateMenus = getHateMenu(coachNames);

    }

    private void setMenus() {
        service.setMenus();
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

    private List<List<String>> getHateMenu(List<String> coachs) {
        
    }

}
