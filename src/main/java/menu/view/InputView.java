package menu.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Coach;

public class InputView {

	// 코치 이름 입력후 코치 객체 반환
	public List<Coach> readCoachNames() {
		Message.printMessage(Message.INPUT_COACH_NAMES);
		String[] coaches = Console.readLine().split(",");

		//TODO : COACH 예외 검사 (코치의 이름은 2~4)
		//TODO : COACH 예외 검사 (코지는 2 ~ 5명 사이)

		//TODO : Stream 리팩터링
		List<Coach> coachList = new ArrayList<>();
		for (int i = 0; i < coaches.length; i++) {
			coachList.add(new Coach(coaches[i]));
		}
		return coachList;
	}

}
