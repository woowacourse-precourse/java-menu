package menu;

import menu.controller.LunchMenuController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        LunchMenuController lunchMenuController = new LunchMenuController();
        lunchMenuController.start();
    }
}
