package menu;

import menu.Domain.CategoryGenerator;
import menu.Util.CategoryAndFood;
import menu.Util.FileInput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Recommander recommander = new Recommander();
        recommander.run();
    }
}
