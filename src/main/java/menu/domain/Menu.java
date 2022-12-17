package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Menu {
    final List<List<String>> menuList = List.of(
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    private List<Integer> category;
    public Menu(List<Integer> category){
        this.category = category;
    };

    public String[] recommandMenu(List<String> inEdibleMenu) {
        List<String> rmdMenu = new ArrayList<>();
        while(rmdMenu.size() < 5) {
            List<String> menus = menuList.get(category.get(rmdMenu.size())-1);
            String menu = Randoms.shuffle(menus).get(0);
            if (isInEdibleMenu(inEdibleMenu, menu, rmdMenu))
                continue;
            rmdMenu.add(menu);
        }
        return rmdMenu.toArray(new String[rmdMenu.size()]);
    }

    public static boolean isInEdibleMenu(List<String> inEdibleMenu, String menu, List<String> rmdMenu) {
        for (int i = 0; i < inEdibleMenu.size(); i++) {
            if (inEdibleMenu.get(i).equals(menu))
                return true;
        }
        for (int i = 0; i < rmdMenu.size(); i++) {
            if (rmdMenu.get(i).equals(menu))
                return true;
        }
        return false;
    }
}
