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
        menu = new Menu();
    }

    public void initRecommand() {
        outputView.printStart();
        crew = inputController.getCrewsName();
        crew.setCrews();
        crews = crew.getCrews();
        crewsnumber = crews.size();
    }
//        System.out.println(crews.get(0));
//        crews.get(0).add("dd");
//        crews.get(0).add("pp");
//        crews.get(1).add("dd");
//        System.out.println(crews.get(0).get(0));
//        System.out.println(crews.get(0).get(1));
//        System.out.println(crews.get(0).get(2));
//        System.out.println(crews.get(1).get(1));
//        for(int i =0 ;i<crewsnumber ;i++)
//        {
//            System.out.println(crews.get(i));
//        }

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
            menus.getMenu(daily);
        }
    }
    public void endRecommand() {

    }

}
