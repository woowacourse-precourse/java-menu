package menu.view;

import menu.domain.Category;
import menu.domain.Couch;
import menu.domain.CouchRepository;

import java.util.StringJoiner;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");

    }

    public static void printMenu() {
        printForMat();
        printCategories();
        printDishes();
    }

    private static void printForMat() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    private static void printCategories() {
        StringJoiner stringJoinerForCategory = new StringJoiner(" | ", "[ ", " ]");
        stringJoinerForCategory.add("카테고리");
        for (Category category : CouchRepository.getSelectedCategories()) {
            stringJoinerForCategory.add(category.getName());
        }
        System.out.println(stringJoinerForCategory);
    }

    private static void printDishes() {
        for (Couch couch : CouchRepository.getCouches()) {
            StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
            stringJoiner.add(couch.getName());
            for (String menu : couch.getEatenMenus()) {
                stringJoiner.add(menu);
            }
            System.out.println(stringJoiner);
        }
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
