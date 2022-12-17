package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.CoachNamesDto;
import menu.dto.CoachDto;
import menu.dto.CoachesDto;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private InputView() {}

    public CoachNamesDto readCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String names = Console.readLine();
        printBlankLine();
        InputValidator.validateCoachNames(names);
        return new CoachNamesDto(List.of(names.split(",")));
    }

    public CoachesDto readNoEats(CoachNamesDto coachNamesDto) {
        return coachNamesDto.getNames().stream()
                .map(this::readNoEat)
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), CoachesDto::new));
    }

    private CoachDto readNoEat(String coachName) {
        System.out.println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName));
        String noEat = Console.readLine();
        printBlankLine();
        InputValidator.validateNoEat(noEat);
        return new CoachDto(coachName, List.of(noEat.split(",")));
    }

    private void printBlankLine() {
        System.out.println();
    }
}
