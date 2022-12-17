package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.model.Crew;
import menu.view.InputView;

public class InputController {
    private InputView inputView;
    public InputController(){
        inputView = new InputView();
    }
    public Crew getCrewsName(){
        try{
            String names = inputView.getNames();
            return new Crew(new ArrayList<>(List.of(names)));
        }catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("[ERROR] Wrong input Number Format");
        }

    }

}
