package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.view.InputView;
import menu.view.OutputView;

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
        }
        start();
        System.out.println(coach[0]);
    }
    //카테고리
//    public void RandomNum(){
//        int[] randomNum;
//        while(randomNum.size() < 5) {
//            int num = Randoms.pickNumberInRange(1, 5); // 1~9까지
//            if (!randomNum.contains(num)) {
//                randomNum.add(num);
//                setNum.add(num);
//            }
//        }
//    }
}
