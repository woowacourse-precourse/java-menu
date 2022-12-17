package menu.controller;

import menu.model.Crew;

public class MenuContoller {
    private Crew crews;
    private InputController inputController;
    public MenuContoller(){
        inputController = new InputController();
    }

    public void initRecommand(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println("");
        crews = inputController.getCrewsName();
        crews.setCrews();
        System.out.println(crews.getCrews());
        System.out.println(crews.getNamesToString());
    }
    public void startRecommand(){

    }
    public void endRecommand(){

    }

}
