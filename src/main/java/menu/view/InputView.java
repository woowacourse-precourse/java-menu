package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.MenuRecommendation;
import menu.domain.People;
import menu.domain.Person;
import menu.dto.input.ReadNamesDto;
import menu.dto.input.ReadUnavailableMenuDto;

public class InputView {
    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }


    public ReadNamesDto readNames() {
        print("코치의 이름을 입력해 주세요. (, 로 구분)");
        return new ReadNamesDto(readUserInput());
    }

    public ReadUnavailableMenuDto readUnavailableMenu() {
        People people = MenuRecommendation.getPeople();
        ReadUnavailableMenuDto readUnavailableMenuDto = new ReadUnavailableMenuDto();
        for (Person person : people) {
            print(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", person.getName()));
            String input = readUserInput();
            readUnavailableMenuDto.add(input);
        }
        return readUnavailableMenuDto;
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String readUserInput() {
        return Console.readLine();
    }
}
