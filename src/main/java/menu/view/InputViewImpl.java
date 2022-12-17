package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.dto.request.CoachNameDto;
import menu.dto.request.CoachesNameDto;
import menu.dto.request.HateMenuDto;

public class InputViewImpl implements InputView {

    @Override
    public CoachesNameDto sendCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.asList(Console.readLine().split(","));
        return coachNames.stream()
                .map(CoachNameDto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), CoachesNameDto::new));
    }

    @Override
    public HateMenuDto sendHateMenuBySpecificCoach(CoachNameDto coachNameDto) {
        System.out.println(coachNameDto.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        List<String> hateMenuNames = Arrays.asList(Console.readLine().split(","));
        return new HateMenuDto(hateMenuNames);
    }
}
