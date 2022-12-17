package menu.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import menu.model.Crew;
import menu.model.Menus;
import menu.model.PickCategory;
import menu.model.ResultBoard;
import menu.view.OutputView;

public class MenuContoller {
    private Crew crew;
    private Menus menus;
    private ResultBoard resultBoard;
    private PickCategory pickCategory;
    private ArrayList<ArrayList<String>> crews;
    private InputController inputController;
    private OutputController outputController;
    private OutputView outputView;
    private int crewsnumber;

    public MenuContoller() {
        inputController = new InputController();
        outputController = new OutputController();
        outputView = new OutputView();
        pickCategory = new PickCategory();
        menus = new Menus();
    }

    public void initRecommand() {
        outputView.printStart();
        crew = inputController.getCrewsName();
        crew.setCrews();
        crews = crew.getCrews();
        crewsnumber = crews.size();
    }

    public void startRecommand() {
        setNotEat();
        setRecommandCategory();
        setRecommandMenu();
    }

    public void setNotEat() {
        IntStream.range(0, crewsnumber).forEach(i -> {
                    inputController.setDislike(crew, i);
                }
        );
        crews = crew.getCrews();
//        System.out.println(crews);
    }

    public void setRecommandCategory() {
        resultBoard = new ResultBoard(crew);
        pickCategory.setRecommandCategory();
        resultBoard.setRecommandCategory(pickCategory.getRecommandCategory());
//        System.out.println(resultBoard.getRecommandCategory());   [일식, 중식, 한식, 양식, 아시안]
    }
    public void setRecommandMenu() {
        List<String> cat = pickCategory.getRecommandCategory();
        for (int i = 0; i < 5; i++) {
            String daily = cat.get(i);
            // check function for delete dislike and put in
            insertMenu(daily);
        }
    }
    public void insertMenu(String daily) {
        for (int i =0;i<crewsnumber ; i++) {
            String tmpMenu = menus.getMenu(daily);
            resultBoard.setCrewmenu(i,tmpMenu);
        }
    }

    public void endRecommand() {
        outputView.printResult();

        String text = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
        System.out.println(text);
        System.out.println();
        List<String> cat = pickCategory.getRecommandCategory();
        String up =cat.toString();
        System.out.println(up.replace(", ", "|"));



        System.out.println(resultBoard.getCrewmenu());
    }

}
