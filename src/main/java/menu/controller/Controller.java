package menu.controller;

import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Couch;
import menu.domain.CouchRepository;

public class Controller {

    public static void run() {
        registerCouch();
        pickMenus();
    }

    private static void registerCouch() {
        InputController.registerCouch();
    }

    private static void pickMenus() {
        while (true) {
            selectMenus();
            //validateMenus();
        }

    }

    private static void selectMenus() {
        while (CouchRepository.getSelectedCategories().size() < 5) {
            Category selectedCategory = CategoryRepository.pickRandomCategory();
            if (!CouchRepository.validateMenu(selectedCategory)) {
                continue;
            }
            CouchRepository.addCategory(selectedCategory);
            System.out.println(CouchRepository.getSelectedCategories());
            addMenus(selectedCategory);
            for (Couch couch : CouchRepository.getCouches()) {
                System.out.println(couch.getName()+"못먹는메뉴"+couch.getUneatableMenus());
                System.out.println(couch.getName()+"먹은메뉴"+couch.getEatenMenus());
            }
        }


    }
    private static void addMenus(Category selectedCategory) {
        for (Couch couch : CouchRepository.getCouches()) {
            while (true) {
                String selectedMenu = CategoryRepository.pickMenu(selectedCategory);
                if (couch.validateMenu(selectedMenu)) {
                    couch.addMenu(selectedMenu);
                    break;
                }
            }
        }
    }
}
