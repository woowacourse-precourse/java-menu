package menu;

import menu.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            MenuGame menuGame = new MenuGame();
            menuGame.start();
        }catch(IllegalArgumentException illegalArgumentException){
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
        }
    }
}
