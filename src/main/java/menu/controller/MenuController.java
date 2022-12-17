package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.BannedFoods;
import menu.domain.Crew;
import menu.domain.Crews;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private Crews crews;
    private BannedFoods bannedFoods = new BannedFoods();

    public void run() {
        /**
         * Todo
         * 1. 코치 이름 받기
         * 2. n명의 코치에 대해 못 먹는 메뉴 입력 받기
         * 3. 요일별 카테고리 채우기
         * 4. 요일별 코치들의 음식 채우기
         */

        crews = new Crews(getCrews());
        getBannedFoods();

        // 3. 요일별 카테고리 채우기

        // 4. 요일별 코치들의 음식 채우기
    }

    private void getBannedFoods() {
        int crewSize = crews.getCrews().size();
        fillBannedFoods(crewSize);
    }

    private void fillBannedFoods(int crewSize) {
        for(int i=0; i<crewSize; i++) {
            Crew crew = crews.getCrews().get(i);
            outputView.printRequestOfBannedFoods(crew.getName());
            String foods = inputView.readBannedFoods();
            Arrays.stream(foods.split(","))
                    .forEach(name -> bannedFoods.addBannedFood(name));
        }
    }

    private List<Crew> getCrews() {
        outputView.printRequestCrewsName();
        String crewsName = inputView.readCrewsName();
        return Arrays.stream(crewsName.split(","))
                .map(name -> new Crew(name))
                .collect(Collectors.toList());
    }
}
