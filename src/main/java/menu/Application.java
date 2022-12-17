package menu;

import menu.controller.PartyController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PartyController partyController = new PartyController();
        partyController.startGathering();
    }
}
