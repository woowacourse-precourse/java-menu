package menu.service;

import menu.domain.Coach;
import menu.domain.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.util.constant.CommandMessage;

import java.util.ArrayList;
import java.util.List;

public class CoachService {
    private final InputView in = new InputView();
    private final OutputView out = new OutputView();

//    public List<Coach> getCoaches(){
//        List<Coach> coaches = new ArrayList<>();
//        for(String name : readCoachNames()){
//            List<String> excludeFoods = in.readExcludeFoods();
//            coaches.add(new Coach(name, excludeFoods));
//        }
//        return coaches;
//    }
    public void setCoaches(){
        for(String name : readCoachNames()){
            out.print(name + CommandMessage.REQUEST_EXCLUDE.getMessage());
            List<String> excludeFoods = in.readExcludeFoods();
            CoachRepository.addCoach(new Coach(name, excludeFoods));
        }
    }
    private List<String> readCoachNames(){
        return in.readCoach();
    }



}
