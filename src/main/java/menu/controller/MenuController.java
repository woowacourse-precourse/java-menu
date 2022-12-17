package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.view.InputView;
import menu.view.OutputView;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    public void run() {
        start();
    }

    private void start() {
        String a = "";
        a = InputView.mainInput();
        String[] coach = a.split(",");
        if (coach.length < 2 || coach.length > 5){
            throw new IllegalArgumentException("코치 인원을 재설정 해주세요(2~5명 사이)");
            //OutputView.printError("코치 인원을 재설정 해주세요(2~5명 사이)");
            //start();
        }

        //못먹는 음식 검사해야함(0~2개)
        for (int i = 0; i < coach.length; i++) {
            InputView.notFoodInput(coach[i]);
        }

        OutputView.printResult();

        RandomNum(coach);
    }
    //카테고리
    public void RandomNum(String[] coach){
        List<String> one = Lists.newArrayList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
        List<String> two = Lists.newArrayList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        List<String> three = Lists.newArrayList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        List<String> four = Lists.newArrayList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
        List<String> five = Lists.newArrayList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
        List<Integer> randomNum = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int num = Randoms.pickNumberInRange(1, 5);
            randomNum.add(num);
        }
        int[] index = new int[6];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            index[randomNum.get(i)]++;
        }
        for (int i = 0; i < 5; i++) {
            if (index[i] > max) {
                max = index[i];
            }
        }
        if (max >= 3) {
            RandomNum(coach);
        } else {
            String category = "[ 카테고리 | ";
            for (int i = 0; i < 5; i++) {
                if (randomNum.get(i) == 1) {
                    String menu = Randoms.shuffle(one).get(0);
                    category = category + "일식 | ";
                } else if (randomNum.get(i) == 2) {
                    category = category + "한식 | ";
                } else if (randomNum.get(i) == 3) {
                    category = category + "중식 | ";
                } else if (randomNum.get(i) == 4) {
                    category = category + "아시안 | ";
                } else if (randomNum.get(i) == 5) {
                    category = category + "양식 | ";
                }
            }
            category = category.substring(0, category.length() - 2) + "]";
            System.out.println(category);

            for (int i = 0; i < coach.length; i++) {
                String co = "[ " + coach[i] + " | ";
                for (int j = 0; j < 5; j++) {
                    if (randomNum.get(i) == 1) {
                        String mn = Randoms.shuffle(one).get(0);
                        co = co + mn + " | ";
                        category = category + "일식 | ";
                    } else if (randomNum.get(i) == 2) {
                        String mn = Randoms.shuffle(two).get(0);
                        co = co + mn + " | ";
                        category = category + "한식 | ";
                    } else if (randomNum.get(i) == 3) {
                        String mn = Randoms.shuffle(three).get(0);
                        co = co + mn + " | ";
                        category = category + "중식 | ";
                    } else if (randomNum.get(i) == 4) {
                        String mn = Randoms.shuffle(four).get(0);
                        co = co + mn + " | ";
                        category = category + "아시안 | ";
                    } else if (randomNum.get(i) == 5) {
                        String mn = Randoms.shuffle(five).get(0);
                        co = co + mn + " | ";
                        category = category + "양식 | ";
                    }
                }
                co = co.substring(0, co.length() - 2) + "]";
                System.out.println(co);

            }
            System.out.println();
            OutputView.printFinish();
        }

        //System.out.println(max);

    }
}
