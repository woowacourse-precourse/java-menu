package menu.controller;

import menu.domain.Couch;
import menu.domain.CouchRepository;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;

public class InputController {

    public static void registerCouch() {
        while (true) {
            try {
                String[] names = InputView.readNames().split(",");
                for (String name : names) {
                    Couch couch = Couch.of(name);
                    CouchRepository.addCouch(couch);
                    registerUneatableMenus(couch);
                }
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void registerUneatableMenus(Couch couch) {
        while (true) {
            try {
                String[] menusInput = InputView.readUneatableMenus(couch);
                couch.setUneatableMenus(new ArrayList<String>(Arrays.asList(menusInput)));
                //System.out.println(couch.getUneatableMenus());
                return;
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
