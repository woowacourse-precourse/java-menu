package menu.Controller;

import menu.domain.Category;
import menu.domain.CategoryRecommander;
import menu.domain.Coach;
import menu.domain.Member;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class RecommandController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Member member;

    public void start() {
        outputView.notifyStart();
        setMember();
        setNotEatingMenu();
        List<Coach> coaches = member.getCoaches();
        while(!coaches.get(coaches.size()-1).isFull()){
            coaches.get(0).flag = false;
            setRecommandMenu();
        }
        outputView.notifyResultNotice();
        outputView.printDay();
        outputView.printCategories(member.getCategoryNames());
        for (Coach coach : member.getCoaches()) {
            outputView.printMenus(coach.getRecommandMenus(), coach);
        }
        outputView.printEnd();
    }

    public void setRecommandMenu() {
        List<Coach> coaches = member.getCoaches();
            CategoryRecommander categoryRecommander = new CategoryRecommander();
            Category category = categoryRecommander.randomRecommandCategory();
            for (Coach coach : coaches) {
                member.addRecommandMenuToCoach(category, coach);
                coach.flag = false;
            }
    }

    public void setMember() {
        try {
            member = new Member(inputView.readNames());
        } catch (IllegalArgumentException e) {
            inputView.printErrorBy(e);
            setMember();
        }
    }

    public void setNotEatingMenu() {
        try {
            for (String coachNames : member.getNames()) {
                List<String> menus = inputView.readNotEatingMenus(coachNames);
                member.addNotEatingMenus(coachNames, menus);
            }
        } catch (IllegalArgumentException e) {
            inputView.printErrorBy(e);
            setNotEatingMenu();
        }
    }


}
