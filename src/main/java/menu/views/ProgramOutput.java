package menu.views;

import menu.domains.Categories;
import menu.domains.Coach;

import java.util.List;

public class ProgramOutput {

    public void suggestProgramStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRequestCoachNames(){
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRequestNotHaveMenu(String coachName){
        System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n",coachName);
    }

    public void printSuggestedMenuResult(List<Categories> categories, List<Coach> coaches){
        System.out.println("\n메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]\n",
                categories.get(0),categories.get(1).name(),categories.get(2).name(),categories.get(3).name(),categories.get(4).name());

        for (Coach coach : coaches) {
            printOneCoachMenus(coach);
        }
    }

    private void printOneCoachMenus(Coach coach){
        List<String> menus = coach.getSuggestedMenus();
        System.out.printf("[ %s | %s | %s | %s | %s | %s ]\n",
                coach.getName(),menus.get(0),menus.get(1),menus.get(2),menus.get(3),menus.get(4));
    }

    public void printSuggestingEnd(){
        System.out.print("\n추천을 완료했습니다.");
    }

    public static void printStatement(String errorMessage){
        System.out.println(errorMessage);
    }
}
