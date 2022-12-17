package menu.controller;

import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Couch;
import menu.domain.CouchRepository;
import menu.view.OutputView;

public class Controller {

    public static void run() {
        CategoryRepository.initCategories();
        registerCouch();
        selectMenus();
        printMenus();
    }

    private static void registerCouch() {
        OutputView.printStartMessage();
        InputController.registerCouch();
    }

    private static void selectMenus() {
        while (CouchRepository.getSelectedCategories().size() < 5) {
            Category selectedCategory = CategoryRepository.pickRandomCategory();
            if (!CouchRepository.validateMenu(selectedCategory)) {
                continue;
            }
            CouchRepository.addCategory(selectedCategory);
//            System.out.println(CouchRepository.getSelectedCategories());
            for (Couch couch : CouchRepository.getCouches()) {
                addMenus(selectedCategory, couch);
            }
//            for (Couch couch : CouchRepository.getCouches()) {
//                System.out.println(couch.getName()+"못먹는메뉴"+couch.getUneatableMenus());
//                System.out.println(couch.getName()+"먹은메뉴"+couch.getEatenMenus());
//            }
        }
    }

    private static void addMenus(Category selectedCategory, Couch couch) {
        while (true) {
            String selectedMenu = CategoryRepository.pickMenu(selectedCategory);
            if (couch.validateMenu(selectedMenu)) {
                couch.addMenu(selectedMenu);
                break;
            }
        }

    }
    private static void printMenus() {
        OutputView.printMenu();
    }
}
