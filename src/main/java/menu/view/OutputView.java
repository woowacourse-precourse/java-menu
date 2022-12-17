package menu.view;

import menu.domain.Coach;

import java.util.List;

public class OutputView {

    public void notifyStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void notifyResultNotice(){
        System.out.println("메뉴 추천 결과입니다.");
    }

    public void printCategories(List<String> categories){
        categories.add(0,"카테고리");
        System.out.println(categories);
    }

    public void printMenus(List<String> menus, Coach coach){
        menus.add(0, coach.getName());
        System.out.println(menus);
    }

    public void printDay(){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printEnd(){
        System.out.println("추천을 완료했습니다.");
    }
}
