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
            CouchRepository.validateMenu(selectedCategory);
            CouchRepository.addCategory(selectedCategory);
            System.out.println(CouchRepository.getSelectedCategories());
            //addMenus(selectedCategory);
        }


    }
    private static void addMenus(Category selectedCategory) {
        for (Couch couch : CouchRepository.getCouches()) {
            String selectedMenu = CategoryRepository.pickMenu(selectedCategory);
            //couch.validateMenu(selectedMenu);
            //couch.addMenu(selectedMenu);
        }
    }
}
