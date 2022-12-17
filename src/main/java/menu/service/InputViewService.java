package menu.service;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachList;
import menu.utils.parser.InputMenuParser;
import menu.utils.parser.InputNameParser;
import menu.view.InputView;

public class InputViewService {
    private final InputView inputView;

    public InputViewService() {
        inputView = new InputView();
    }

    public CoachList getReadCoachList() {
        try {
            String nameList = inputView.readName();

            return InputNameParser.parseInputName(nameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getReadCoachList();
        }
    }

    public List<String> getReadRemoveList(Coach coach) {
        try {
            String removeList = inputView.readRemoveList(coach);

            return InputMenuParser.parseInputMenu(removeList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getReadRemoveList(coach);
        }
    }

}
