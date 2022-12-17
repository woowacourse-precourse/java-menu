package menu;

import menu.controller.MenuContoller;

public class Application {
    public static void main(String[] args) {
        MenuContoller menuContoller = new MenuContoller();
        try{
            menuContoller.initRecommand();
            menuContoller.startRecommand();
//            menuContoller.endRecommand();
        }catch (IllegalArgumentException e){

        }
    }
}
