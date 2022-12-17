package menu;

import java.util.List;

public class MessageView {
    public void serviceStartMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    public void coachNameMessage(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }
    public void coachNotEatMessage(String name){
        System.out.println(name +"(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void recommendMessage(){
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }
    public void recommendCategoryMessage( List<String> Category){
        System.out.println("[ 카테고리 | "+Category.get(0)+" | "+Category.get(1)+" | "+Category.get(2)+" | "+Category.get(3)+" | "+Category.get(4)+" ]");
    }
    public void recommendResultMessage( List<Result> Menu){
        for(int i=0; i<Menu.size(); i++){
            System.out.println("[ "+Menu.get(i).name+" | "+Menu.get(i).food.get(0)+" | "+Menu.get(i).food.get(1)+" | "+Menu.get(i).food.get(2)+" | "+Menu.get(i).food.get(3)+" | "+Menu.get(i).food.get(4)+" ]");
        }
    }

}
