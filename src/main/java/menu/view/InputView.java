package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.MenuRecommendation;
import menu.domain.People;
import menu.domain.Person;
import menu.dto.input.ReadNamesDto;
import menu.dto.input.ReadUnavailableMenuDto;

public final class InputView {
    private static final String DELIMITER = ",";

    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }


    public ReadNamesDto readNames() {
        print(ViewMessage.INPUT_COACH_NAMES);
        return new ReadNamesDto(readUserInput());
    }

    public ReadUnavailableMenuDto readUnavailableMenu() {
        People people = MenuRecommendation.getPeople();
        ReadUnavailableMenuDto readUnavailableMenuDto = new ReadUnavailableMenuDto();
        for (Person person : people) {
            print(String.format(ViewMessage.INPUT_UNAVAILABLE_MENUS, person.getName()));
            readUnavailableMenuDto.add(readUserInput());
        }
        return readUnavailableMenuDto;
    }

    private String readUserInput() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.println(message);
    }

    private static class ViewMessage {
        private static final String INPUT_COACH_NAMES = String.format("코치의 이름을 입력해 주세요. (%s 로 구분)", DELIMITER);
        private static final String INPUT_UNAVAILABLE_MENUS = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    }
}
