package menu.IO;

import menu.model.Category;

import java.util.List;

public class OutputView {
    public void startMsg(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void newLine(){
        System.out.println();
    }

    public void promptReadCoachName(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void promptDontEatMenuCoach(String name){
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public  void printResult(List<String> coachNames, List<Category> categories, List<List<String>> recomededMenus){
        System.out.println("메뉴 추천 결과입니다.");
        System.out.print("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n[ 카테고리 ");
        for (Category category: categories){
            System.out.print("| " + categoryConvertor(category) + " ");
        }
        System.out.println("]");
        for (int i = 0; i<coachNames.size(); i++){
            System.out.print("[ " + coachNames.get(i) + " ");
            for(int j = 0; j<5; j++){
                System.out.print("| " + recomededMenus.get(i).get(j) + " ");
            }
            System.out.println("]");
        }
    }

    public void endingMsg(){
        System.out.println("추천을 완료했습니다.");
    }

    public String categoryConvertor(Category category){
        if(category == Category.JAPANESE)
            return "일식";
        if(category == Category.KOREAN)
            return "한식";
        if(category == Category.CHINESE)
            return "중식";
        if(category == Category.ASIAN)
            return "아시안";
        if(category == Category.WESTERN)
            return "양식";
        return null;
    }

    public void printError(Exception e){
        System.out.println(e.getMessage());
    }
}
