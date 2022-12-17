package menu.view;

import menu.domain.coach.Coach;

public class OutputView {
    public void printApplicationStartGuide() {
        println("점심 메뉴 추천을 시작합니다.");
    }
    
    public void printInputCoachNamesGuide() {
        println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }
    
    public void printInputUneatableMenuGuide(String coachName) {
        System.out.printf("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coachName);
    }
    
    public void printErrorMessage(IllegalArgumentException raisedException) {
        println(raisedException.getMessage());
    }
    
    private void println(String message) {
        System.out.println(message);
    }
}
