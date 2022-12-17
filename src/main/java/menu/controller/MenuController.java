package menu.controller;

import menu.domain.Coach;
import menu.domain.Coachs;
import menu.domain.WeekDiet;
import menu.dto.WeekDietDto;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    public void start(){
        Coachs coachs = inputCoachNames();
        inputCoachInedibles(coachs);
        OutputView.printWeekDiet(
                WeekDietDto.from(recommandMenus(coachs))
        );
        OutputView.printOver();
    }

    private Coachs inputCoachNames(){
        try{
            return Coachs.from(InputView.inputCoachNames());
        }catch(IllegalArgumentException e){
            OutputView.printErrorMsg(e.getMessage());
            return inputCoachNames();
        }
    }

    private void inputCoachInedibles(Coachs coachs){
        try{
            for(Coach coach : coachs.getCoachs()){
                coach.addInedibles(InputView.inputCoachInedibles(coach.getName()));
            }
        }catch(IllegalArgumentException e){
            OutputView.printErrorMsg(e.getMessage());

            for(Coach coach : coachs.getCoachs()){
                coach.clearInedibles();
            }

            inputCoachInedibles(coachs);
        }
    }

    private WeekDiet recommandMenus(Coachs coachs){
        try{
            WeekDiet weekDiet = new WeekDiet();
            weekDiet.generateFoodCataegories();
            weekDiet.generateDietByCoachs(coachs);
            return weekDiet;
        }catch(IllegalArgumentException e){
            OutputView.printErrorMsg(e.getMessage());
            return recommandMenus(coachs);
        }

    }
}
