package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.dto.request.CoachNameDto;

public class InputViewImpl implements InputView {

    @Override
    public List<CoachNameDto> sendCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNames = Arrays.asList(Console.readLine().split(","));
        return coachNames.stream()
                .map(CoachNameDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Coach sendHateMenuBySpecificCoach(CoachNameDto coachNameDto) {
        System.out.println(coachNameDto.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        List<String> hateMenuNames = Arrays.asList(Console.readLine().split(","));
        return new Coach(coachNameDto.getName(), hateMenuNames);
    }
}
