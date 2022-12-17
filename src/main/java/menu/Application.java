package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import input.Input;
import view.View;

public class Application {
    //코치들 담는 List
    //코치 : 못먹는 음식, 추천 음식
    public static String[] coachNamesArr; //이거 리스트로 바꿔 그리고 이넘 사용 고려해봐
    public static List<List<String>> coachesHateFood;

    public static void main(String[] args) {
        init();
        //점심 메뉴 추천을 시작합니다.
        View.showMenuRecommendGuideMessage();

        //코치의 이름을 입력해 주세요. (, 로 구분)
        View.showCoachNameGuideMessage();
        String coachNames = Input.input();
        coachNamesArr = coachNames.split(",");


        //토미(이)가 못 먹는 메뉴를 입력해 주세요.
        for(int i=0;i< coachNamesArr.length;i++) {
            View.showHateFoodGuideMessage(coachNamesArr[i]);
            String hateFoodInput = Input.input();
            String[] hateFoodsArr = hateFoodInput.split(",");
            coachesHateFood.add(Arrays.asList(hateFoodsArr));

        }

    }

    private static void init() {
        coachesHateFood = new ArrayList<>();
    }
}
