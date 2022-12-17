package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.CoachRepository;

public class InputView implements Input {
    @Override
    public CoachRepository getCoach() {
        System.out.println(System.lineSeparator()+"코치의 이름을 입력해 주세요. (, 로 구분)");
        try{
            return new CoachRepository(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getCoach();
        }
    }
}
