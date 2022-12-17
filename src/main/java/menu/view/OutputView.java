package menu.view;

import menu.domain.coach.Coach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public void printRecommendResult(List<Coach> coaches) {
        println("\n메뉴 추천 결과입니다.");
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        println("[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]");
        
        for (Coach coach : coaches) {
            List<String> results = new ArrayList<>();
            results.add(coach.name());
            results.addAll(coach.menuNames());
            
            println(results.stream()
                    .collect(Collectors.joining(" | ", "[ ", " ]")));
        }
    
        System.out.println("\n추천을 완료했습니다.");
    }
    
    public void printErrorMessage(IllegalArgumentException raisedException) {
        println(raisedException.getMessage());
    }
    
    private void println(String message) {
        System.out.println(message);
    }
}
