package menu;

import java.util.List;

public class OutputView {
    public void printServiceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printServiceEnd(List<ServiceModel> serviceModel, List<String> selectedCategory) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(selectedCategory);
        printMenuList(serviceModel);
        System.out.println("추천을 완료했습니다.");
    }

    public void printCategory(List<String> selectedCategory) {
        System.out.print("[ 카테고리 ");
        for (int i = 0; i < selectedCategory.size(); i++) {
            System.out.print(String.format("| %s ", selectedCategory.get(i)));
        }
        System.out.println("]");
    }

    public void printMenuList(List<ServiceModel> serviceModel) {
        for (int i = 0; i < serviceModel.size(); i++) {
            System.out.print(String.format("[ %s ", serviceModel.get(i).getCoachName()));
            printMenu(serviceModel.get(i).getEatMenu());
            System.out.println("]");
        }
    }

    public void printMenu(List<String> menuList) {
        for (int i = 0; i < menuList.size(); i++) {
            System.out.print(String.format("| %s ", menuList.get(i)));
        }
    }

    public void printRequireCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRequireCantEatMenu(String coachName) {
        System.out.println(String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName));
    }
}