package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
            String inputs = inputView.getNames();
            List<String> names = Arrays.asList(inputs.split(","));
            return new Crew(names);
        }catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("[ERROR] Wrong input Number Format");
        }

    }

}
