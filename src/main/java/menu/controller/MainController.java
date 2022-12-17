package menu.controller;

import menu.model.Coach;
import menu.model.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputview) {
        this.inputView = inputView;
        this.outputView = outputview;
    }

    public void service() {
        List<Coach> coachs = new ArrayList<>();
        outputView.startMessage();
        inputView.readCoachName().stream()
                .forEach(e -> coachs.add(new Coach(e, inputView.readCantEats(e))));
        outputView.resultMessage();
        List<String> categorys = Menu.selectCategory();
        outputView.LineMessage("카테고리", categorys);

        categorys.stream().forEach(i -> {
                    coachs.stream().forEach(j -> j.addMenu(Menu.selectMenu(i, j.getCantEats(), j.getMenu())));
                }
        );

        coachs.stream().forEach(e -> {
            outputView.LineMessage(e.getName(), e.getMenu());
        });

        outputView.endMessage();
    }
}
