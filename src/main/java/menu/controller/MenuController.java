package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.view.InputView;
import menu.view.OutputView;

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
        RandomNum();
        System.out.println(coach[0]);
    }
    //카테고리
    public void RandomNum(){
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
            RandomNum();
        }
        System.out.println(randomNum);
        System.out.println(max);

    }
}
