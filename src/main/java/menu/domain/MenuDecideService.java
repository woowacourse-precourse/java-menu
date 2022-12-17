package menu.domain;

public class MenuDecideService {
    public Coach makeCoach(String name) {
        return new Coach(name);
    }
}
