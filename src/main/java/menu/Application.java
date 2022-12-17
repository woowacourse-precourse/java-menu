package menu;

import menu.businessLogic.SuggestProgram;

public class Application {

    private static final Initializer initializer = new Initializer();
    private static final SuggestProgram suggestProgram = new SuggestProgram();

    public static void main(String[] args) {
        initializer.initialize();
        suggestProgram.startProgram();
    }
}
