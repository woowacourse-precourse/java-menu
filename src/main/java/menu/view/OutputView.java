package menu.view;

import menu.domain.Category;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    StringBuilder sb;
    StringBuilder sb2;
    StringJoiner sj;

    public OutputView(){
        sb = new StringBuilder();
        sb2 = new StringBuilder();
    }

    public void printStartGuide(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printNameInputGuide(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printError(String errorMessage){
        System.out.println("[ERROR]" +  errorMessage);
    }

    public void printHateMenuInputGuide(String name){
        System.out.printf("%d(이)가 못 먹는 메뉴 입력해 주세요.");
    }

    public void printResult(List<String> dayOfWeek, List<String> thisWeekCategories, Map<String, List<String>> ateMenuNamesByCoachName){
        System.out.println("메뉴 추쳔 결과입니다.");
        System.out.println(getResult(dayOfWeek, thisWeekCategories, ateMenuNamesByCoachName));
        System.out.println("\n추천을 완료했습니다.");
    }

    public String getResult(List<String> dayOfWeek, List<String> thisWeekCategories, Map<String, List<String>> ateMenuNamesByCoachName){
        sb.setLength(0);
        return sb.append(createWeekGuide(dayOfWeek))
                .append("\n")
                .append(createCategoryGuide(thisWeekCategories))
                .append("\n")
                .append(getRecommendationStatusGuide(ateMenuNamesByCoachName))
                .toString();
    }

    private String createWeekGuide(List<String> dayOfWeek){
        sj = new StringJoiner(" | ", "[","]");
        sj.add("구분");
        for (String day : dayOfWeek) {
            sj.add(day);
        }
        return sj.toString();
    }

    private String createCategoryGuide(List<String> thisWeeKCategoryNames){
        sj = new StringJoiner(" | ", "[","]");
        sj.add("카테고리");
        for (String categoryName : thisWeeKCategoryNames) {
            sj.add(categoryName);
        }
        return sj.toString();
    }

    private String getRecommendationStatusGuide( Map<String, List<String>> ateMenuNamesByCoachName){
        sb2.setLength(0);
        for (String coachName : ateMenuNamesByCoachName.keySet()) {
            sb2.append(getEachRecommendationStatusGuide(ateMenuNamesByCoachName, coachName))
                    .append("\n");
        }
        return sb.toString().trim();
    }

    private String getEachRecommendationStatusGuide(Map<String, List<String>> ateMenuNamesByCoachName, String coachName) {
        sj = new StringJoiner(" | ", "[","]");
        sj.add(coachName);
        for (String ateMenuName : ateMenuNamesByCoachName.get(coachName)) {
            sj.add(ateMenuName);
        }
        return sj.toString();
    }

}
