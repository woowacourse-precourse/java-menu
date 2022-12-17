package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.FoodPeerCoaches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public FoodPeerCoaches readCoachPeers() {
        try{
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            return new FoodPeerCoaches(makeFoodPeerCoachByConsole());
        } catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            return readCoachPeers();
        }
    }

    private List<Coach> makeFoodPeerCoachByConsole() {
        List<String> coachNameDatas = Arrays.asList(Console.readLine().split(","));
        return makeStringListToCoach(coachNameDatas);
    }

    private List<Coach> makeStringListToCoach(List<String> coachList) {
        List<Coach> result = new ArrayList<>();
        for (String coach : coachList){
            result.add(new Coach(coach));
        }
        return result;
    }
}
