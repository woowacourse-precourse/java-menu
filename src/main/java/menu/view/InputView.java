package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.CoachException;
import menu.exception.InputException;
import menu.exception.NoMenuException;
import menu.model.Coach;
import menu.utils.Converter;

import java.util.List;

public class InputView {
    private final Converter converter;

    public InputView(Converter converter) {
        this.converter = converter;
    }

    public List<String> getCoachName() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        InputException coachException = new CoachException(converter);
        String names = verifyInput(coachException);
        return converter.convertToList(names);
    }

    public List<String> getNoMenu(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coach.getName());
        InputException noMenuException = new NoMenuException(converter);
        String menu = verifyInput(noMenuException);
        return converter.convertToList(menu);
    }

    private String verifyInput(InputException exception) {
        while (true) {
            try {
                String input = Console.readLine().trim();
                System.out.println();
                exception.verifyException(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
